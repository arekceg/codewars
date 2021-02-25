package arekceg.solved;

import java.util.ArrayList;
import java.util.List;

//https://www.codewars.com/kata/58583922c1d5b415b00000ff/train/java
public class SuperStreetFighter {
    public static String[] superStreetFighterize(String[][] fighters, int[] position, String[] moves) {
        final List<String> fighterSelectionHistory = new ArrayList<>();

        for (String move : moves) {
            position = move(fighters, position, move);
            final String currentFighter = fighters[Math.abs(position[0])][position[1]];
            fighterSelectionHistory.add(currentFighter);
        }

        return fighterSelectionHistory.toArray(new String[0]);
    }

    public static int[] move(String[][] fighters, int[] currentPosition, String move) {
        final int horizontalSize = fighters[0].length;
        final int verticalSize = fighters.length;
        final int currentX = currentPosition[1];
        final int currentY = currentPosition[0];
        int newX = currentX;
        int newY = currentY;
        switch (move) {
            case "up":
                newY = currentY - 1;
                if (newY < 0 || newPositionIsBlank(currentX, newY, fighters))
                    newY = currentY;
                break;
            case "down":
                newY = currentY + 1;
                if (newY >= verticalSize || newPositionIsBlank(currentX, newY, fighters))
                    newY = currentY;
                break;
            case "right":
                newX = currentX + 1;
                if (newX >= horizontalSize) {
                    newX = 0;
                }
                if (newPositionIsBlank(newX, currentY, fighters)) {
                    newX = move(fighters, new int[]{currentY, newX}, "right")[1];
                }
                break;
            case "left":
                newX = currentX - 1;
                if (newX < 0) {
                    newX = horizontalSize - 1;
                }
                if (newPositionIsBlank(newX, currentY, fighters)) {
                    newX = move(fighters, new int[]{currentY, newX}, "left")[1];
                }
                break;
            default:
                break;
        }

        return new int[]{newY, newX};
    }

    private static boolean newPositionIsBlank(int x, int y, String[][] fighters) {
        return fighters[y][x].equalsIgnoreCase("");
    }
}
