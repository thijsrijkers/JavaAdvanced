package Rekenmachine;

import org.springframework.context.annotation.Profile;

@Profile("infix")
public class Infix {

    public Double calculate(String input) {
        String[] inputArray = input.split("");
        int iterator = 0;
        double answer = Integer.valueOf(inputArray[iterator++]);

        while (iterator < inputArray.length) {

            String operator = inputArray[iterator++];
            double valueForCalculation = Double.valueOf(inputArray[iterator++]);

            switch (operator) {
                case "*":
                    answer = answer * valueForCalculation;
                    break;
                case "/":
                    answer = answer / valueForCalculation;
                    break;
                case "+":
                    answer = answer + valueForCalculation;
                    break;
                case "-":
                    answer = answer - valueForCalculation;
                    break;
            }
        }

        return answer;
    }

}
