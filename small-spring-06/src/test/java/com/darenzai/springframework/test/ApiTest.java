package com.darenzai.springframework.test;

import com.darenzai.springframework.beans.factory.config.BeanDefinition;
import com.darenzai.springframework.beans.PropertyValue;
import com.darenzai.springframework.beans.PropertyValues;
import com.darenzai.springframework.beans.factory.config.BeanReference;
import com.darenzai.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.darenzai.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.darenzai.springframework.test.bean.UserDao;
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
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        // 4. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }


    @Test
    public void testXml() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");
        // 3. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

}
