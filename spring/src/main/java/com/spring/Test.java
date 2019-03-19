package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

@Configuration
@ComponentScan("com")
public class Test {

    //main doesn't have to be in the @Configration class at all. it's here incidentally
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Test.class);  //This is the "tree" object of spring.

        //two ways to get bean:
        SingletonBean s1 = context.getBean(SingletonBean.class);
        //without the class type we would need a downcast in the left side (getBean returns object)
        SingletonBean s2 =  context.getBean("singletonBean", SingletonBean.class);

        PrototypeBean p1 = context.getBean("prototypeBean", PrototypeBean.class);
        PrototypeBean p2 = context.getBean(PrototypeBean.class);
        PrototypeBean p3 = context.getBean("protoSix", PrototypeBean.class);

        System.out.println("single 1 X: " + s1.x);
        System.out.println("single 2 X: " + s2.x);
        System.out.println("Proto 1 X: " + p1.x);
        System.out.println("Proto 2 X: " + p2.x);
        System.out.println("Proto 3 X: " + p3.x);

        Person p = context.getBean(Person.class);
        System.out.println(p.getName());
        p.setName("Dudu");
        System.out.println(p.toString());

        //close - shutting down spring. it does a closure on all singletons (but not prototypes)
        //not all application contexts are try-with-resources, so we need the concrete type to call close()
        ((AnnotationConfigApplicationContext) context).close(); //before we had close, we used to do registerShutdownHook
    }
}
