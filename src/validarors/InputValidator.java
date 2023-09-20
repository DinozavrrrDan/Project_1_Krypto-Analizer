package validarors;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {

    public static final String BAD_VALUE_MESSAGE = "PLease enter correct number! Between 0 and 4. Your value: ";

    public static final int DEFAULT_VALUE = -1;

    public int validateChoise(Scanner input) {
        try {
            return input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(BAD_VALUE_MESSAGE + input.nextLine());
            return DEFAULT_VALUE;
        }
    }

}
