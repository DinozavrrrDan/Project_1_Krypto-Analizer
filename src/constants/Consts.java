package constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Consts {
    public static final String MAIN_MENU = """
            CryptoAnalyzer menu:
            1 - Create cypher (encrypt)
            2 - Unmake cypher (decrypt)
            3 - BruteForce
            0 - exit program
            Please enter a number : """;
    public static final String OUTPUT_FILE_MENU = """
            Do you need to create file?
            1 - Yes
            Other - No """;
    public static final String EXTRA_INFORMATION = "Please enter source file, output file and shift!";
    public static final String NOT_VALID_MENU_OPTION = "This is not a valid Menu option! Select another!";
    public static final String CLOSING_PROGRAM = "Closing program...";
    public static final String ENTER_NEW_FILE_NAME = "Enter new file name: ";
    public static final String ENTER_FILE_NAME = "Enter file name: ";
    public static final String ENTER_SHIFT = "Enter shift: ";
    public static final String BRUTE_FORCE_WRONG = "Brute force wrong!";
    public static final String BRUTE_FORCE_COMPLETE = "Brute force complete: shift is ";
    public static final String[] WORDS_FOR_BRUTE_FORCE = {
            "you ", "to ", "the ", "and ", "that ", "it ", "of ", "me ", "what ",
            "in ", "this ", "know ", "for ", "no ", "not ", "do ", "be ", "been ",
            "on ", "your ", "was ", "we ", "with ", "so ", "but ", "all ", "well ",
            "he ", "about ", "right ", "get ", "here ", "out ", "like ", "yeah ", "if ",
            "her ", "she ", "can ", "up ", "want ", "think ", "now ", "go ", "him ", "at "
    };
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
    public static final List<Character> ALPHABET = new ArrayList<>(Arrays.asList('A', 'a', 'B', 'b', 'C', 'c', 'D', 'd',
            'E', 'e', 'F', 'f', 'G', 'g', 'H', 'h',
            'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l',
            'M', 'm', 'N', 'n', 'O', 'o', 'P', 'p',
            'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
            'U', 'u', 'V', 'v', 'W', 'w', 'X', 'x',
            'Y', 'y', 'Z', 'z', ' ', '.', ',', '?',
            '!', ';', ':', '\''));

    private Consts() {
    }
}
