package com.yujieliu.beanlifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:me.xml")
@SpringBootApplication
public class BeanLifeCycleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BeanLifeCycleApplication.class, args);
        BeanLife me = context.getBean(BeanLife.class);
        me.play();
        context.close();
    }

}
