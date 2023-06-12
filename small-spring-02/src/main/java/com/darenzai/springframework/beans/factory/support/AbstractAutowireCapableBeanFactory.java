package com.darenzai.springframework.beans.factory.support;

import com.darenzai.springframework.BeanDefinition;
import com.darenzai.springframework.beans.BeanException;

/**
 * <p>
 * description: AbstractAutowireCapableBeanFactory
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/08 9:21
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeanException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeanException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, beanDefinition);
        return bean;
    }
}
