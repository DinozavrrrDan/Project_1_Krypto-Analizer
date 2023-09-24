package service;

import exceptions.SystemFileException;
import validarors.FileValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import static constants.Errors.ENTER_FILE_NAME;
import static constants.Errors.BAD_FILE;
import static constants.Errors.FILE_IS_NOT_WRITTEN;

public class FileService {

    private final FileValidator fileValidator = new FileValidator();

    /**
     *
     * Чтение текста из файла
     *
     * @param input
     * @return
     * @throws IOException
     */
    public List<String> readFile(Scanner input) throws IOException {
        System.out.println(ENTER_FILE_NAME);
        input.nextLine();
        String file = input.nextLine();
        if (fileValidator.isSystemFile(Path.of(file))) {
            throw new SystemFileException(BAD_FILE);
        } else {
            return Files.readAllLines(Path.of(file));
        }
    }

    /**
     *
     * Запись в файл
     *
     * @param file
     * @param writeStr
     * @param needToCreateFile
     * @throws IOException
     */
    public void writeToFile(String file, String writeStr, boolean needToCreateFile) throws IOException {
        try {
            if (needToCreateFile){
                file = Files.createFile(Path.of(file)).toString();
            }
            Files.writeString(Path.of(file), writeStr);
        } catch (IOException e) {
            throw new RuntimeException(FILE_IS_NOT_WRITTEN);
        }


    }

    /**
     *
     * ?????
     *
     * @param input
     * @return
     * @throws SystemFileException
     */
    public String needFile(Scanner input) throws SystemFileException {
        System.out.println(ENTER_FILE_NAME);
        String file = input.nextLine();
        if (fileValidator.isSystemFile(Path.of(file))) {
            throw new SystemFileException(BAD_FILE);
        } else {
            return file;
        }
    }
}
