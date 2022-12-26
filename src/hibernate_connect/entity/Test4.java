package hibernate_connect.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()        //создаем сесию
                .configure("hibernate.cfg.xml")    //говорим, как создавать сессию
                .addAnnotatedClass(Employee.class)          //класс, в котором есть аннотации для работы с базой
                .buildSessionFactory();                     //строит саму сессию

        try {
            Session session = factory.getCurrentSession();

            session.beginTransaction();  //начинаем транзакцию

            /*Employee emp = session.get(Employee.class,1);             // id работника 1
            emp.setSalary(1000);                                      // поменяли зарплату*/

            session.createQuery("update Employee set salary = 2000 where name = 'Maksim'")
                            .executeUpdate();                       //поменяли зарплату всем Максимам
            session.getTransaction().commit();  // конец транзакции

        }
        finally {
            factory.close();
        }
    }
}
