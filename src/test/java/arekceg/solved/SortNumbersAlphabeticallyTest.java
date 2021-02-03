package arekceg.solved;

import arekceg.solved.SortNumbersAlphabetically;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortNumbersAlphabeticallyTest {

    @Test
    public void test() {
        assertArrayEquals(new int[]{8, 8, 9, 9, 10, 10}, SortNumbersAlphabetically.sort(new int[]{8, 8, 9, 9, 10, 10}));
        assertArrayEquals(new int[]{4, 1, 3, 2}, SortNumbersAlphabetically.sort(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{9, 999, 99}, SortNumbersAlphabetically.sort(new int[]{9, 99, 999}));
    }

}