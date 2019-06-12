package com.yangjiang.tw.thoughtworks.project.model;

public class Box {
    private boolean[][] matrix;

    public void setMatrix(boolean[][] matrix) {
        this.matrix = matrix;
    }

    public boolean isCellAlive(int row,int col) {
        return matrix[row][col];
    }

    public void next() {
        int maxRow = getMaxRow();
        int maxCol = getMaxCol();
        boolean[][] newMatrix = new boolean[maxRow][maxCol];
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (isNextAlive(row, col)) {
                    newMatrix[row][col] = true;
                } else
                    newMatrix[row][col] = false;
            }
        }
        this.matrix=newMatrix;
    }

    public boolean isNextAlive(int row, int col) {
        int maxRow = getMaxRow();
        int maxCol = getMaxCol();
        int count = 0;
        for (int xOffSet = -1; xOffSet <= 1; xOffSet++) {
            for (int yOffSet = -1; yOffSet <= 1; yOffSet++) {
                if (isLocationValid(row, col, maxRow, maxCol, xOffSet, yOffSet)) {
                    if(xOffSet == 0 && yOffSet == 0){
                        continue;
                    }
                    if (matrix[row + xOffSet][col + yOffSet]) {
                        count++;
                    }
                }
            }
        }
        return getNextStatusByAliveNeighbor(row, col, count);
    }

    public int getMaxCol() {
        return matrix.length;
    }

    public int getMaxRow() {
        return matrix[0].length;
    }

    private boolean isLocationValid(int row, int col, int maxRow, int maxCol, int xOffSet, int yOffSet) {
        return row + xOffSet >= 0 && col + yOffSet >= 0 && row + xOffSet < maxRow && col + yOffSet < maxCol;
    }

    private boolean getNextStatusByAliveNeighbor(int row, int col, int count) {
        if (count == 3) {
            return true;
        } else if (count == 2) {
            return matrix[row][col];
        } else {
            return false;
        }
    }

    public void setTable(boolean[][] table) {
        this.matrix = table;
    }

    public boolean[][] getTable() {
        return matrix;
    }
}
