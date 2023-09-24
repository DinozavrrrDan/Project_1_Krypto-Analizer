package validarors;

import java.nio.file.Path;

import static constants.Consts.NOT_VALID_FILES;

public class FileValidator  {

    public boolean isSystemFile(Path path){
        return NOT_VALID_FILES.contains(path.getFileName().toString());
    }
}
