package Rekenmachine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {

    public static void main(String args[]) {
        //Calculation formats:
        //
        //Postfix: 823*+7/1-
        //Infix: 1+1*9

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        InputReader inputReader = context.getBean(InputReader.class);
        ProfileHandler profileHandler=  context.getBean(ProfileHandler.class);

        String profile = profileHandler.environment.getActiveProfiles()[0];
        System.out.println("Format targeted: "+ profile);

        System.out.println("==========================");

        System.out.println("\uD83D\uDE31 Voor uw som in: ");
        String input = inputReader.readInput();

        System.out.println("==========================");

        if(profile.contains("infix")) {
            Infix infix = context.getBean(Infix.class);
            System.out.println(infix.calculate(input));
        }else{
            Postfix postfix = context.getBean(Postfix.class);
            System.out.println(postfix.calculate(input));
        }
    }

}
