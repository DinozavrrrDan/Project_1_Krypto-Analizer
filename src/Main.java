import service.ConsoleService;
import service.CryptoService;
import service.FileService;

import java.io.IOException;

import static constants.Consts.MAIN_MENU;
import static constants.Consts.EXTRA_INFORMATION;
import static constants.Consts.NOT_VALID_MENU_OPTION;
import static constants.Consts.CLOSING_PROGRAM;

public class Main {

    public static void main(String[] args) throws IOException {
        ConsoleService consoleService = new ConsoleService();
        FileService fileService = new FileService(consoleService);
        CryptoService cryptoService = new CryptoService(fileService, consoleService);

        while (true) {
            System.out.println(MAIN_MENU);
            int userChoise = consoleService.readIntegersFromConsole();
            if (userChoise == 0) {
                exitProgram();
            } else if (userChoise == 1) {
                System.out.println(EXTRA_INFORMATION);
                cryptoService.encrypt();
            } else if (userChoise == 2) {
                System.out.println(EXTRA_INFORMATION);
                cryptoService.decrypt();
            } else if (userChoise == 3) {
                cryptoService.bruteForce();
            } else if (userChoise == 4) {
                cryptoService.statistics();
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
