package com.yangjiang.tw.thoughtworks.project.model;

public class Table {
    private boolean[][] table;

    public int[][] next(int[][] table) {
        int maxRow = table[0].length;
        int maxCol = table.length;
        int[][] newTable = new int[maxRow][maxCol];
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (isNextAlive(row, col)) {
                    newTable[row][col] = 1;
                } else
                    newTable[row][col] = 0;
            }
        }
        return newTable;
    }

    public boolean isNextAlive(int row, int col) {
        int maxRow = table[0].length;
        int maxCol = table.length;
        int count = 0;
        for (int xOffSet = -1; xOffSet <= 1; xOffSet++) {
            for (int yOffSet = -1; yOffSet <= 1; yOffSet++) {
                if (isLocationValid(row, col, maxRow, maxCol, xOffSet, yOffSet)) {
                    if (table[row + xOffSet][col + yOffSet]) {
                        count++;
                    }
                }
            }
        }
        return getNextStatusByAliveNeighbor(row, col, count);
    }

    private boolean isLocationValid(int row, int col, int maxRow, int maxCol, int xOffSet, int yOffSet) {
        return row + xOffSet >= 0 && col + yOffSet >= 0 && row + xOffSet < maxRow && col + yOffSet < maxCol;
    }

    private boolean getNextStatusByAliveNeighbor(int row, int col, int count) {
        if (count == 3) {
            return true;
        } else if (count == 2) {
            return table[row][col];
        } else {
            return false;
        }
    }

    public void setTable(boolean[][] table) {
        this.table = table;
    }
}
