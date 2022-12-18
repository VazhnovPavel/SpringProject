package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");
    Dog myDog = context.getBean("dog", Dog.class);
    myDog.say();
 /*   Dog yourDog = context.getBean("dog" ,Dog.class);
        System.out.println("Переменные ссылаются на одни и тот же обьект?" + (myDog == yourDog));
        System.out.println(myDog);
        System.out.println(yourDog);

  */
        context.close();
    }
}
