package arekceg;


//https://www.codewars.com/kata/58eb35b19925753a750000eb/train/java
class Canvas {
    private final String[][] canvasArray;

    public Canvas(int width, int height) {
        canvasArray = new String[height][width];
        for (int i = 0; i < canvasArray.length; i++) {
            for (int j = 0; j < canvasArray[i].length; j++) {
                canvasArray[i][j] = " ";
            }
        }
    }

    public static String findFunctionBetween(int x1, int y1, int x2, int y2) {
        double a = ((double) y2 - y1) / (x2 - x1);
        double b = -a * x1 + y1;
        return "y = " + a + "x + " + b;
    }

    public Canvas draw(int x1, int y1, int x2, int y2) {
        // create function y = ax + b
        // between two points
        double a;
        if (x2 == x1) {
            a = 1;
        } else {
            a = (double) (y2 - y1) / (x2 - x1);
        }
        double b = -a * x1 + y1;
        if (x2 == x1) {
            for (int i = y1; i <= y2; i++) {
                canvasArray[i][x1] = "x";
            }
        } else if (y2 == y1) {
            for (int i = x1; i <= x2; i++) {
                canvasArray[y1][i] = "x";
            }
        } else {
            for (int i = x1; i <= x2; i++) {
                int y = (int) (a * i + b);
                canvasArray[y][i] = "x";
            }
        }
        return this;
    }

    public Canvas fill(int x, int y, char ch) {
        return this;
    }

    public String drawCanvas() {
//        canvasArray = new String[height + 2][width + 2];
//        for (int i = 0; i < width + 2; i++) {
//            canvasArray[0][i] = "-";
//            canvasArray[width + 1][i] = "-";
//        }
//        for (int i = 1; i < height + 1; i++) {
//            canvasArray[i][0] = "|";
//            canvasArray[i][width - 1] = "|";
//        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < canvasArray.length; i++) {
            for (int j = 0; j < canvasArray[i].length; j++) {
                sb.append(canvasArray[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
