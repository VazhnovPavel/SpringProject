package hibernate_one_to_many_bi;



import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
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
            Department dep = new Department("IT",300,1200);
            Employee emp1 = new Employee("Pavel","Vazhnov",800);
            Employee emp2 = new Employee("Nastya","Vazhnova",1000);
            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);
            session.beginTransaction();  //начинаем транзакцию
            session.save(dep);
            session.getTransaction().commit();      //закрываем сесию*/

            /*session = factory.getCurrentSession();
            session.beginTransaction();  //начинаем транзакцию
            Department department = session.get(Department.class,1);
            System.out.println(department);
            System.out.println(department.getEmps());*/

           /* session = factory.getCurrentSession();
            session.beginTransaction();  //начинаем транзакцию
            Employee employee = session.get(Employee.class,1);
            System.out.println(employee);
            System.out.println(employee.getDepartment());*/
///
            session = factory.getCurrentSession();
            session.beginTransaction();  //начинаем транзакцию
            Employee employee = session.get(Employee.class,6);
            session.delete(employee);


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
