package arekceg;

import java.util.ArrayList;
import java.util.List;
//https://www.codewars.com/kata/5508249a98b3234f420000fb/train/java
public class CaesarCipher {
    public static List<String> movingShift(String s, int shift) {
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = shiftUnicode(chars[i], shift++);
        }
        final String encodedString = String.valueOf(chars).intern();
        final List<String> split = splitInputStringIntoFiveParts(encodedString);
        return null;
    }

    private static List<String> splitInputStringIntoFiveParts(String s) {
        final int stringLength = s.length();
        if (stringLength % 5 == 0) return splitEqually(s);

        return null;
    }

    public static String demovingShift(List<String> s, int shift) {
        return null;
    }

    private static char shiftUnicode(char ch, int shift) {
        if (!Character.isLetter(ch)) return 0;
        if (Character.isLowerCase(ch)) {
            return shiftLowerCase(ch, shift);
        } else {
            return shiftUpperCaseUnicode(ch, shift);
        }
    }

    private static char shiftUpperCaseUnicode(char ch, int shift) {
        if (ch + shift <= 'Z') {
            return (char) (ch + shift);
        } else {
            return (char) (ch - (26 - shift));
        }
    }

    private static char shiftLowerCase(char ch, int shift) {
        if (ch + shift <= 'z') {
            return (char) (ch + shift);
        } else {
            return (char) (ch - (26 - shift));
        }
    }

    private static List<String> splitEqually(String s) {
        final List<String> split = new ArrayList<>();
        for (int i = 0; i < s.length(); i += s.length() / 5) {
            split.add(s.substring(i, i + s.length() / 5));
        }
        return split;
    }

}
