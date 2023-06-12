package com.darenzai.springframework.beans.factory;

import com.darenzai.springframework.BeanFactory;

/**
 * <p>
 * description: ListableBeanFactory
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/12 9:15
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this registry.
     *
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();

}
