package com.darenzai.springframework.beans.factory.support;

import com.darenzai.springframework.BeanDefinition;

/**
 * <p>
 * description: BeanDefinitionRegistry
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/09 8:03
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
