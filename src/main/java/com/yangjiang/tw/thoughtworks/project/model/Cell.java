package com.yangjiang.tw.thoughtworks.project.model;

public class Cell {
    private boolean alive;
    private int locateX,locateY;

    public Cell(boolean alive, int locateX, int locateY) {
        this.alive = alive;
        this.locateX = locateX;
        this.locateY = locateY;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getLocateX() {
        return locateX;
    }

    public void setLocateX(int locateX) {
        this.locateX = locateX;
    }

    public int getLocateY() {
        return locateY;
    }

    public void setLocateY(int locateY) {
        this.locateY = locateY;
    }
}
