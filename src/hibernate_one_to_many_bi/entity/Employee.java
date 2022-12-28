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
    @Column(name = "salary")
    private int salary;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee() {
    }

    public Employee(String name, String surName, int salary) {
        this.name = name;
        this.surName = surName;
        this.salary = salary;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
