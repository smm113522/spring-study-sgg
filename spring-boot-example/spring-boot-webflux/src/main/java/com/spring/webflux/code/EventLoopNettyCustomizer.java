package com.spring.webflux.code;

import org.springframework.boot.web.embedded.netty.NettyServerCustomizer;
import reactor.netty.http.server.HttpServer;

public class EventLoopNettyCustomizer implements NettyServerCustomizer {

    @Override
    public HttpServer apply(HttpServer httpServer) {
        /*
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap()
                .group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                //开启tcp nagle算法
                .childOption(ChannelOption.TCP_NODELAY, true)
                //开启长连接
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel c) {
                        c.pipeline().addLast(new HttpServerCodec())
                                .addLast(new HttpObjectAggregator(512 * 1024))
                                .addLast(new SimpleHttpServerHandler());

                    }
                });
                */

//        ChannelFuture channelFuture = serverBootstrap.bind(host, port).sync();
        String host = "192.168.1.138";
        int port = 8088;
        HttpServer httpServer1 = httpServer.host(host)
                .port(port);

        return httpServer1;
    }
}