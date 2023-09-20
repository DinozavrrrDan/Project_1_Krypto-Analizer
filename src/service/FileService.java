package service;

import exceptions.SystemFileException;
import validarors.FileValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class FileService {
    private final FileValidator fileValidator = new FileValidator();

    public List<String> readFile(Scanner input) throws IOException {
        System.out.println("Enter file name: ");
        input.nextLine();
        String file = input.nextLine();
        if (fileValidator.isSystemFile(Path.of(file))) {
            throw new SystemFileException("Bad file!");
        } else {
            return Files.readAllLines(Path.of(file));
        }
    }

    public void writeToFile(String file, String writeStr, boolean needToCreateFile) throws IOException {
        try {
            if (needToCreateFile){
                file = Files.createFile(Path.of(file)).toString();
            }
            Files.writeString(Path.of(file), writeStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public String needFile(Scanner input) throws SystemFileException {
        System.out.println("Enter name of output file:");
        String file = input.nextLine();
        if (fileValidator.isSystemFile(Path.of(file))) {
            throw new SystemFileException("Bad file!");
        } else {
            return file;
        }
    }
}
