package Rekenmachine.Beans;

import org.springframework.context.annotation.Profile;

import java.util.Stack;

@Profile("postfix")
public class Postfix {

    public int calculate(String input) {
        Stack<Integer> answer = new Stack<>();

        for (char character: input.toCharArray())
        {
            if (Character.isDigit(character))
                answer.push(character - '0');
            else {
                int right = answer.pop();
                int left = answer.pop();

                switch(character) {
                    case '+':
                        answer.push(left + right);
                        break;
                    case '-':
                        answer.push(left - right);
                        break;
                    case '*':
                        answer.push(left * right);
                        break;
                    case '/':
                        answer.push(left / right);
                        break;
                }

            }
        }

        return answer.pop();
    }

}
