package com.minis.beans.factory.config;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author malin28
 * @date 2024/5/11 14:58
 */
@Data
@AllArgsConstructor
public class BeanDefinition {
    private String id;
    private String className;
}
