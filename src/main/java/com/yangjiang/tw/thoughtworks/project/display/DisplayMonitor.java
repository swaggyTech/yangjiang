package com.yangjiang.tw.thoughtworks.project.display;

import com.yangjiang.tw.thoughtworks.project.model.Box;
import com.yangjiang.tw.thoughtworks.project.service.BoxService;

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
        boolean[][] testTab = {{false, false, false}, {true, true, true}, {false, false, false}};
        Box box = new Box();
        box.setMatrix(testTab);
        DisplayMonitor displayMonitor = new DisplayMonitor(box);
        displayMonitor.display();
    }
}
