package com.yangjiang.tw.thoughtworks.project.model;

public class Box {
    private static final double ALIVE_THREAD = 0.5;
    private boolean[][] matrix;

    public boolean[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(boolean[][] matrix) {
        this.matrix = matrix;
    }

    public void getRandomMatrix(int maxRow, int maxCol) {
        matrix = new boolean[maxRow][maxCol];
        for(int row = 0;row < maxRow;row++){
            for(int col = 0; col < maxCol;col++){
                if (Math.random() > ALIVE_THREAD)
                    matrix[row][col] = true;
            }
        }
    }
}
