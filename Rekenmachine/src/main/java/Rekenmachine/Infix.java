package Rekenmachine;

import org.springframework.context.annotation.Profile;
import java.util.*;

@Profile("infix")
public class Infix {

    public String calculate(String input) {
        String[] outs = input.split("(?<=[-+*/\\(\\)])|(?=[-+*/\\(\\)])");
        for (String element : outs)
        {
            System.out.println(element);
        }

        return "";
    }

}
