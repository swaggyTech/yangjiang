package com.yangjiang.tw.thoughtworks.project.display;

import com.yangjiang.tw.thoughtworks.project.model.Box;

public class DisplayMonitor {
    private Box box;
    private int speed = 500;

    public DisplayMonitor(Box box) {
        this.box = box;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void display() throws InterruptedException {
        int maxRow = box.getMaxRow();
        int maxCol = box.getMaxCol();
        while (true) {
            for (int row = 0; row < maxRow; row++) {
                for (int col = 0; col < maxCol; col++) {
                    if (box.isCellAlive(row, col)) {
                        System.out.print("♦");
                    } else {
                        System.out.print("♢");
                    }
                }
                System.out.println();
            }
            System.out.println();
            box.next();
            Thread.sleep(speed);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        boolean[][] testTab = {{false, false, false}, {true, true, true}, {false, false, false}};
        Box box = new Box();
        box.setMatrix(testTab);
        DisplayMonitor displayMonitor = new DisplayMonitor(box);
        displayMonitor.display();
    }
}
