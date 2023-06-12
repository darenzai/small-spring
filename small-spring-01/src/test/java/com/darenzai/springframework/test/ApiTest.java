package com.darenzai.springframework.test;

import com.darenzai.springframework.BeanDefinition;
import com.darenzai.springframework.BeanFactory;
import com.darenzai.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * <p>
 * description: ApitTest
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/08 8:38
 */
public class ApiTest {

    @Test
    public void test_BeanFactory(){
        // 1.初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
