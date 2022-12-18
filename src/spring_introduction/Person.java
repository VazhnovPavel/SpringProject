package spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("personBean")
public class Person {
 /*   @Autowired
    @Qualifier("catBean")*/
    private Pet pet;
    @Value("${person.surname}")
    private String  surname;
    @Value("${person.age}")
    private int age;
/*    @Autowired

    public Person( @Qualifier ("catBean") Pet pet) {
        System.out.println("Person bin is created");
        this.pet = pet;
    }*/


    public Person(  Pet pet) {
        System.out.println("Person bin is created");
    this.pet = pet;
}



   /* public Person() {
        System.out.println("Person bin is created");
    }*/
    /*@Autowired
    @Qualifier ("dog")*/
    public void setPet(Pet pet) {
        System.out.println("Class Person: Set Pet");
        this.pet = pet;
    }

    public void callYourPet(){
        System.out.println("Hello my pet!");
        pet.say();
    }

    public String getSurname() {

        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("Class Person: set Surname: ");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Class Person: set Age: ");
        this.age = age;
    }
}
