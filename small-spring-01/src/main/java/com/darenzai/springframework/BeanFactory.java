package com.darenzai.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * description: BeanFactory
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/08 8:36
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

}
