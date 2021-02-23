package arekceg.solved;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CaesarCipherTest {

    @Test
    public void test1() {
        String u = "I should have known that you would have a perfect answer for me!!!";
        List<String> v = Arrays.asList("J vltasl rlhr ", "zdfog odxr ypw", " atasl rlhr p ", "gwkzzyq zntyhv", " lvz wp!!!");
        assertEquals(v, CaesarCipher.movingShift(u, 1));
        assertEquals(u, CaesarCipher.demovingShift(CaesarCipher.movingShift(u, 1), 1));
    }

//    @Test
//    public void stringSplitTest() {
//        final String stringLength17 = "12345678901234567";
//        final String stringLength16 = "1234567890123456";
//        final String stringLength15 = "123456789012345";
//        final String stringLength12 = "123456789012";
//        final String stringLength11 = "12345678901";
//        final String stringLength9 = "123456789";
//        List<String> testList17 = Arrays.asList("1234", "5678", "9012", "3456", "7");
//        List<String> testList16 = Arrays.asList("1234", "5678", "9012", "3456", "");
//        List<String> testList15 = Arrays.asList("123", "456", "789", "012", "345");
//        List<String> testList12 = Arrays.asList("123", "456", "789", "012", "");
//        List<String> testList11 = Arrays.asList("123", "456", "789", "01", "");
//        List<String> testList9 = Arrays.asList("12", "34", "56", "78", "9");
//        assertTrue(compareListContents(testList17, CaesarCipher.splitStringIntoFiveParts(stringLength17)));
//        assertTrue(compareListContents(testList16, CaesarCipher.splitStringIntoFiveParts(stringLength16)));
//        assertTrue(compareListContents(testList15, CaesarCipher.splitStringIntoFiveParts(stringLength15)));
//        assertTrue(compareListContents(testList12, CaesarCipher.splitStringIntoFiveParts(stringLength12)));
//        assertTrue(compareListContents(testList11, CaesarCipher.splitStringIntoFiveParts(stringLength11)));
//        assertTrue(compareListContents(testList9, CaesarCipher.splitStringIntoFiveParts(stringLength9)));
//    }

    private boolean compareListContents(List<String> list1, List<String> list2) {
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) return false;
        }
        return true;
    }
}
