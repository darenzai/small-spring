package com.darenzai.springframework.beans.factory.support;

import com.darenzai.springframework.beans.factory.config.BeanDefinition;
import com.darenzai.springframework.beans.BeanException;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * description: DefaultListableBeanFactory
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/09 8:01
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private final Map<String, BeanDefinition> beanDefinitionMap =  new HashMap<>();
    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeanException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if(beanDefinition == null) {
            throw new BeanException("NO bean named" + beanName + " is defined");
        }
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
