package com.spring.ioc.demo1;

import org.springframework.util.ResourceUtils;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 单例模式下的IOC容器实现
 */
public class XmlApplicationContext {

    private String xmlPath;

    private Map<String,Object> map=null; //IOC容器map

    private List<HashMap<String,Object>> classProperties=new ArrayList<>(); //每个类的属性存储列表

    private List<Class> classList=new ArrayList<>(); //类信息存储列表

    private List<String> idList=new ArrayList<>();  //IOC容器key列表


    public XmlApplicationContext(String xmlPath) {
        this.xmlPath = xmlPath;
        try{
            getAllElements();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //读取xml文件，返回根节点
    public Iterator readXMl() throws FileNotFoundException, DocumentException {
        SAXReader reader = new SAXReader();
        File file = ResourceUtils.getFile("classpath:" + xmlPath);
        Document document = reader.read(file);
        Element rootElement = document.getRootElement();
        Iterator iterator = rootElement.elementIterator();
        return iterator;
    }

    //获取xml文件所有的节点内容
    public void getAllElements() throws Exception{
        Iterator iterator=readXMl();
        Class clazz=null;

        while((iterator.hasNext())){
            Element bean = (Element) iterator.next();

            //获取bean的id，class
            Iterator beanAttributes = bean.attributeIterator();
            String id=null;
            while(beanAttributes.hasNext()){
                Attribute attribute = (Attribute) beanAttributes.next();
                String classPropertyName = attribute.getName();
                String className = (String)attribute.getData();
                if(classPropertyName.equals("class")){
                    clazz=Class.forName(className);
                }else{
                    id=className;
                }
            }
            idList.add(id);
            HashMap<String, Object> propertiesMap = new HashMap<>();
            //获取类的属性
            ArrayList<String> propertyName = new ArrayList<>();
            ArrayList<Object> propertyValue = new ArrayList<>();

            Iterator properties = bean.elementIterator();
            while(properties.hasNext()){
                Element element = (Element) properties.next();
                Iterator propertiAttributes = element.attributeIterator();
                while(propertiAttributes.hasNext()){
                    Attribute attribute = (Attribute) propertiAttributes.next();
                    String attributeName = attribute.getName();
                    Object attributeData = attribute.getData();
                    if(attributeName.equals("name"))  //这里分为name 和 value
                        propertyName.add((String)attributeData);
                    else
                        propertyValue.add(attributeData);
                }
            }
            for(int i=0;i<propertyName.size();i++)
                propertiesMap.put(propertyName.get(i),propertyValue.get(i));

            classProperties.add(propertiesMap);
            classList.add(clazz);
        }
        setBeanMap(); //IOC容器设置
    }

    //反射，依赖注入(这里用set方法注入)，根据相关信息构建对象集合
    public Object[] getClassS() throws InstantiationException, IllegalAccessException, NoSuchFieldException, InvocationTargetException {
        Object[] objects = new Object[classList.size()];
        for (int i=0;i<classList.size();i++) {
            Class aClass = classList.get(i);
            HashMap<String, Object> m = classProperties.get(i);
            Object o = aClass.newInstance();
            Method[] methods = aClass.getDeclaredMethods(); //反射获取所有方法
            for (Method method : methods) {
                String methodName = method.getName();
                if("set".equals(methodName.substring(0,3))) { //set方法注入
                    String property=methodName.substring(3).toLowerCase(); //属性
                    Object data=m.get(property);

                    Field field1 = aClass.getDeclaredField(property);
                    Class<?> type = field1.getType();//类型
                    String typeName = type.getName();
                    Object data1=data;
                    if ("int".equals(typeName))   //基本类型，基本类型转包装器类，其它的还有float等，看pojo实际情况可作修改
                        data1 = Integer.valueOf((String) data1);
                    method.invoke(o, data1);

                }
            }
            objects[i]=o;
        }
        return objects;
    }

    public void setBeanMap() throws Exception {
        map = new HashMap<>();
        Object[] objects = getClassS();
        for (int i = 0; i < objects.length; i++) {
            map.put(idList.get(i), objects[i]);
        }
    }

    public Object getBean(String beanName) {
        if (!map.isEmpty())
            return map.get(beanName);
        return null;
    }

    public Map getBeanMap() {
        return map;
    }
}
