package arekceg.solved;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StripComments {

    public static String stripComments(String text, String[] commentSymbols) {
        String finalString = text.lines()
            .map(line -> removeCommentsFromLine(commentSymbols, line))
            .collect(Collectors.joining("\n"));
        return finalString;
    }

    private static String removeCommentsFromLine(String[] commentSymbols, String string) {
        char currentCharacter;
        int commentSymbolIndex = string.length();
        for (int i = 0; i < string.length(); i++) {
            currentCharacter = string.charAt(i);
            if (isCommentSymbol(currentCharacter, commentSymbols)) {
                commentSymbolIndex = i;
                break;
            }
        }
        return string.substring(0, commentSymbolIndex).stripTrailing();

    }

    private static boolean isCommentSymbol(char c, String[] commentSymbols) {
        return Arrays.stream(commentSymbols).anyMatch(symbol -> symbol.charAt(0) == c);
    }
}