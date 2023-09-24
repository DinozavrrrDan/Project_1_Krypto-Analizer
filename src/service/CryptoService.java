package service;

import exceptions.BruteForceException;

import java.io.IOException;
import java.util.List;

import static constants.Consts.ALPHABET;
import static constants.Consts.BRUTE_FORCE_COMPLETE;
import static constants.Consts.BRUTE_FORCE_WRONG;
import static constants.Consts.ENTER_SHIFT;
import static constants.Consts.EXTRA_INFORMATION;
import static constants.Consts.WORDS_FOR_BRUTE_FORCE;

public class CryptoService {

    private final FileService fileService;
    private final ConsoleService consoleService;

    public CryptoService(FileService fileService, ConsoleService consoleService) {
        this.fileService = fileService;
        this.consoleService = consoleService;
    }

    /**
     * Зашифровывает или расшифровывает текст в зависимости от флага
     */
    public void crypteProcess(boolean decryptFlag) throws IOException {
        System.out.println(EXTRA_INFORMATION);
        List<String> lines = fileService.readFile();
        String outputFile = fileService.checkOutputFile();
        System.out.println(ENTER_SHIFT);
        int shift = consoleService.readIntegersFromConsole();
        process(lines, outputFile, decryptFlag ? -shift : shift);
    }

    /**
     * Реализует алгоритм BruteForce
     */
    public void bruteForce() throws IOException {
        List<String> lines = fileService.readFile();
        String outputFile = fileService.checkOutputFile();
        bruteForceProcess(lines, outputFile);
    }

    public void statistics() {

    }

    /**
     * Реализует расшифровку brute force, иначе кидает исключение
     */
    private void bruteForceProcess(List<String> lines, String outputFile) throws IOException {
        int goodCounter = 0;
        int badCounter = 0;
        for (int i = 1; i < ALPHABET.size(); i++) {
            process(lines, outputFile, -i);
            for (String line : lines) {
                for (String s : WORDS_FOR_BRUTE_FORCE) {
                    if (line.toLowerCase().contains(s)) {
                        goodCounter++;
                    } else {
                        badCounter++;
                    }
                }
                for (int j = 0; j < line.length() - 1; j++) {
                    if (line.charAt(j) == ',' || line.charAt(j) == '!'
                            || line.charAt(j) == ':' || line.charAt(j) == ';' || line.charAt(j) == '?') {
                        if (line.charAt(j + 1) == ' ') {
                            goodCounter++;
                        } else {
                            badCounter++;
                        }
                    }
                }
            }
            if (isBruteForceDone(goodCounter, badCounter)) {
                System.out.println(BRUTE_FORCE_COMPLETE + i);
                return;
            }
        }
        throw new BruteForceException(BRUTE_FORCE_WRONG);
    }

    private static boolean isBruteForceDone(int goodCounter, int badCounter) {
        return goodCounter > badCounter * 2;
    }

    /**
     * Шифровка/Дешифровка и запись в файл
     */
    private void process(List<String> lines, String outputFile, int shift) throws IOException {
        for (String line : lines) {
            String newLine = sypher(line, shift);
            fileService.writeToFile(outputFile, newLine);
        }
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
