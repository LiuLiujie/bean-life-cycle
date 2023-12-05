package com.yujieliu.beanlifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.stereotype.Component;

public class BeanLife implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean, DisposableBean {

    /**
     * 我的真实名字
     */
    private String name;

    public BeanLife(){
        System.out.println("1. 我出生了，被构造函数创建");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2. Bean实例创建后，开始setter属性赋值，我的爹妈给我起名叫："+name);
        this.name = name;
    }

    /**
     * 实现自 BeanNameAware，目的是在BeanFactory工厂中区分开来
     *
     * @param name the name of the bean in the factory.
     * Note that this name is the actual bean name used in the factory, which may
     * differ from the originally specified name: in particular for inner bean
     * names, the actual bean name might have been made unique through appending
     * "#..." suffixes. Use the {@link BeanFactoryUtils#originalBeanName(String)}
     * method to extract the original bean name (without suffix), if desired.
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("3.1 [Aware接口] 准备进场打工，我失去了自己的名字，从此只有一个花名叫: "+name);
    }

    /**
     * 实现自 BeanClassLoaderAware， 目的是双亲委派机制下选择一个loader来实现我
     * @param classLoader the owning class loader
     */
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("3.2 [Aware接口] “双亲”委派机制下，让我准备驱使我工作的人是: "+classLoader.getName());
    }

    /**
     * 实现自BeanFactoryAware，目的是选一个工厂
     *
     * @param beanFactory owning BeanFactory (never {@code null}).
     * The bean can immediately call methods on the factory.
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("3.3 [Aware接口] 我选了一个工厂，名字叫: "+beanFactory.getClass().getName());
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("我调用@PostConstruct注解，这是我在工厂中准备好后能做的");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("5. [InitializingBean接口] 此时我的工人属性已经全部点满，我可以在此自定义我的初始化方法，我准备进行反抗！！");
    }

    public void customizedInit(){
        System.out.println("6.或者使用xml进行自定我的init-method");
    }

    public void play(){
        System.out.println("！！！现在，我是一个合格的bean了，可以自由被调用自由play了！！！");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("我调用@PreDestroy注解，准备死亡");
    }

    @Override
    public void destroy() {
        System.out.println("9. 我实现了DisposableBean接口，安排了我的死亡方式");
    }

    public void customizedDestroy(){
        System.out.println("10. 或者通过xml定义的destroy-method，再见了 Goodbye World");
        System.out.println("希望你能记住我的真名，我叫："+this.name);
    }
}
