package spring_introduction;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component

public class Dog implements Pet{
   // private String name;
    public Dog() {

        System.out.println("Dog bean is created");
    }
    @Override
    public void say(){
        System.out.println("собака");
    }
 /*   @PostConstruct
    public void init(){
        System.out.println("class dog: init method");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("class dog: destroy method");
    }*/
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
