package com.yujieliu.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDestructionPostProcessor implements DestructionAwareBeanPostProcessor {

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if (beanName.equals("beanLife")){
            System.out.println("8. [DestructionAwareBeanPostProcessor] 所有Bean都要来这一遭，因此我很早就开始考虑，我应该如何死亡");
        }
    }
}
