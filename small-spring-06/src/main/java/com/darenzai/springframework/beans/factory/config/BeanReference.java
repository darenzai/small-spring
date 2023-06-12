package com.darenzai.springframework.beans.factory.config;

/**
 * <p>
 * description: BeanReference
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/12 9:08
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}
