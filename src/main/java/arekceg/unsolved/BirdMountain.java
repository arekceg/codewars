package arekceg.unsolved;
//https://www.codewars.com/kata/5c09ccc9b48e912946000157/train/java
public class BirdMountain {

    public static int peakHeight(char[][] mountain) {
    /*
    pierwsz i ostatnia tabela zawsze 1
    pierwsza i ostatnia pozycja zawsze 1
    sprawdź czy pozycja za toba i "nad" tobą to cyfra
    jeżeli tak to ty jesteś najniższa z cyfr +1
    */
        int maxHeight = 1;
        int pointHeight;
        for (int i = 1; i < mountain.length; i++) {
            for (int j = 0; j < mountain[i].length; j++) {
                if (mountain[i][j] == ' ') {
                    System.out.print(" ");
                    continue;
                }
                if(j > mountainCenterAtRow(i-1, mountain)) continue;
                pointHeight = heightAtCoordinates(i, j, mountain);
                System.out.print(pointHeight);
                maxHeight = Math.max(maxHeight, pointHeight);
            }
            System.out.print("\n");
        }
        return maxHeight;
    }

    public static int heightAtCoordinates(int row, int col, char[][] mountain) {
        if (mountain[row][col] == ' ') return 0;
        if (row == 0 || col == 0 || row == mountain.length - 1 || col == mountain[0].length - 1) return 1;
        if (col <= mountainCenterAtRow(row, mountain)) {
            int heightWest = heightAtCoordinates(row, col - 1, mountain);
            int heightNorth = heightAtCoordinates(row - 1, col, mountain);
            if (heightNorth == 0 || heightWest == 0) return 1;
            return Math.min(heightNorth, heightWest) + 1;
        } else {
            int heightEast = heightAtCoordinates(row, col + 1, mountain);
            int heightNorth = heightAtCoordinates(row - 1, col, mountain);
            if (heightNorth == 0 || heightEast == 0) return 1;
            return Math.min(heightNorth, heightEast) + 1;
        }
    }

    public static int mountainCenterAtRow(int row, char[][] mountain) {
        char[] mountainAtRow = mountain[row];
        String mountainAtRowString = String.valueOf(mountainAtRow);
        int startOfMountainIndex = mountainAtRowString.indexOf("^");
        int endOfMountainIndex = mountainAtRowString.lastIndexOf("^");
//        for (int i = startOfMountainIndex + 1; i <= endOfMountainIndex; i++) {
//            if (heightAtCoordinates(row, i, mountain) > heightAtCoordinates(row, i - 1, mountain)){
//                return i - 1;
//            }
//        }
        return (startOfMountainIndex + endOfMountainIndex) / 2;
    }
}
