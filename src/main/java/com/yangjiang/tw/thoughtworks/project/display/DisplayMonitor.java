package com.yangjiang.tw.thoughtworks.project.display;

import com.yangjiang.tw.thoughtworks.project.model.Box;
import com.yangjiang.tw.thoughtworks.project.service.BoxService;

public class DisplayMonitor {
    private Box box;
    private int speed = 500;
    private BoxService boxService = new BoxService();

    public DisplayMonitor(Box box) {
        this.box = box;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

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
}
