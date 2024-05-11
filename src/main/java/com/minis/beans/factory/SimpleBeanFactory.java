package com.minis.beans.factory;

import com.minis.beans.BeansException;
import com.minis.beans.factory.config.BeanDefinition;
import java.util.*;

/**
 * @author malin28
 * @date 2024/5/11 16:32
 */
public class SimpleBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitions = new HashMap<>();
    private Map<String, Object> singletons = new HashMap<>();

    @Override
    public Object getBean(String beanName) throws BeansException {
        Object bean = singletons.get(beanName);
        if(null == bean){
            boolean i = beanDefinitions.containsKey(beanName);
            if(!i) {
                throw new BeansException("bean not found");
            }
            else {
                BeanDefinition beanDefinition = beanDefinitions.get(beanName);
                try {
                    bean = Class.forName(beanDefinition.getClassName()).getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    throw new BeansException("bean create failed");
                }
                this.singletons.put(beanDefinition.getId(), bean);
            }
        }
        return bean;
    }

    @Override
    public void registerBean(BeanDefinition beanDefinition) {
        this.beanDefinitions.put(beanDefinition.getId(), beanDefinition);
    }
}
