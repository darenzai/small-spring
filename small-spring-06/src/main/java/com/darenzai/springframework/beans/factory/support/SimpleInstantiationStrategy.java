package com.darenzai.springframework.beans.factory.support;

import com.darenzai.springframework.beans.factory.config.BeanDefinition;
import com.darenzai.springframework.beans.BeanException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * <p>
 * description: SimpleInstantiationStrategy
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/09 8:21
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    /**
     * 这段代码实现了 Spring 中的 Bean 实例化过程。当需要获取某个 Bean 的实例时，Spring 会根据其 BeanDefinition 中的信息来创建一个该 Bean 对应的实例。
     *
     * 具体而言，这段代码中的 instantiate 方法接收一个 BeanDefinition 对象以及其他一些参数，然后尝试基于这些参数创建一个对应的 Bean 实例。具体步骤如下：
     *
     * 1. 从 BeanDefinition 中获取该 Bean 的类对象 clazz。
     * 2. 如果存在构造方法 ctor，则使用该构造方法来创建一个新的实例，否则使用默认的无参构造方法。
     * 3. 如果创建实例过程中发生异常，则抛出 BeanException。
     *
     * 整个方法的目的是将 BeanDefinition 中的信息转换为一个 Java 对象，以便后续进行依赖注入等操作。
     * */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeanException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (null != ctor) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeanException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
