package Rekenmachine;
import java.util.Stack;

public class Postfix {

    public int calculate(String input) {
        Stack<Integer> stack = new Stack<>();

        for (char character: input.toCharArray())
        {
            if (Character.isDigit(character)) {
                stack.push(character - '0');
            }
            else {
                int x = stack.pop();
                int y = stack.pop();

                switch(character) {
                    case '+':
                        stack.push(y + x);
                        break;
                    case '-':
                        stack.push(y - x);
                        break;
                    case '*':
                        stack.push(y * x);
                        break;
                    case '/':
                        stack.push(y / x);
                        break;
                    default:
                        // code block
                }

            }
        }
        return stack.pop();
    }

}
