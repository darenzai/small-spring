package com.darenzai.springframework;

import com.darenzai.springframework.beans.BeanException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * description: BeanFactory
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/08 8:36
 */
public interface BeanFactory {

    Object getBean(String name) throws BeanException;

    Object getBean(String name, Object... args) throws BeanException;

    <T> T getBean(String name, Class<T> requiredType) throws BeanException;

}
