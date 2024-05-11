package com.minis.context;

import com.minis.beans.BeansException;
import com.minis.beans.factory.BeanFactory;
import com.minis.beans.factory.SimpleBeanFactory;
import com.minis.beans.factory.config.BeanDefinition;
import com.minis.beans.factory.xml.XMLBeanDefinitionReader;
import com.minis.core.ClassPathXmlResource;
import com.minis.core.Resource;
import java.net.URL;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

/**
 * @author malin28
 * @date 2024/5/11 15:01
 */
public class ClassPathXmlApplicationContext {
    BeanFactory beanFactory;
    //构造器获取外部配置，解析出Bean的定义，形成内存映像
    public ClassPathXmlApplicationContext(String fileName) {
        Resource resource = new ClassPathXmlResource(fileName);
        beanFactory = new SimpleBeanFactory();
        XMLBeanDefinitionReader xmlBeanDefinitionReader = new XMLBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(resource);
    }
    public Object getBean(String beanName) throws BeansException {
        return beanFactory.getBean(beanName);
    }

    public void registerBean(BeanDefinition beanDefinition){
        beanFactory.registerBean(beanDefinition);
    }

}
