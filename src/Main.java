import service.ConsoleService;
import service.CryptoService;
import service.FileService;

import java.io.IOException;

import static constants.Consts.MAIN_MENU;
import static constants.Consts.NOT_VALID_MENU_OPTION;
import static constants.Consts.CLOSING_PROGRAM;

public class Main {

    public static void main(String[] args) throws IOException {
        ConsoleService consoleService = new ConsoleService();
        FileService fileService = new FileService(consoleService);
        CryptoService cryptoService = new CryptoService(fileService, consoleService);
        while (true) {
            validateUserChoose(consoleService, cryptoService);
        }
    }

    private static void validateUserChoose(ConsoleService consoleService, CryptoService cryptoService) throws IOException {
        System.out.println(MAIN_MENU);
        int userChoose = consoleService.readIntegersFromConsole();
        if (userChoose == 0) {
            exitProgram();
        } else if (userChoose == 1) {
            cryptoService.crypteProcess(false);
        } else if (userChoose == 2) {
            cryptoService.crypteProcess(true);
        } else if (userChoose == 3) {
            cryptoService.bruteForce();
        } else if (userChoose == 4) {
            cryptoService.statistics();
        } else {
            System.out.println(NOT_VALID_MENU_OPTION);
        }
    }

    private static void exitProgram() {
        System.out.println(CLOSING_PROGRAM);
        System.exit(0);
    }
}
