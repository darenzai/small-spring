package com.darenzai.springframework.test;

import com.darenzai.springframework.BeanDefinition;
import com.darenzai.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.darenzai.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * <p>
 * description: ApiTest
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/09 8:10
 */
public class ApiTest {

    @Test
    public void test_BeanFactory(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        // 4.第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
    }


}
