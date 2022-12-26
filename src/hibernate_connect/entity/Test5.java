package hibernate_connect.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()        //создаем сесию
                .configure("hibernate.cfg.xml")    //говорим, как создавать сессию
                .addAnnotatedClass(Employee.class)          //класс, в котором есть аннотации для работы с базой
                .buildSessionFactory();                     //строит саму сессию

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();  //начинаем транзакцию

           /* Employee emp = session.get(Employee.class,1);             // id работника 1
            session.delete(emp);                                    // удаляем работника */

            session.createQuery("delete Employee " +
                    "where name = 'Maksim'")                        // удаляем всех Максимов
                            .executeUpdate();                   //нужен для любых изменений в таблице

            session.getTransaction().commit();  // конец транзакции
            System.out.println("Получилось!");

        }
        finally {
            factory.close();
        }
    }
}
