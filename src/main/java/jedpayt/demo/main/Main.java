package jedpayt.demo.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main 
{
    public static void main( String[] args ){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println( "\n  ~Spring Hibernate Demo~  \n" );
        System.out.println("AppContext null? " + (ctx == null));
        
    }

}