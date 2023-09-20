import service.CryptoService;
import validarors.InputValidator;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        InputValidator inputValidator = new InputValidator();
        CryptoService cryptoService = new CryptoService();

        Scanner input = new Scanner(System.in);
        int userChoise;

        while (true) {
            System.out.println("CryptoAnalyzer menu:");
            System.out.println("1 - Create cypher (encrypt)");
            System.out.println("2 - Unmake cypher (decrypt)");
            System.out.println("3 - BruteForce");
            System.out.println("4 - Statistics");
            System.out.println("0 - exit program");
            System.out.println("Please enter a number :");
            userChoise = inputValidator.validateChoise(input);
            if (userChoise == 0) {
                exitProgram();
            } else if (userChoise == 1) {
                cryptoService.encrypt(input);
            } else if (userChoise == 2) {
                cryptoService.decrypt(input);
            } else if (userChoise == 3) {
                cryptoService.bruteForce(input);
            } else if (userChoise == 4) {
                cryptoService.statistics(input);
            } else {
                System.out.println("This is not a valid Menu option! Select another!");
            }

        }
    }

    private static void exitProgram() {
        System.out.println("Closing program...");
        System.exit(0);
    }
}