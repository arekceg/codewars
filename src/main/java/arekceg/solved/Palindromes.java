package arekceg.solved;
//https://www.codewars.com/kata/54bb6f887e5a80180900046b/train/java

public class Palindromes {
    public static int longestPalindrome(final String s) {
        if (s.length() < 1)
            return 0;
        int maxLength = 1;
        // iterate over the whole string
        for (int i = 0; i < s.length(); i++) {
            // for each letter of the string go through
            // the remaning part of the string, look for palindromes
            for (int j = 0; j <= s.length() - i; j++) {
                String currentSubstring = s.substring(i, i + j);
                if (checkIfPalindrome(currentSubstring)) {
                    maxLength = Math.max(maxLength, currentSubstring.length());
                }
            }
        }
        return maxLength;
    }

    public static boolean checkIfPalindrome(String substring) {
        if (substring.length() < 1)
            return false;
        for (int i = 0; i < substring.length() / 2; i++) {
            if (substring.charAt(i) != substring.charAt(substring.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}