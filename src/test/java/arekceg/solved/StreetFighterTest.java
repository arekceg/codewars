package arekceg.solved;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class StreetFighterTest {

    String[][] fighters = new String[][] { new String[] { "Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega" },
            new String[] { "Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison" }, };

    @Test
    public void shouldWorkWithNoMoves() {
        String[] solution = new String[] {};
        assertArrayEquals(solution,
                StreetFighter.streetFighterSelection(fighters, new int[] { 0, 0 }, new String[] {}));
    }

    @Test
    public void shouldWorkWithFewMoves() {
        String[] moves = new String[] { "up", "left", "right", "left", "left" };
        String[] solution = new String[] { "Ryu", "Vega", "Ryu", "Vega", "Balrog" };
        assertArrayEquals(solution, StreetFighter.streetFighterSelection(fighters, new int[] { 0, 0 }, moves));
    }

    @Test
    public void shouldWorkWhenAlwaysMovingLeft() {
        String[] moves = new String[] { "left", "left", "left", "left", "left", "left", "left", "left" };
        String[] solution = new String[] { "Vega", "Balrog", "Guile", "Blanka", "E.Honda", "Ryu", "Vega", "Balrog" };
        assertArrayEquals(solution, StreetFighter.streetFighterSelection(fighters, new int[] { 0, 0 }, moves));
    }

    @Test
    public void shouldWorkWhenAlwaysMovingRight() {
        String[] moves = new String[] { "right", "right", "right", "right", "right", "right", "right", "right" };
        String[] solution = new String[] { "E.Honda", "Blanka", "Guile", "Balrog", "Vega", "Ryu", "E.Honda", "Blanka" };
        assertArrayEquals(solution, StreetFighter.streetFighterSelection(fighters, new int[] { 0, 0 }, moves));
    }

    @Test
    public void shouldUseAll4DirectionsClockwiseTwice() {
        String[] moves = new String[] { "up", "left", "down", "right", "up", "left", "down", "right" };
        String[] solution = new String[] { "Ryu", "Vega", "M.Bison", "Ken", "Ryu", "Vega", "M.Bison", "Ken" };
        assertArrayEquals(solution, StreetFighter.streetFighterSelection(fighters, new int[] { 0, 0 }, moves));
    }

    @Test
    public void shouldWorkWhenAlwaysMovingDown() {
        String[] moves = new String[] { "down", "down", "down", "down" };
        String[] solution = new String[] { "Ken", "Ken", "Ken", "Ken" };
        assertArrayEquals(solution, StreetFighter.streetFighterSelection(fighters, new int[] { 0, 0 }, moves));
    }

    @Test
    public void shouldWorkWhenAlwaysMovingUp() {
        String[] moves = new String[] { "up", "up", "up", "up" };
        String[] solution = new String[] { "Ryu", "Ryu", "Ryu", "Ryu" };
        assertArrayEquals(solution, StreetFighter.streetFighterSelection(fighters, new int[] { 0, 0 }, moves));
    }

    @Test
    public void moveTest_up() {
        String move = "up";
        final int[] startingPostigion = new int[] { 0, 0 };
        final int[] expectedPostion = new int[] { 0, 0 };
        assertArrayEquals(expectedPostion, StreetFighter.move(fighters, startingPostigion, move));
        final int[] startingPostigion2 = new int[] { 0, -1 };
        final int[] expectedPostion2 = new int[] { 0, 0 };
        assertArrayEquals(expectedPostion2, StreetFighter.move(fighters, startingPostigion2, move));
    }

    @Test
    public void moveTest_down() {
        String move = "down";
        final int[] startingPostigion = new int[] { 0, 0 };
        final int[] expectedPostion = new int[] { 0, -1 };
        assertArrayEquals(expectedPostion, StreetFighter.move(fighters, startingPostigion, move));
        final int[] startingPostigion2 = new int[] { 0, -1 };
        final int[] expectedPostion2 = new int[] { 0, -1 };
        assertArrayEquals(expectedPostion2, StreetFighter.move(fighters, startingPostigion2, move));
    }
}
