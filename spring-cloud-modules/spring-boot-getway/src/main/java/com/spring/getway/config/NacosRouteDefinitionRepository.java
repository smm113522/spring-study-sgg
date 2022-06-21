package com.spring.getway.config;

import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/**
 *
 */
@Component
public class NacosRouteDefinitionRepository implements RouteDefinitionRepository, ApplicationContextAware {

    @Autowired
    private NacosConfigProperties nacosConfigProperties;

    private final String dataId = "gatewayId";

    private final String groupId = "gatewayGroup";

    public Flux<RouteDefinition> getRouteDefinitions() {
        List<RouteDefinition> list = new ArrayList();
        try {
            //获取组名是gatewayGroup，dataId是gatewayId的配置。5000代表超时时间
            String content = nacosConfigProperties.configServiceInstance().getConfig(dataId, groupId, 5000);

            List<RouteDefinition> tmpList = JSONObject.parseArray(content, RouteDefinition.class);
            if (tmpList != null) {
                list = tmpList;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Flux.fromIterable(list);
    }

    public Mono<Void> save(Mono<RouteDefinition> route) {
        return null;
    }

    public Mono<Void> delete(Mono<String> routeId) {
        return null;
    }

    /**
     * 项目启动的时候会触发这个方法。
     * 方法实现： 监听节点的变化，如果节点变化就发送RefreshRoutesEvent事件。
     * gateway收到RefreshRoutesEvent事件的话，就会触发getRouteDefinitions方法了
     *
     * @param applicationContext
     */
    public void setApplicationContext(final ApplicationContext applicationContext) {

        try {
            nacosConfigProperties.configServiceInstance().addListener(dataId, groupId, new Listener() {
                public Executor getExecutor() {
                    return null;
                }

                public void receiveConfigInfo(String s) {
                    //如果节点变化就发送RefreshRoutesEvent事件。
                    applicationContext.publishEvent(new RefreshRoutesEvent(this));
                }
            });
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

}
