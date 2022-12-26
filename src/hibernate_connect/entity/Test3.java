package hibernate_connect.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()        //создаем сесию
                .configure("hibernate.cfg.xml")    //говорим, как создавать сессию
                .addAnnotatedClass(Employee.class)          //класс, в котором есть аннотации для работы с базой
                .buildSessionFactory();                     //строит саму сессию

        try {
            Session session = factory.getCurrentSession();

            session.beginTransaction();  //начинаем транзакцию

           /* List<Employee> emps = session.createQuery("From Employee")
                            .getResultList();*/             //список всех работников

            List<Employee> emps = session.createQuery("From Employee " +
                            "where name = 'Maksim' AND salary > 400000 ") //переменные name,salary из класса Employee
                    .getResultList();                       // список всех Максимов c ЗП выше 400 тысяч
            for (Employee e : emps){
                System.out.println(e);
            }
            session.getTransaction().commit();  // конец транзакции

        }
        finally {
            factory.close();
        }
    }
}
