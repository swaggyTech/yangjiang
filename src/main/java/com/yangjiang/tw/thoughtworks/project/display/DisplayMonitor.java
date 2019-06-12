package com.yangjiang.tw.thoughtworks.project.display;

import com.yangjiang.tw.thoughtworks.project.model.Box;
import com.yangjiang.tw.thoughtworks.project.service.BoxService;

import java.util.Scanner;

public class DisplayMonitor {
    private Box box;
    private int speed = 500;

    public DisplayMonitor(Box box) {
        this.box = box;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    BoxService boxService = new BoxService();

    public void display() throws InterruptedException {
        int maxRow = boxService.getMaxRow(box.getMatrix());
        int maxCol = boxService.getMaxCol(box.getMatrix());
        while (true) {
            for (int row = 0; row < maxRow; row++) {
                for (int col = 0; col < maxCol; col++) {
                    if (boxService.isCellAlive(box.getMatrix(),row, col)) {
                        System.out.print("♦");
                    } else {
                        System.out.print("♢");
                    }
                }
                System.out.println();
            }
            System.out.println();
            box.setMatrix(boxService.next(box.getMatrix()));
            Thread.sleep(speed);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("设置速度");
        int speed = sc.nextInt();
        System.out.println("输入矩阵row轴");
        int maxRow = sc.nextInt();
        System.out.println("输入矩阵col轴");
        int maxCol = sc.nextInt();
        boolean[][] initMatrix = new boolean[maxRow][maxCol];
        System.out.println("设置活细胞，输入坐标,输入 0 0 结束");
        while(sc.hasNextLine()){
            int row = sc.nextInt();
            int col = sc.nextInt();
            if(row == -1 || col == -1)
                break;
            if(row < 0 || col < 0 || row >= maxRow || col >= maxCol)
                System.out.println("输入非法");
            else
                initMatrix[row][col] = true;
        }

        /*
        for(int i = 0;i < maxX;i++){
            for(int j = 0;j < maxY;j++){
                if(sc.nextInt() == 1)
                    initMatrix[i][j] = true;
                else
                    initMatrix[i][j] = false;
            }
        }*/

        boolean[][] testTab = {{false, false, false}, {true, true, true}, {false, false, false}};
        Box box = new Box();
        box.setMatrix(initMatrix);
        DisplayMonitor displayMonitor = new DisplayMonitor(box);
        displayMonitor.setSpeed(speed);
        displayMonitor.display();
    }
}
