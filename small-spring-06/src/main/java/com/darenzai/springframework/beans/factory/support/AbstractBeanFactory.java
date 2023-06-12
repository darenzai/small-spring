package com.darenzai.springframework.beans.factory.support;

import com.darenzai.springframework.beans.factory.config.BeanDefinition;
import com.darenzai.springframework.BeanFactory;
import com.darenzai.springframework.beans.BeanException;

/**
 * <p>
 * description: AbstractBeanFactory
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/08 9:08
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {


    @Override
    public Object getBean(String name) throws BeanException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeanException {
        return doGetBean(name, args);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeanException;

}
