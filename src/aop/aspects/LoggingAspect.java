package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {
    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature =" + methodSignature );
        System.out.println("methodSignature.getMethod =" + methodSignature.getMethod() );
        System.out.println("methodSignature.getReturnType =" + methodSignature.getReturnType() );
        System.out.println("methodSignature.getName =" + methodSignature.getName());
        

        System.out.println("beforeGetLoggingAdvice: логирование попытки получить книгу/журнал");
        System.out.println("---------------------------------");

        if (methodSignature.getName().equals("addBook")){
            Object[] arguments  = joinPoint.getArgs();          //получили все параметры в этот масиив
            for (Object  obj:arguments ){
                if (obj instanceof Book){
                    Book myBook = (Book) obj;
                    System.out.println("Info for book: название: " +
                            myBook.getName() + ", автор: " + myBook.getAuthor() + ", год выпуска: "
                            + myBook.getYearOfPublication());
                } else if (obj instanceof String){
                    System.out.println("кто добавил книгу в библиотеку: " + obj);

                }
            }
        }
    }







  /*  @Pointcut("execution (* aop.UniLibrary.*(..))")
    private void allMethodsFromUniLibrary(){}

    @Pointcut("execution (public void aop.UniLibrary.returnMagazine())")
    private void returnMagazineFromUniLibrary(){}
    @Pointcut ("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
    private void allMethodExceptReturnMagazineFromUniLibrary(){}

    @Before("allMethodExceptReturnMagazineFromUniLibrary()")
    public void beforeAllMethodsExceptReturnMagazineAdvice(){
        System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: writing Log #10");
    }

*/





    /*@Pointcut("execution(* aop.UniLibrary.get*())")
    private void allGetMethodsFromUniLibrary(){}
    @Pointcut("execution(* aop.UniLibrary.return*())")
    private void allReturnMethodsFromUniLibrary(){}
    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
    private void allGetOrReturnMethodsFromUniLibrary(){}


    @Before("allGetMethodsFromUniLibrary()")
    public void beforeGetLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice:  writing Log #1");
    }
    @Before("allReturnMethodsFromUniLibrary()")
    public void beforeReturnLoggingAdvice(){
        System.out.println("beforeReturnLoggingAdvice:  writing Log #2");
    }
    @Before("allGetOrReturnMethodsFromUniLibrary()")
    public void beforeOrReturnLoggingAdvice(){
        System.out.println("beforeOrReturnLoggingAdvice:  writing Log #3");
    }*/








}
