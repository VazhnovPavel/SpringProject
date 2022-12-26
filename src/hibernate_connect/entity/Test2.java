package hibernate_connect.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()        //создаем сесию
                .configure("hibernate.cfg.xml")    //говорим, как создавать сессию
                .addAnnotatedClass(Employee.class)          //класс, в котором есть аннотации для работы с базой
                .buildSessionFactory();                     //строит саму сессию

        try {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Denis", "Shevchenko", "Refery", 550000);
            session.beginTransaction();  //начинаем транзакцию
            session.save(emp);          //сохраняем работника
          //  session.getTransaction().commit();      //закрываем сесию

            int myId = emp.getId();           //получаем ID из базы данных
           // session = factory.getCurrentSession();            //открываем новую сессию, т.к. старую закрыли
           // session.beginTransaction();
            Employee employee = session.get(Employee.class, myId); // запрашиваем работника по его iD
            session.getTransaction().commit();
            System.out.println(employee);
        }
        finally {
            factory.close();
        }
    }
}
