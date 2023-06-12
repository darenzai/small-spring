package com.darenzai.springframework.beans.factory.config;

/**
 * <p>
 * description: SingletonBeanRegistry
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/08 8:48
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
