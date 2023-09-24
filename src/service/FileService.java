package service;

import exceptions.SystemFileException;
import validarors.FileValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static constants.Consts.ENTER_FILE_NAME;
import static constants.Consts.ENTER_NEW_FILE_NAME;
import static constants.Consts.OUTPUT_FILE_MENU;
import static constants.Errors.BAD_FILE;

public class FileService {
    private final FileValidator fileValidator = new FileValidator();
    private final ConsoleService consoleService;

    public FileService(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    /**
     * Чтение текста из файла
     */
    public List<String> readFile() throws IOException {
        System.out.println(ENTER_FILE_NAME);
        String file = consoleService.readFromConsole();
        if (fileValidator.isSystemFile(Path.of(file))) {
            throw new SystemFileException(BAD_FILE);
        } else {
            return Files.readAllLines(Path.of(file));
        }
    }

    /**
     * Запись в файл
     */
    public void writeToFile(String file, String writeStr) throws IOException {
            Files.writeString(Path.of(file), writeStr);
    }

    public String checkOutputFile() throws IOException {
        System.out.println(OUTPUT_FILE_MENU);
        String file;
        if (consoleService.readFromConsole().equals("1")){
            System.out.println(ENTER_NEW_FILE_NAME);
            file = Files.createFile(Path.of(consoleService.readFromConsole())).toString();
        } else {
            file = consoleService.readFromConsole();
            if (fileValidator.isSystemFile(Path.of(file))) {
                throw new SystemFileException(BAD_FILE);
            }
        }
        return file;
    }
}
