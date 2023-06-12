package com.darenzai.springframework.beans.factory.support;

import com.darenzai.springframework.beans.BeanException;
import com.darenzai.springframework.core.io.Resource;
import com.darenzai.springframework.core.io.ResourceLoader;

/**
 * <p>
 * description: BeanDefinitionReader
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/12 8:47
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeanException;

    void loadBeanDefinitions(Resource... resources) throws BeanException;

    void loadBeanDefinitions(String location) throws BeanException;

}

