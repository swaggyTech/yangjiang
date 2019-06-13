package com.yangjiang.tw.thoughtworks.project.display;

import com.yangjiang.tw.thoughtworks.project.model.Box;
import com.yangjiang.tw.thoughtworks.project.service.BoxService;

import javax.swing.*;
import java.awt.*;

public class WindowsDisplay extends JFrame {
    private static final int MAX_WINDOW_WIDTH = 1000;
    private static final int MAX_WINDOW_HEIGHT = 1000;
    private static final int WINDOW_LOCATION_X = 100;
    private static final int WINDOW_LOCATION_Y = 100;
    private BoxService boxService= new BoxService();
    private int speed;
    private Box box;
    private JTextField[][] textFields;

    public WindowsDisplay(Box box,int speed){
        this.box =box;
        this.speed = speed;
        setBounds(WINDOW_LOCATION_X, WINDOW_LOCATION_Y, MAX_WINDOW_WIDTH, MAX_WINDOW_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public void init(){
        int maxRow = boxService.getMaxRow(box.getMatrix());
        int maxCol = boxService.getMaxCol(box.getMatrix());
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(maxRow  ,maxCol));
        textFields = new JTextField[maxRow][maxCol];

        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                JTextField text = new JTextField();
                if (box.getMatrix()[row][col]) {
                    text.setBackground(Color.BLACK);
                }
                textFields[row][col] = text;
                gridPanel.add(text);
            }
        }
        add("Center", gridPanel);
        setVisible(true);
    }

    public void display() throws InterruptedException {
        int maxRow = boxService.getMaxRow(box.getMatrix());
        int maxCol = boxService.getMaxCol(box.getMatrix());
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (boxService.isCellAlive(box.getMatrix(), row, col)) {
                    textFields[row][col].setBackground(Color.DARK_GRAY);
                } else {
                    textFields[row][col].setBackground(Color.white);
                }
            }
        }
        box.setMatrix(boxService.next(box.getMatrix()));
        Thread.sleep(speed);
    }
}