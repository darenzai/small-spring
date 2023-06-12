package com.darenzai.springframework;

/**
 * <p>
 * description: BeanDefinition
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/08 8:36
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

}
