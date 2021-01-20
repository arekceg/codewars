package arekceg.solved;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PalindromesTest {
    @Test
    public void checkIfPalindromeTest() {
        assertTrue(Palindromes.checkIfPalindrome("asdfdsa"));
        assertTrue(Palindromes.checkIfPalindrome("a"));
        assertTrue(Palindromes.checkIfPalindrome("ababbaba"));
        assertFalse(Palindromes.checkIfPalindrome("abadbbaba"));
        assertFalse(Palindromes.checkIfPalindrome("asdfdsai"));
        assertFalse(Palindromes.checkIfPalindrome("asdfcdsa"));
        assertFalse(Palindromes.checkIfPalindrome(""));
        
    }
    @Test
    public void basicTests() {
        // doTest("a", 1);
        // doTest("aa", 2);
        doTest("baa", 2);
        doTest("aab", 2);
        doTest("zyabyz", 1);
        doTest("baabcd", 4);
        doTest("baablkj12345432133d", 9);
    }
    private void doTest(final String s, int expected) {
        assertEquals(expected, Palindromes.longestPalindrome(s));
    }
}
