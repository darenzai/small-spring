package com.darenzai.springframework.beans.factory;

import com.darenzai.springframework.beans.BeanException;
import com.darenzai.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.darenzai.springframework.beans.factory.config.BeanDefinition;
import com.darenzai.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * <p>
 * description: ConfigurableListableBeanFactory
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/13 8:36
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeanException;

}
