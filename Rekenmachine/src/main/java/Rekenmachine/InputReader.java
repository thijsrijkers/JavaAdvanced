package Rekenmachine;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputReader {

    public String readInput() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            return input;
        }
        catch(Exception exception) {
            return exception.toString();
        }
    }
}