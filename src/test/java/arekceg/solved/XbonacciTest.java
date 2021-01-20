package arekceg.solved;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class XbonacciTest {
  private Xbonacci variabonacci;

  @BeforeEach
  public void setUp() throws Exception {
    variabonacci = new Xbonacci();
  }

  @AfterEach
  public void tearDown() throws Exception {
    variabonacci = null;
  }

  private double precision = 1e-10;

  @Test
  public void printoutDebugTest() {
    Arrays.stream(variabonacci.tribonacci(new double[] { 6.0, 20.0, 14.0 }, 42)).forEach(System.out::println);
  }

  @Test
  public void sampleTests() {
    assertArrayEquals(new double[] { 1, 1, 1, 3, 5, 9, 17, 31, 57, 105 },
        variabonacci.tribonacci(new double[] { 1, 1, 1 }, 10), precision);
    assertArrayEquals(new double[] { 0, 0, 1, 1, 2, 4, 7, 13, 24, 44 },
        variabonacci.tribonacci(new double[] { 0, 0, 1 }, 10), precision);
    assertArrayEquals(new double[] { 0, 1, 1, 2, 4, 7, 13, 24, 44, 81 },
        variabonacci.tribonacci(new double[] { 0, 1, 1 }, 10), precision);
  }

  @Test
  public void simpleTest() {
    assertArrayEquals(new double[] { 1, 2, 3 }, variabonacci.tribonacci(new double[] { 1, 2, 3 }, 3));
    assertArrayEquals(new double[] { 1, 2 }, variabonacci.tribonacci(new double[] { 1, 2, 3 }, 2));
    assertArrayEquals(new double[] { 1 }, variabonacci.tribonacci(new double[] { 1, 2, 3 }, 1));
  }
}
