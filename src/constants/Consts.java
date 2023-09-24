package constants;

import java.util.List;

public class Consts {
    public static final String MAIN_MENU = """
            CryptoAnalyzer menu:
            1 - Create cypher (encrypt)
            2 - Unmake cypher (decrypt)
            3 - BruteForce4 - Statistics
            0 - exit program
            Please enter a number : """;
    public static final String EXTRA_INFORMATION = "Please enter source file, output file and shift!";
    public static final String NOT_VALID_MENU_OPTION = "This is not a valid Menu option! Select another!";
    public static final String CLOSING_PROGRAM = "Closing program...";
    public static final List<String> NOT_VALID_FILES = List.of(
            //Linux system files
            ".bash_profile",
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
            ".xsession"
            //Windows system files
             );

    private Consts() {
    }
}
