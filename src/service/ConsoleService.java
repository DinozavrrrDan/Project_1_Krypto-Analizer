package service;

import validarors.InputValidator;

import java.util.Scanner;

public class ConsoleService {

    private final Scanner scanner;
    private final InputValidator inputValidator = new InputValidator();

    public ConsoleService() {
        this.scanner = new Scanner(System.in);
    }

    public String readFromConsole(){
        return scanner.nextLine();
    }

    public int readIntegersFromConsole(){
        return inputValidator.validateChoise(scanner);
    }
}
