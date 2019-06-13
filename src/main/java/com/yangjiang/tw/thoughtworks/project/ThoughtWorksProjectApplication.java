package com.yangjiang.tw.thoughtworks.project;

import com.yangjiang.tw.thoughtworks.project.display.DisplayMonitor;
import com.yangjiang.tw.thoughtworks.project.display.WindowsDisplay;
import com.yangjiang.tw.thoughtworks.project.model.Box;

import java.util.Scanner;

public class ThoughtWorksProjectApplication {
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
		Box box = new Box();
		box.setMatrix(initMatrix);
		/*DisplayMonitor displayMonitor = new DisplayMonitor(box);
		displayMonitor.setSpeed(speed);
		displayMonitor.display();*/
		WindowsDisplay windowsDisplay = new WindowsDisplay(box,500);
		windowsDisplay.init();
		while(true) {
			windowsDisplay.display();
		}
	}
}
