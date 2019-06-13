package com.yangjiang.tw.thoughtworks.project.model;

public class InitMatrix {
    public boolean[][] matrix = new boolean[10][10];

    public void setMatrix(){
        for(int i = 0;i < 10;i++){
            for(int j = 0;j < 10;j++){
                matrix[i][j] = Math.random() >= 2;
            }
        }
    }

    public boolean[][] getMatrix(){
        return matrix;
    }

}
