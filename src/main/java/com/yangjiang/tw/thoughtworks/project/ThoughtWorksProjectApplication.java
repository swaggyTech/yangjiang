package com.yangjiang.tw.thoughtworks.project;

import com.yangjiang.tw.thoughtworks.project.display.WindowsDisplay;
import com.yangjiang.tw.thoughtworks.project.model.Box;

import java.util.Scanner;

public class ThoughtWorksProjectApplication {
	private static final int MAX_ROW = 180;
	private static final int MAX_COL = 180;

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("是否随机生成？[0/1]");
		int isRandom = sc.nextInt();
		System.out.println("设置速度");
		int speed = sc.nextInt();
		System.out.println("输入矩阵row轴");
		int maxRow = sc.nextInt();
		System.out.println("输入矩阵col轴");
		int maxCol = sc.nextInt();

		if (isInvalidSize(maxRow, maxCol)) {
			return;
		}

		boolean[][] initMatrix = new boolean[maxRow][maxCol];
		Box box = new Box();

		if(isRandom == 0){
			System.out.println("设置活细胞，输入坐标,输入 0 0 结束");
			while(sc.hasNextLine()){
				int row = sc.nextInt();
				int col = sc.nextInt();
				if (isInputValid(maxRow, maxCol, initMatrix, row, col)) break;
			}
			box.setMatrix(initMatrix);
		}else{
			box.getRandomMatrix(maxRow,maxCol);
		}

		show(speed, box);
	}

	private static boolean isInvalidSize(int maxRow, int maxCol) {
		if (maxRow > MAX_ROW || maxCol > MAX_COL) {
			System.out.println("数值过大，细胞挤死完了！！！发现彩蛋，发个红包");
			return true;
		}
		return false;
	}

	private static void show(int speed, Box box) throws InterruptedException {
		WindowsDisplay windowsDisplay = new WindowsDisplay(box,speed);
		windowsDisplay.init();
		while(true) {
			windowsDisplay.display();
		}
	}

	private static boolean isInputValid(int maxRow, int maxCol, boolean[][] initMatrix, int row, int col) {
		if(row == -1 || col == -1)
			return true;
		if(row < 0 || col < 0 || row >= maxRow || col >= maxCol)
			System.out.println("输入非法");
		else
			initMatrix[row][col] = true;
		return false;
	}
}
