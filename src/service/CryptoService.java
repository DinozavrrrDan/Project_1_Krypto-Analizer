package service;

import exceptions.SystemFileException;
import validarors.FileValidator;
import validarors.InputValidator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CryptoService {
    private final FileService fileService = new FileService();
    private final InputValidator inputValidator = new InputValidator();
    public static final List<Character> alphabet = new ArrayList<>(Arrays.asList('A', 'a', 'B', 'b', 'C', 'c', 'D', 'd',
            'E', 'e', 'F', 'f', 'G', 'g', 'H', 'h',
            'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l',
            'M', 'm', 'N', 'n', 'O', 'o', 'P', 'p',
            'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
            'U', 'u', 'V', 'v', 'W', 'w', 'X', 'x',
            'Y', 'y', 'Z', 'z'));

    public void encrypt(Scanner input) throws IOException {
        List<String> lines = fileService.readFile(input);
        String outputFile = fileService.needFile(input);
        int shift = inputValidator.validateChoise(input);
        for (String line : lines) {
            String newLine = sypher(line, shift);
            fileService.writeToFile(outputFile, newLine, false);
        }

    }

    public void decrypt(Scanner input) throws IOException {
        List<String> lines = fileService.readFile(input);
        String outputFile = fileService.needFile(input);
        int shift = inputValidator.validateChoise(input);
        for (String line : lines) {
            String newLine = sypher(line, -shift);
            fileService.writeToFile(outputFile, newLine, false);
        }
    }

    public void bruteForce(Scanner input) {

    }

    public void statistics(Scanner input) {

    }

    private String sypher(String originalStr, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < originalStr.length(); i++) {
            int originalCharIndex = alphabet.indexOf(originalStr.charAt(i));
            int resultCharIndex = (alphabet.size() + originalCharIndex + shift * 2) % alphabet.size();
            result.append(alphabet.get(resultCharIndex));
        }
        return result.toString();
    }
}
