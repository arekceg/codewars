package arekceg.solved;
import static org.junit.Assert.*;

import arekceg.solved.PrimeDecomp;
import org.junit.*;

public class PrimeDecompTest {

    @Test
    public void testPrimeDecompOne() {
        int lst = 7775460;
        assertEquals(
                "(2**2)(3**3)(5)(7)(11**2)(17)",
                PrimeDecomp.factors(lst));
        int second = 6494933;
        assertEquals("(41)(157)(1009)", PrimeDecomp.factors(second));
    }

    @Test(timeout = 16000)
    public void largeNumberTest(){
        PrimeDecomp.factors(16175921);
    }
}
