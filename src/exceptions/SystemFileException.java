package exceptions;

import java.io.IOException;

public class SystemFileException extends IOException {
    public SystemFileException(String message) {
        super(message);
    }
}
