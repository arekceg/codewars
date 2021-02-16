package arekceg;

//https://www.codewars.com/kata/57fa8d4a2c7f926c2200017f/train/java
public class Matrix {
    private final double[][] data;

    public Matrix(double[][] elements) {
        validateData(elements);
        this.data = deepCopyArray(elements);
    }

    public Matrix(int rows, int cols, double... elements) {
        validateData(elements);
        this.data = createData(rows, cols, elements);
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

    public Matrix multiply(double factor) {
        final double[][] finalData = new double[this.getRowCount()][this.getColumnCount()];
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data[i].length; j++) {
                finalData[i][j] = this.data[i][j] * factor;
            }
        }
        return new Matrix(finalData);
    }

    public Matrix multiply(Matrix secondMatrix) {
        if (this.getColumnCount() != secondMatrix.getRowCount()) {
            throw new IllegalArgumentException();
        }
        final double[][] finalData = new double[this.getRowCount()][secondMatrix.getColumnCount()];
        final double[][] firstMatrixData = this.toArray();
        final double[][] secondMatrixData = secondMatrix.toArray();
        for (int i = 0; i < this.getRowCount(); i++) {
            for (int j = 0; j < secondMatrix.getColumnCount(); j++) {
                int k = 0;
                double calculatedValue = 0;
                while (k < secondMatrixData.length) {
                    calculatedValue += (firstMatrixData[i][k] * secondMatrixData[k][j]);
                    k++;
                }
                finalData[i][j] = calculatedValue;
            }
        }
        return new Matrix(finalData);
    }

    public int getRowCount() {
        return this.toArray().length;
    }

    public int getColumnCount() {
        return this.toArray()[0].length;
    }

    public double[][] toArray() {
        return deepCopyArray(data);
    }

    private void validateData(double[][] elements) throws IllegalArgumentException {
        if (elements == null || elements.length == 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < elements.length; i++) {
            validateData(elements[i]);
        }
    }

    private void validateData(double[] elements) {
        if (elements == null || elements.length == 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < elements.length; i++) {
            validateData(elements[i]);
        }
    }

    private void validateData(double v) {
        if (Double.isNaN(v)) throw new IllegalArgumentException();
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

    private double[][] deepCopyArray(double[][] source) {
        double[][] copy = new double[source.length][];
        for (int i = 0; i < copy.length; ++i) {
            copy[i] = new double[source[i].length];
            System.arraycopy(source[i], 0, copy[i], 0, copy[i].length);
        }
        return copy;
    }
}
