import service.CryptoService;
import validarors.InputValidator;

import java.io.IOException;
import java.util.Scanner;

import static constants.Consts.MAIN_MENU;
import static constants.Consts.EXTRA_INFORMATION;
import static constants.Consts.NOT_VALID_MENU_OPTION;
import static constants.Consts.CLOSING_PROGRAM;

public class Main {


    public static void main(String[] args) throws IOException {
        InputValidator inputValidator = new InputValidator();
        CryptoService cryptoService = new CryptoService();

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println(MAIN_MENU);
            int userChoise = inputValidator.validateChoise(input);
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