package arekceg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DinglemouseTest {

    @Test
    public void test() {
        assertArrayEquals(new int[]{8, 8, 9, 9, 10, 10}, Dinglemouse.sort(new int[]{8, 8, 9, 9, 10, 10}));
        assertArrayEquals(new int[]{4, 1, 3, 2}, Dinglemouse.sort(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{9, 999, 99}, Dinglemouse.sort(new int[]{9, 99, 999}));
    }

}