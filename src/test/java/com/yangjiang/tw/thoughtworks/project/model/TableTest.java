package com.yangjiang.tw.thoughtworks.project.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class TableTest {

    @Test
    public void shouldNextGenerationBeDead() {
        int[][] testTab = {{0,0,0},{0,1,0},{0,0,0}};
        Table table = new Table();
        table.setTable(testTab);
        boolean result = table.isNextAlive(1,1);
        assertFalse(result);
        boolean result2 = table.isNextAlive(0,0);
        assertFalse(result2);
        boolean result3 = table.isNextAlive(2,2);
        assertFalse(result3);
    }

    @Test
    public void shouldNextGenerationBeAlive() {
        int[][] testTab = {{0,0,1},{0,0,0},{1,1,0}};
        Table table = new Table();
        table.setTable(testTab);
        boolean result = table.isNextAlive(1,1);
        assertTrue(result);
    }

    @Test
    public void shouldNextGenerationBeSame() {
        int[][] testTab = {{0,0,1},{0,1,0},{0,1,0}};
        Table table = new Table();
        table.setTable(testTab);
        boolean result = table.isNextAlive(1,1);
        assertTrue(result);
        int[][] testTab2={{0,0,1},{0,0,0},{0,1,0}};
        table.setTable(testTab2);
        boolean result2 = table.isNextAlive(1,1);
        assertFalse(result2);
    }

}