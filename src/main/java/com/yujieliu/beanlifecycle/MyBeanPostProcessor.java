package com.yujieliu.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("beanLife")) {
            System.out.println("4. [BeanPostProcessor前置] 我刚刚进入工厂，在初始化之前, 所有的bean都会在这来一趟，我的名字是: " + beanName);
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("beanLife")){
            System.out.println("7. [BeanPostProcessor后置] 我初始化完成，所有bean都要来这一趟，再从工厂里提桶跑路了，我的名字是："+beanName);
        }

        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
