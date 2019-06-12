package com.yangjiang.tw.thoughtworks.project.display;

import com.yangjiang.tw.thoughtworks.project.model.Box;

public class DisplayMoniter {
    private Box box;

    public DisplayMoniter(Box box) {
        this.box = box;
    }

    public void display() {
        int maxRow = box.getMaxRow();
        int maxCol = box.getMaxCol();
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
    }

    public static void main(String[] args) throws InterruptedException {
        boolean[][] testTab = {{false, false, false}, {true, true, true}, {false, false, false}};
        Box box = new Box();
        box.setMatrix(testTab);
        DisplayMoniter displayMoniter = new DisplayMoniter(box);
        while(true){
            displayMoniter.display();
            box.next();
            Thread.sleep(500);
        }
    }
}
