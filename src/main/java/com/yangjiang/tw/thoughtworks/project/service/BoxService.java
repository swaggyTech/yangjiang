package com.yangjiang.tw.thoughtworks.project.service;

public class BoxService {
    public boolean isCellAlive(boolean[][] matrix,int row,int col) {
        return matrix[row][col];
    }

    public boolean[][] next(boolean[][] matrix) {
        int maxRow = getMaxRow(matrix);
        int maxCol = getMaxCol(matrix);
        boolean[][] newMatrix = new boolean[maxRow][maxCol];
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                newMatrix[row][col] = isNextAlive(matrix, row, col);
            }
        }
        return newMatrix;
    }

    public boolean isNextAlive(boolean[][] matrix,int row, int col) {
        int maxRow = getMaxRow(matrix);
        int maxCol = getMaxCol(matrix);
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
        return getNextStatusByAliveNeighbor(matrix,row, col, count);
    }

    public int getMaxCol(boolean [][] matrix) {
        if(matrix!=null){
            return matrix[0].length;
        }
        return 0;
    }

    public int getMaxRow(boolean[][] matrix) {
        if(matrix == null)
            return 0;
        return matrix.length;
    }

    private boolean isLocationValid(int row, int col, int maxRow, int maxCol, int xOffSet, int yOffSet) {
        return row + xOffSet >= 0 && col + yOffSet >= 0 && row + xOffSet < maxRow && col + yOffSet < maxCol;
    }

    private boolean getNextStatusByAliveNeighbor(boolean[][] matrix,int row, int col, int count) {
        if (count == 3) {
            return true;
        } else if (count == 2) {
            return matrix[row][col];
        } else {
            return false;
        }
    }
}
