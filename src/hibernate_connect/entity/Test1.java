package hibernate_connect.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()        //создаем сесию
                .configure("hibernate.cfg.xml")    //говорим, как создавать сессию
                .addAnnotatedClass(Employee.class)          //класс, в котором есть аннотации для работы с базой
                .buildSessionFactory();                     //строит саму сессию

        try {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Maksim", "Proshin", "Refery", 500000);
            session.beginTransaction();  //начинаем транзакцию
            session.save(emp);          //сохраняем работника
            session.getTransaction().commit();      //закрываем сесию
            System.out.println(emp);
        }
        finally {
            factory.close();
        }
    }
}
