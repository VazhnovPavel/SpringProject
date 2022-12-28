package hibernate_one_to_one;


import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()        //создаем сесию
                .configure("hibernate.cfg.xml")    //говорим, как создавать сессию
                .addAnnotatedClass(Employee.class)          //класс, в котором есть аннотации для работы с базой
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();                     //строит саму сессию
        Session session = null;
        try {
            /*Session session = factory.getCurrentSession();
            Employee employee = new Employee("Maksim","Titov","Photo",20000);
            Detail detail = new Detail("Moscow","123456", "Titov@gmail.com");
            employee.setEmpDetail(detail);
            session.beginTransaction();  //начинаем транзакцию
            session.save(employee);      //сохранили все данные
            session.getTransaction().commit();      //закрываем сесию
*/

           /* Session session = factory.getCurrentSession();
            Employee employee = new Employee("Pavel","Vazhnov","Java",40000);
            Detail detail = new Detail("Istambul","654321", "Vazhnov@gmail.com");
            employee.setEmpDetail(detail);
            session.beginTransaction();  //начинаем транзакцию
            session.save(employee);      //сохранили все данные
            session.getTransaction().commit();      //закрываем сесию*/

        /*    session = factory.getCurrentSession();
            session.beginTransaction();  //начинаем транзакцию
            Employee emp = session.get(Employee.class,2);
            System.out.println();
            System.out.println(emp.getEmpDetail());
            System.out.println();*/

            session = factory.getCurrentSession();
            session.beginTransaction();  //начинаем транзакцию
            Employee emp = session.get(Employee.class,2);
            session.delete(emp);
            System.out.println();
            System.out.println("Суксес!");
            System.out.println();





            session.getTransaction().commit();      //закрываем сесию

        }
        finally {
            session.close();
            factory.close();
        }
    }
}
