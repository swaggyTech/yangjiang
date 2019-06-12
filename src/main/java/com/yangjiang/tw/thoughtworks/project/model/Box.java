package com.yangjiang.tw.thoughtworks.project.model;

public class Box {
    public boolean[][] getMatrix() {
        return matrix;
    }

    private boolean[][] matrix;

    public void setMatrix(boolean[][] matrix) {
        this.matrix = matrix;
    }


    public void setTable(boolean[][] table) {
        this.matrix = table;
    }

    public boolean[][] getTable() {
        return matrix;
    }
}
