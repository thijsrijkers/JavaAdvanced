package Rekenmachine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {

    public static void main(String args[]) {
        //Postfix: 138*+
        //Infix: 1+1
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        InputReader inputReader = context.getBean(InputReader.class);

        System.out.println("Voor uw som in: ");
        String input = inputReader.readInput();

        System.out.println("_____________________________________");
//        Postfix postfix = context.getBean(Postfix.class);
//        System.out.println(postfix.calculate(input));

        Infix infix = context.getBean(Infix.class);
        System.out.println(infix.calculate(input));
    }

}
