package hibernate_one_to_many_uni;


import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()        //создаем сесию
                .configure("hibernate.cfg.xml")    //говорим, как создавать сессию
                .addAnnotatedClass(Employee.class)          //класс, в котором есть аннотации для работы с базой
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();                     //строит саму сессию
        Session session = null;
        try {
           /* session = factory.getCurrentSession();
            Department dep = new Department("HR",500,1500);
            Employee emp2 = new Employee("Anaa","Golubeva",900);
            Employee emp1 = new Employee("Natalia","Volkonskaya",500);
            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);
            session.beginTransaction();  //начинаем транзакцию
            session.save(dep);
            session.getTransaction().commit();      //закрываем сесию
            System.out.println();
            System.out.println("Суксес!");
            System.out.println();*/

           /* session = factory.getCurrentSession();
            session.beginTransaction();  //начинаем транзакцию
           Department department = session.get(Department.class,8);
            System.out.println(department);
            System.out.println(department.getEmps());
            session.getTransaction().commit();      //закрываем сесию
            System.out.println();
            System.out.println("Суксес!");
            System.out.println();*/

           /* session = factory.getCurrentSession();
            session.beginTransaction();  //начинаем транзакцию
            Employee employee = session.get(Employee.class,5);
            System.out.println(employee);

            session.getTransaction().commit();      //закрываем сесию
            System.out.println();
            System.out.println("Суксес!");
            System.out.println();*/

            session = factory.getCurrentSession();
            session.beginTransaction();  //начинаем транзакцию
            Department dep = session.get(Department.class,8);
            session.delete(dep);
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
