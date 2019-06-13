package com.yangjiang.tw.thoughtworks.project.model;

public class Box {
    private boolean[][] matrix;

    public boolean[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(boolean[][] matrix) {
        this.matrix = matrix;
    }

    public boolean[][] getRandomMatrix(int maxRow,int maxCol){
        matrix = new boolean[maxRow][maxCol];
        for(int row = 0;row < maxRow;row++){
            for(int col = 0; col < maxCol;col++){
                if( Math.random() > 0.5)
                    matrix[row][col] = true;
            }
        }
        return matrix;
    }
}
