package hibernate_one_to_one;


import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()        //создаем сесию
                .configure("hibernate.cfg.xml")    //говорим, как создавать сессию
                .addAnnotatedClass(Employee.class)          //класс, в котором есть аннотации для работы с базой
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();                     //строит саму сессию
        Session session = null;
        try {
            /*session = factory.getCurrentSession();
            Employee employee = new Employee("Vova","Zubenko","Dancer",8000);
            Detail detail = new Detail("Moscow","4234234", "Zubenko@gmail.com");
            detail.setEmployee(employee);
            employee.setEmpDetail(detail);      //добавляем, чтобы был Id
            session.beginTransaction();  //начинаем транзакцию
            session.save(detail);      //сохранили все данные
            session.getTransaction().commit();      //закрываем сесию
            System.out.println();
            System.out.println("Суксес!");
            System.out.println();*/

          /*  session = factory.getCurrentSession();


            session.beginTransaction();  //начинаем транзакцию
            Detail detail = session.get(Detail.class,1);
            System.out.println(detail.getEmployee());
            session.getTransaction().commit();      //закрываем сесию

            System.out.println();
            System.out.println("Суксес!");
            System.out.println();*/

            session = factory.getCurrentSession();


            session.beginTransaction();  //начинаем транзакцию
            Detail detail = session.get(Detail.class,4);
            detail.getEmployee().setEmpDetail(null);
            session.delete(detail);
            session.getTransaction().commit();      //закрываем сесию

            System.out.println();
            System.out.println("Суксес!");
            System.out.println();


        }
        finally {
            session.close();
            factory.close();
        }
    }
}
