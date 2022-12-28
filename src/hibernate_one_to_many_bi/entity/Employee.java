package hibernate_one_to_many_bi.entity;

import hibernate_one_to_one.entity.Detail;

import javax.persistence.*;

@Entity  //говорит о том, что Employee отобразиться в базе данных
@Table(name = "employees")  // к какой именно таблице привязываем класс
public class Employee {
    @Id   // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //правило формирования Primary Key
    @Column(name = "id")  // Как называется столбец в таблице
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surName")
    private String surName;
    @Column(name = "department")
    private String department;
    @Column(name = "salary")
    private int salary;

    @OneToOne(cascade = CascadeType.ALL)     // отношение один к одному,если удалить работника -его details тоже удалить
    @JoinColumn(name = "details_id")        // для связи используем столбец из таблицы Employee details_id
    private Detail empDetail;               //таблица Employee знает о таблице Detail


    public Employee() {   //обязательно надо создать конструктор с аргументами
    }

    public Employee(String name, String surName, String department, int salary) {
        this.name = name;
        this.surName = surName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Detail getEmpDetail() {
        return empDetail;
    }

    public void setEmpDetail(Detail empDetail) {
        this.empDetail = empDetail;
    }
}
