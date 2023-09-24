package service;

import validarors.InputValidator;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static constants.Consts.ALPHABET;
import static constants.Consts.ENTER_SHIFT;

public class CryptoService {
    private final FileService fileService;
    private final ConsoleService consoleService;

    public CryptoService(FileService fileService, ConsoleService consoleService) {
        this.fileService = fileService;
        this.consoleService = consoleService;
    }

    /**
     * Зашифровывает текст
     */
    public void encrypt() throws IOException {
        List<String> lines = fileService.readFile();
        String outputFile = fileService.checkOutputFile();
        System.out.println("Enter shift: ");
        int shift = consoleService.readIntegersFromConsole();
        for (String line : lines) {
            String newLine = sypher(line, shift);
            fileService.writeToFile(outputFile, newLine);
        }
    }

    /**
     * Расшифровывает текст
     */
    public void decrypt() throws IOException {
        List<String> lines = fileService.readFile();
        String outputFile = fileService.checkOutputFile();
        System.out.println(ENTER_SHIFT);
        int shift = consoleService.readIntegersFromConsole();
        for (String line : lines) {
            String newLine = sypher(line, -shift);
            fileService.writeToFile(outputFile, newLine);
        }
    }

    public void bruteForce() {
        /*
         */
    }

    public void statistics() {

    }

    /**
     * Процесс, который изменяет текст
     */
    private String sypher(String originalStr, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < originalStr.length(); i++) {
            int originalCharIndex = ALPHABET.indexOf(originalStr.charAt(i));
            int resultCharIndex = (ALPHABET.size() + originalCharIndex + shift) % ALPHABET.size();
            result.append(ALPHABET.get(resultCharIndex));
        }
        return result.toString();
    }
}
