package arekceg;

import java.util.Arrays;

//https://www.codewars.com/kata/57fa8d4a2c7f926c2200017f/train/java
public class Matrix {
    private double[][] data;
    private int rowCount;
    private int columnCount;

    public Matrix(double[][] elements) {
        validateData(elements);
        this.data = elements;
        this.rowCount = data.length;
        this.columnCount = data[0].length;
    }

    public Matrix(int rows, int cols, double... elements) {
        validateData(elements);
        this.data = createData(rows, cols, elements);
        this.rowCount = rows;
        this.columnCount = cols;
    }

    public Matrix transpose() {
        final double[][] transposedData = new double[data[0].length][data.length];
        for (int i = 0; i < transposedData.length; i++) {
            for (int j = 0; j < transposedData[i].length; j++) {
                transposedData[i][j] = data[j][i];
            }
        }
        return new Matrix(transposedData);
    }

    public Matrix add(Matrix matrixToAdd) {
        if (matrixToAdd.getColumnCount() != this.getColumnCount() ||
            matrixToAdd.getRowCount() != this.getRowCount()) {
            throw new IllegalArgumentException();
        }
        final double[][] dataToAdd = matrixToAdd.toArray();
        final double[][] finalData = new double[this.getRowCount()][this.getColumnCount()];
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data[i].length; j++) {
                finalData[i][j] = this.data[i][j] + dataToAdd[i][j];
            }
        }
        return new Matrix(finalData);
    }

    public Matrix multiply(double factor){
        final double[][] finalData = new double[this.getRowCount()][this.getColumnCount()];
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data[i].length; j++) {
                finalData[i][j] = this.data[i][j] * factor;
            }
        }
        return new Matrix(finalData);
    }

    public Matrix multiply(Matrix secondMatrix) {
        final double[][] finalData = new double[this.getRowCount()][secondMatrix.getColumnCount()];
        for (int i = 0; i < finalData.length; i++) {
            for (int j = 0; j < finalData[i].length; j++) {
                //TODO
            }
        }
        return new Matrix(finalData);
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public double[][] toArray() {
        return Arrays.copyOf(data, data.length);
    }

    private void validateData(double[][] elements) throws IllegalArgumentException {
        if (elements == null || elements.length == 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < elements.length - 1; i++) {
            validateData(elements[i]);
        }
    }

    private void validateData(double[] element) {
        if (element == null || element.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    private double[][] createData(int rows, int cols, double[] elements) {
        final double[][] data = new double[rows][cols];
        int counter = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = elements[counter++];
            }
        }
        return data;
    }

    // TODO: Add transpose, add, mutliply(double), multiply(Matrix)
}
