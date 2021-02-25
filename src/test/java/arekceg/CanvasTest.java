package arekceg;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CanvasTest {
    @Test
    public void drawLines() {
        Canvas c = new Canvas(5, 5);
        c.draw(0, 2, 4, 2).draw(2, 0, 2, 4);
        assertEquals("-------\n|  x  |\n|  x  |\n|xxxxx|\n|  x  |\n|  x  |\n-------", c.drawCanvas());
    }

    @Test
    public void drawRectangle() {
        Canvas c = new Canvas(7, 7);
        c.draw(1, 1, 5, 4);
        assertEquals("---------\n|       |\n| xxxxx |\n| x   x |\n| x   x |\n| xxxxx |\n|       |\n|       |\n---------", c.drawCanvas());
    }

    @Test
    public void fill() {
        Canvas c = new Canvas(7, 7);
        c.draw(1, 1, 5, 4).fill(3, 3, 'o');
        assertEquals("---------\n|       |\n| xxxxx |\n| xooox |\n| xooox |\n| xxxxx |\n|       |\n|       |\n---------", c.drawCanvas());
    }

    @Test
    public void functionTest() {
        System.out.println(Canvas.findFunctionBetween(2, 4, 6, 8));
        System.out.println(Canvas.findFunctionBetween(1, 9, 3, 4));
    }

    @Test
    public void drawLinesTestMine() {
        Canvas c = new Canvas(50, 50);
        c.draw(7, 1, 49, 20)
                .draw(2, 0, 2, 4)
                .draw(8, 10, 30, 28)
                .draw(4, 27, 30, 5);
        System.out.println(c.drawCanvas());
    }
}
