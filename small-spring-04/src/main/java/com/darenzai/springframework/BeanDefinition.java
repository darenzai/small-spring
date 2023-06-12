package com.darenzai.springframework;

/**
 * <p>
 * description: BeanDefinition
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/08 8:36
 */
@SuppressWarnings({"rawtypes"})
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
