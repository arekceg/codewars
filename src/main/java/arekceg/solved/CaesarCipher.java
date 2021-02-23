package arekceg.solved;

import java.util.ArrayList;
import java.util.List;

//https://www.codewars.com/kata/5508249a98b3234f420000fb/train/java
public class CaesarCipher {
    final static int NUMBER_OF_RUNNERS = 5;

    public static List<String> movingShift(String s, int shift) {
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                if (shift > 26) shift = reduceShift(shift);
                chars[i] = encryptUnicode(chars[i], shift);
            }
            shift++;
        }
        final String encodedString = String.valueOf(chars).intern();
        return splitStringIntoFiveParts(encodedString);
    }

    public static String demovingShift(List<String> s, int shift) {
        final String encodedString = String.join("", s);
        final char[] chars = encodedString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                if (shift > 26) shift = reduceShift(shift);
                chars[i] = decryptUnicode(chars[i], shift);
            }
            shift++;
        }
        return String.valueOf(chars).intern();
    }

    private static int reduceShift(int shift) {
        while (shift > 26) {
            shift -= 26;
        }
        return shift;
    }

    private static List<String> splitStringIntoFiveParts(String s) {
        final int desiredSingleStringLength = (int) Math.ceil(s.length() / 5.0);
        final List<String> split = new ArrayList<>();
        boolean endOfStringReached = false;
        int j = 0;
        for (int i = 0; i < NUMBER_OF_RUNNERS; i++) {
            if (!endOfStringReached) {
                split.add(s.substring(j, j + desiredSingleStringLength));
                j += desiredSingleStringLength;
            } else {
                split.add(s.substring(j));
                j = s.length();
            }
            endOfStringReached = j + desiredSingleStringLength >= s.length();
        }
        return split;
    }

    private static char encryptUnicode(char ch, int shift) {
        if (Character.isLowerCase(ch)) {
            return encryptUnicodeLowercase(ch, shift);
        } else {
            return encryptUnicodeUppercase(ch, shift);
        }
    }

    private static char decryptUnicode(char ch, int shift) {
        if (!Character.isLetter(ch)) return ch;
        while (shift > 26) {
            shift -= 26;
        }
        if (Character.isLowerCase(ch)) {
            return decryptUnicodeLowercase(ch, shift);
        } else {
            return decryptUnicodeUppercase(ch, shift);
        }
    }

    private static char encryptUnicodeLowercase(char ch, int shift) {
        if (ch + shift <= 'z') {
            return (char) (ch + shift);
        } else {
            return (char) (ch - (26 - shift));
        }
    }

    private static char encryptUnicodeUppercase(char ch, int shift) {
        if (ch + shift <= 'Z') {
            return (char) (ch + shift);
        } else {
            return (char) (ch - (26 - shift));
        }
    }

    private static char decryptUnicodeLowercase(char ch, int shift) {
        if (ch - shift >= 'a') {
            return (char) (ch - shift);
        } else {
            return (char) (ch + (26 - shift));
        }
    }

    private static char decryptUnicodeUppercase(char ch, int shift) {
        if (ch - shift >= 'A') {
            return (char) (ch - shift);
        } else {
            return (char) (ch + (26 - shift));
        }
    }
}
