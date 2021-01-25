import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import arekceg.CarMileage;

public class CarMileageTest {

    @Test
    public void testIntToIntArray() {
        assertArrayEquals(new int[] { 1, 2, 3 }, CarMileage.convertNumberToDigitArray(123));
    }

    @Test
    public void testIsNumberAwesome() {
        assertTrue(CarMileage.isNumerAnAwesomePhrase(1337, new int[] { 1337, 256 }));
    }
    @Test
    public void testIsNumberAPalindrome() {
        assertTrue(CarMileage.isNumberAPalindrome(new int[]{1,2,3,2,1}));
        assertFalse(CarMileage.isNumberAPalindrome(new int[]{1,2,3,1,1,1,1}));
    }
    @Test
    public void testIsNumberSequentialInc() {
        assertTrue(CarMileage.isNumberSequentialInc(new int[]{1,2,3,4,5,6}));
        assertTrue(CarMileage.isNumberSequentialInc(new int[]{8,9,0}));
        assertFalse(CarMileage.isNumberSequentialInc(new int[]{6,7,0}));
        assertFalse(CarMileage.isNumberSequentialInc(new int[]{1,2,3,1,1,1,1}));
    }

    @Test
    public void testIsNumberSequentialDec() {
        assertTrue(CarMileage.isNumberSequentialDec(new int[]{0,9,8,7,6}));
        assertFalse(CarMileage.isNumberSequentialDec(new int[]{1,2,3,1,1,1,1}));
        assertFalse(CarMileage.isNumberSequentialDec(new int[]{1,0,9}));
    }

    @Test
    public void testIsNumberAllSignleDigit() {
        assertTrue(CarMileage.isNumberAllOneDigit(new int[]{1,1,1,1,1,1}));
        assertFalse(CarMileage.isNumberAllOneDigit(new int[]{1,2,3,1,1,1,1}));
    }

    @Test
    public void testIfNumberEndsWithZeroes() {
        assertTrue(CarMileage.isNumberEndingInZeroes(new int[]{1,0,0,0,0}));
        assertFalse(CarMileage.isNumberEndingInZeroes(new int[]{1,0,0,1,0}));
        assertFalse(CarMileage.isNumberEndingInZeroes(new int[]{0,0,0,0,0,0}));
    }

    @Test
    public void testTooSmall() {
        assertEquals(0, CarMileage.isInteresting(3, new int[] { 1337, 256 }));
    }

    @Test
    public void testAlmostAwesome() {
        assertEquals(1, CarMileage.isInteresting(1336, new int[] { 1337, 256 }));
    }

    @Test
    public void testAwesome() {
        assertEquals(2, CarMileage.isInteresting(1337, new int[] { 1337, 256 }));
    }

    @Test
    public void testFarNotInteresting() {
        assertEquals(0, CarMileage.isInteresting(11208, new int[] { 1337, 256 }));
    }

    @Test
    public void testAlmostInteresting() {
        assertEquals(1, CarMileage.isInteresting(11209, new int[] { 1337, 256 }));
    }

    @Test
    public void testInteresting() {
        assertEquals(2, CarMileage.isInteresting(11211, new int[] { 1337, 256 }));
    }

    @Test
    public void testUpcomingMonotone() {
        assertEquals(1, CarMileage.isInteresting(109, new int[] { 1337, 256 }));
    }

}
