package com.darenzai.springframework.beans.factory.support;

import com.darenzai.springframework.BeanDefinition;
import com.darenzai.springframework.beans.BeanException;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * <p>
 * description: CglibSubclassingInstantiationStrategy
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/09 8:26
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{

    /**
     * 这段代码实现了 Spring 中使用 CGLIB 动态代理的 Bean 实例化方法，与之前提到的 instantiate 方法相比，其主要区别在于使用了 CGLIB 的 Enhancer 类来动态创建 Bean 对象。
     *
     * 具体而言，这段代码中的 instantiate 方法接收一个 BeanDefinition 对象以及其他一些参数。它会首先使用 Enhancer 类创建一个代理对象 enhancer，并设置该代理对象的父类为 beanDefinition.getBeanClass()。然后，通过调用 enhancer.create() 方法或 enhancer.create(ctor.getParameterTypes(), args) 方法来创建代理对象。
     *
     * 如果不指定构造函数 ctor，则使用默认的无参构造函数创建代理对象；反之，将根据 ctor 指定的构造函数和 args 参数创建代理对象。
     *
     * 代理对象的行为由 setCallback 方法指定。在这段代码中，我们使用了 NoOp 类来指定一个空方法回调，使代理类的方法不发生任何改变。这意味着实际上代理类并没有进行任何增强操作，只是与原始类保持一致并提供一些间接访问的途径。
     * */

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeanException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if(ctor==null){
            return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
