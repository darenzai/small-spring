package com.darenzai.springframework.beans.factory.config;

import com.darenzai.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * <p>
 * description: ConfigurableBeanFactory
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/12 9:12
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

}
