package com.yangjiang.tw.thoughtworks.project.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class TableTest {

    @Test
    public void shouldNextGenerationBeDead() {
        boolean[][] testTab = {{false,false,false},{false,true,false},{false,false,false}};
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
        boolean[][] testTab = {{false,false,true},{false,false,false},{true,true,false}};
        Table table = new Table();
        table.setTable(testTab);
        boolean result = table.isNextAlive(1,1);
        assertTrue(result);
    }

    @Test
    public void shouldNextGenerationBeSame() {
        boolean[][] testTab = {{false,false,true},{false,true,false},{false,true,false}};
        Table table = new Table();
        table.setTable(testTab);
        boolean result = table.isNextAlive(1,1);
        assertTrue(result);
        boolean[][] testTab2={{false,false,true},{false,false,false},{false,true,false}};
        table.setTable(testTab2);
        boolean result2 = table.isNextAlive(1,1);
        assertFalse(result2);
    }

}