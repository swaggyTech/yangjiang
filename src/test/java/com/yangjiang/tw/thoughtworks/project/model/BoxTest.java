package com.yangjiang.tw.thoughtworks.project.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoxTest {

    @Test
    public void shouldNextGenerationBeDead() {
        boolean[][] testTab = {{false,false,false},{true,true,true},{false,false,false}};
        Box box = new Box();
        box.setTable(testTab);
        assertTrue(box.isNextAlive(1,1));
        assertTrue(box.isNextAlive(0,1));
        assertTrue(box.isNextAlive(2,1));
        assertFalse(box.isNextAlive(1,0));
        assertFalse(box.isNextAlive(1,2));
    }

    @Test
    public void shouldNextGenerationBeAlive() {
        boolean[][] testTab = {{false,false,true},{false,false,false},{true,true,false}};
        Box box = new Box();
        box.setTable(testTab);
        boolean result = box.isNextAlive(1,1);
        assertTrue(result);
    }

    @Test
    public void shouldNextGenerationBeSame() {
        boolean[][] testTab = {{false,false,true},{false,true,false},{false,true,false}};
        Box box = new Box();
        box.setTable(testTab);
        boolean result = box.isNextAlive(1,1);
        assertTrue(result);
        boolean[][] testTab2={{false,false,true},{false,false,false},{false,true,false}};
        box.setTable(testTab2);
        boolean result2 = box.isNextAlive(1,1);
        assertFalse(result2);
    }

}