package aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value(" 1986 ")
    private String name;
    @Value("Джордж Оруэлл")
    private String author;
    @Value("1949")
    private int yearOfPublication;
    public String getName(){
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
}
