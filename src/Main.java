import service.CryptoService;
import validarors.InputValidator;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static final String MAIN_MENU = """
            CryptoAnalyzer menu:
            1 - Create cypher (encrypt)
            2 - Unmake cypher (decrypt)
            3 - BruteForce4 - Statistics
            0 - exit program
            Please enter a number : """;
    public static final String EXTRA_INFORMATION = "Please enter source file, output file and shift!";
    public static final String NOT_VALID_MENU_OPTION = "This is not a valid Menu option! Select another!";
    public static final String CLOSING_PROGRAM = "Closing program...";

    public static void main(String[] args) throws IOException {
        InputValidator inputValidator = new InputValidator();
        CryptoService cryptoService = new CryptoService();

        Scanner input = new Scanner(System.in);
        int userChoise;

        while (true) {
            System.out.println(MAIN_MENU);
            userChoise = inputValidator.validateChoise(input);
            if (userChoise == 0) {
                exitProgram();
            } else if (userChoise == 1) {
                System.out.println(EXTRA_INFORMATION);
                cryptoService.encrypt(input);
            } else if (userChoise == 2) {
                System.out.println(EXTRA_INFORMATION);
                cryptoService.decrypt(input);
            } else if (userChoise == 3) {
                cryptoService.bruteForce(input);
            } else if (userChoise == 4) {
                cryptoService.statistics(input);
            } else {
                System.out.println(NOT_VALID_MENU_OPTION);
            }

        }
    }

    private static void exitProgram() {
        System.out.println(CLOSING_PROGRAM);
        System.exit(0);
    }
}