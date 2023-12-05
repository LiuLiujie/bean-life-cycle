# Bean Life Cycle

A simple project to demonstrate the life cycle of a bean in Spring Framework

```
 INFO 24916 --- [           main] c.y.b.BeanLifeCycleApplication           : Starting BeanLifeCycleApplication using Java 17.0.9 with PID 24916 (/Users/yujie/Development/bean-life-cycle/target/classes started by yujie in /Users/yujie/Development/bean-life-cycle)
 INFO 24916 --- [           main] c.y.b.BeanLifeCycleApplication           : No active profile set, falling back to 1 default profile: "default"
 INFO 24916 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
 INFO 24916 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
 INFO 24916 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.16]
 INFO 24916 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
 INFO 24916 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 399 ms

1. 我出生了，被构造函数创建
2. Bean实例创建后，开始setter属性赋值，我的爹妈给我起名叫：保尔
3.1 [Aware接口] 准备进场打工，我失去了自己的名字，从此只有一个花名叫: beanLife
3.2 [Aware接口] “双亲”委派机制下，让我准备驱使我工作的人是: app
3.3 [Aware接口] 我选了一个工厂，名字叫: org.springframework.beans.factory.support.DefaultListableBeanFactory
4. [BeanPostProcessor前置] 我刚刚进入工厂，在初始化之前, 所有的bean都会在这来一趟，我的名字是: beanLife
我调用@PostConstruct注解，这是我在工厂中准备好后能做的
5. [InitializingBean接口] 此时我的工人属性已经全部点满，我可以在此自定义我的初始化方法，我准备进行反抗！！
6.或者使用xml进行自定我的init-method
7. [BeanPostProcessor后置] 我初始化完成，所有bean都要来这一趟，再从工厂里提桶跑路了，我的名字是：beanLife

INFO 24916 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
INFO 24916 --- [           main] c.y.b.BeanLifeCycleApplication           : Started BeanLifeCycleApplication in 0.741 seconds (process running for 0.947)

！！！现在，我是一个合格的bean了，可以自由被调用自由play了！！！
8. [DestructionAwareBeanPostProcessor] 所有Bean都要来这一遭，因此我很早就开始考虑，我应该如何死亡
我调用@PreDestroy注解，准备死亡
9. 我实现了DisposableBean接口，安排了我的死亡方式
10. 或者通过xml定义的destroy-method，再见了 Goodbye World
希望你能记住我的真名，我叫：保尔
```