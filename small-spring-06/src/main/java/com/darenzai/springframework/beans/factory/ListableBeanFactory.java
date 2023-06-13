package com.darenzai.springframework.beans.factory;

import com.darenzai.springframework.BeanFactory;
import com.darenzai.springframework.beans.BeanException;

import java.util.Map;

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
     * @param <T>
     * @param type
     * @return
     * @throws BeanException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeanException;

    /**
     * Return the names of all beans defined in this registry.
     *
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();

}
