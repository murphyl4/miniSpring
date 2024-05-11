package com.minis.beans.factory;

import com.minis.beans.factory.config.BeanDefinition;
import com.minis.beans.BeansException;

/**
 * @author malin28
 * @date 2024/5/11 15:47
 */
public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;
    void registerBean(BeanDefinition beanDefinition);
}
