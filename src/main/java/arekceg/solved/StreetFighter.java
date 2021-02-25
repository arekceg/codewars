package arekceg.solved;

import java.util.ArrayList;
import java.util.List;

//https://www.codewars.com/kata/556deca17c58da83c00002db/train/java
public class StreetFighter {
    public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves) {
        List<String> fighterSelectionHistory = new ArrayList<>();

        for (String move : moves) {
            position = move(fighters, position, move);
            String currentFighter = fighters[Math.abs(position[1])][position[0]];
            fighterSelectionHistory.add(currentFighter);
        }

        return fighterSelectionHistory.toArray(new String[0]);
    }

    public static int[] move(String[][] fighters, int[] currentPosition, String move) {
        int horizontalSize = fighters[0].length;
        int x = currentPosition[1];
        int y = currentPosition[0];
        final int[] newPosition = currentPosition;
        switch (move) {
            case "up":
                if (x + 1 <= 0)
                    newPosition[1] = x + 1;
                break;
            case "down":
                if (x - 1 >= -1)
                    newPosition[1] = x - 1;
                break;
            case "right":
                if (y + 1 < horizontalSize)
                    newPosition[0] = y + 1;
                else
                    newPosition[0] = 0;
                break;
            case "left":
                if (y - 1 >= 0)
                    newPosition[0] = y - 1;
                else
                    newPosition[0] = horizontalSize - 1;
                break;
            default:
                break;
        }

        return newPosition;
    }

}
