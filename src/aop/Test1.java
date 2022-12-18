package aop;

import aop.aspects.ExceptionHandlingAspect;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        Book book = context.getBean("book", Book.class);
        uniLibrary.getBook();

        uniLibrary.addBook("Pavel",book);
        uniLibrary.addMagazine();
        // uniLibrary.returnMagazine();
        // uniLibrary.getMagazine();
        // schoolLibrary.getBook();
        // uniLibrary.returnBook();
        // SchoolLibrary schoolLibrary = context.getBean("schoolLibrary",SchoolLibrary.class);
        context.close();
    }
}
