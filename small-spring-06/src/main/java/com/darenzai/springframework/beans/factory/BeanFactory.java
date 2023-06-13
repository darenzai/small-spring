package com.darenzai.springframework.beans.factory;

import com.darenzai.springframework.beans.BeanException;

/**
 * <p>
 * description: BeanFactory
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/13 8:37
 */
public interface BeanFactory {

    Object getBean(String name) throws BeanException;

    Object getBean(String name, Object... args) throws BeanException;

    <T> T getBean(String name, Class<T> requiredType) throws BeanException;

}
