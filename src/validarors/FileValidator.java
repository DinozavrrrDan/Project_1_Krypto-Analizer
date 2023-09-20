package validarors;

import java.nio.file.Path;
import java.util.List;

public class FileValidator  {
    public static final List<String> notValidFiles = List.of(".bash_profile",
            ".bash_logout",
            ".bash_history",
            ".bashrc",
            ".gtkrc",
            ".login",
            ".logout",
            ".profile",
            ".viminfo",
            ".wm_style",
            ".Xdefaults",
            ".Xresources",
            ".xinitrc",
            ".xsession");

    public boolean isSystemFile(Path path){
        return notValidFiles.contains(path.getFileName().toString());
    }
}
