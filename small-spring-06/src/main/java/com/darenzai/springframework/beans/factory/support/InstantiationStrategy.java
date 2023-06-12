package com.darenzai.springframework.beans.factory.support;

import com.darenzai.springframework.beans.factory.config.BeanDefinition;
import com.darenzai.springframework.beans.BeanException;

import java.lang.reflect.Constructor;

/**
 * <p>
 * description: InstantiationStrategy
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/09 8:19
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeanException;

}
