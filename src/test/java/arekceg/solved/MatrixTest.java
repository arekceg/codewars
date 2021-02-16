package arekceg.solved;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

import arekceg.solved.Matrix;

public class MatrixTest {

    @Test
    public void test() {
        Matrix m1 = new Matrix(new double[][] {
            new double[] { 5,       -3, 2.5 },
            new double[] { -42.117, 69, 73.614 },
            new double[] { 52.35,   4,  -11 },
        });

        Matrix m2 = new Matrix(3, 3,
            -4.25,  58.667,   24.3,
            514.5,  88,       -144.15,
            499.51, -343.176, 1214.2
        );

        Matrix m3 = new Matrix(2, 3,
            1,      2,        3,
            -4,     3,        1
        );

        Matrix m4 = new Matrix(3, 2,
            5,      2,
            -4,     1,
            -2,     -1
        );

//        assertArrayEquals(new double[][] {
//            new double[] { 5,     -42.117, 52.35 },
//            new double[] { -3,    69,      4 },
//            new double[] { 2.5,   73.614,  -11 }
//        }, m1.transpose().toArray());
//
//        assertArrayEquals(new double[][] {
//            new double[] { 1,    -4 },
//            new double[] { 2,    3 },
//            new double[] { 3,    1 }
//        }, m3.transpose().toArray());
//
//        assertArrayEquals(new double[][] {
//            new double[] { 0.75,    55.667,   26.8 },
//            new double[] { 472.383, 157,      -70.536 },
//            new double[] { 551.86,  -339.176, 1203.2 }
//        }, m1.add(m2).toArray());
//
//        assertArrayEquals(new double[][] {
//            new double[] { 2,   4,   6 },
//            new double[] { -8,  6,   2 }
//        }, m3.multiply(2).toArray());

        assertArrayEquals(new double[][] {
            new double[] { -9,  1 },
            new double[] { -34, -6 }
        }, m3.multiply(m4).toArray());
    }
}
