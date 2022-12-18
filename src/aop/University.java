package aop;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class University {
    private List<Student> students = new ArrayList<>();
    public void addStudents() {
        Student st1 = new Student("Важнов Павел",3,2.86);
        Student st2 = new Student("Клепацкий Дмитрий",4,4.98);
        Student st3 = new Student("Барышников Артем",4,3.5);
        students.add(st1);
        students.add(st2);
        students.add(st3);
    }
    public List<Student> getStudents(){
        System.out.println("Информация о методе студентов: ");
        System.out.println(students);
        return students;
    }

}
