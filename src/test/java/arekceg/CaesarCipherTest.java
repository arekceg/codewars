package arekceg;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
//        final String testString = "123456789123456";
//        List<String> testList = Arrays.asList("123", "456", "789", "123", "456");
//        assertTrue(compareListContents(testList, CaesarCipher.splitEqually(testString)));
//    }
//
//    private boolean compareListContents(List<String> list1, List<String> list2) {
//        if (list1.size() != list2.size()) return false;
//        for (int i = 0; i < list1.size(); i++) {
//            if (!list1.get(i).equals(list2.get(i))) return false;
//        }
//        return true;
//    }
}
