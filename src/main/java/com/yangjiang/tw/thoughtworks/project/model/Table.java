package com.yangjiang.tw.thoughtworks.project.model;

public class Table {
    private int[][] table;

    public int[][] next(int[][] table){
        int maxRow = table[0].length;
        int maxCol = table.length;
        int[][] newTable = new int[maxRow][maxCol];
        for(int row = 0;row <maxRow ;row++){
            for(int col = 0;col < maxCol;col ++){
                if(isNextAlive(row,col)){
                    newTable[row][col] = 1;
                }else
                    newTable[row][col] = 0;
            }
        }
        return newTable;
    }

    public boolean isNextAlive(int row, int col){
        int maxRow = table[0].length;
        int maxCol = table.length;
        int count=0;
        for(int xOffSet = -1;xOffSet<=1;xOffSet++){
            for(int yOffSet = -1; yOffSet<=1;yOffSet++){
                if(row+xOffSet>=0&&col+yOffSet>=0&&row+xOffSet<maxRow&&col+yOffSet<maxCol)
                {
                    if(table[row+xOffSet][col+yOffSet]==1){
                        count++;
                    }
                }
            }
        }
        if(count==3){
            return true;
        }else if(count==2){
            return table[row][col] == 1;
        }else {
            return false;
        }
    }

    public void setTable(int[][] table) {
        this.table = table;
    }
}
