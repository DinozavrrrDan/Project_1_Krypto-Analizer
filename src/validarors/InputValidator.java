package validarors;

import java.util.InputMismatchException;
import java.util.Scanner;

import static constants.Errors.BAD_VALUE_MESSAGE;

public class InputValidator {

    public static final int DEFAULT_VALUE = -1;

    /**
     * Проверяет являться ли введенная строка числом
     */
    public int validateChoise(Scanner input) {
        try {
            return input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(BAD_VALUE_MESSAGE + input.nextLine());
            return DEFAULT_VALUE;
        }
    }

}
