package com.darenzai.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.darenzai.springframework.beans.PropertyValue;
import com.darenzai.springframework.beans.PropertyValues;
import com.darenzai.springframework.beans.factory.config.BeanDefinition;
import com.darenzai.springframework.beans.BeanException;
import com.darenzai.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;


/****
 * 这段代码是 Spring IoC 容器的创建 bean 过程中的一部分。其中包含了使用 CGLIB 实现动态代理的 instantiationStrategy，以及根据 beanDefinition 的信息创建 Bean 实例的过程。
 *
 * 在 createBean 方法中，首先尝试通过类的默认构造函数实例化 bean，如果出现异常则会抛出一个 BeanException 异常；如果创建成功，则将 bean 放入单例缓存池中，并返回该 bean。
 *
 * 当 createBeanInstance 方法被调用时，它使用了 instantiationStrategy 中定义的 CGLIBSubclassingInstantiationStrategy 类来创建 bean 实例。具体来说，在 createBeanInstance 方法中，我们首先获取传入 beanDefinition 对应的类的所有构造函数(通过调用 getDeclaredConstructors())，并遍历数组寻找匹配参数的构造函数。如果找到匹配的构造函数，则使用 getInstantiationStrategy() 方法返回的 instantiationStrategy 实例调用 instantiate 方法来创建 bean；否则，将返回一个 null 值。
 *
 * 最后，在 getInstantiationStrategy() 和 setInstantiationStrategy() 方法中，分别返回和设置了 instantiationStrategy 实例。这里我们可以看到 Spring IoC 容器提供了扩展实例化策略的能力，我们可以通过替换 instantiationStrategy 来自定义 Bean 实例化的策略，比如使用其他的动态代理框架或手写代码来创建 Bean 实例。
 */

/**
 * <p>
 * description: AbstractAutowireCapableBeanFactory
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/08 9:21
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeanException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            // 给 Bean 填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeanException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * Bean 属性填充
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeanException("Error setting property values：" + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

}