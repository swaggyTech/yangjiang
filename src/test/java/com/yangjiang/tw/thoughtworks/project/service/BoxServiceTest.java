package com.yangjiang.tw.thoughtworks.project.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoxServiceTest {
    private BoxService boxService = new BoxService();
    
    @Test
    public void shouldNextGenerationBeDead() {
        boolean[][] testTab = {{false,false,false},{true,true,true},{false,false,false}};
        assertTrue(boxService.isNextAlive(testTab,1,1));
        assertTrue(boxService.isNextAlive(testTab,0,1));
        assertTrue(boxService.isNextAlive(testTab,2,1));
        assertFalse(boxService.isNextAlive(testTab,1,0));
        assertFalse(boxService.isNextAlive(testTab,1,2));
    }

    @Test
    public void shouldNextGenerationBeAlive() {
        boolean[][] testTab = {{false,false,true},{false,false,false},{true,true,false}};
        boolean result = boxService.isNextAlive(testTab,1,1);
        assertTrue(result);
    }

    @Test
    public void shouldNextGenerationBeSame() {
        boolean[][] testTab = {{false,false,true},{false,true,false},{false,true,false}};
        boolean result = boxService.isNextAlive(testTab,1,1);
        assertTrue(result);
        boolean result2 = boxService.isNextAlive(testTab,1,1);
        assertTrue(result2);
    }

    @Test
    public void shouldRowBeOne() {
        boolean[][] testTab = {{false,false,true},{false,true,false}};
        int row = boxService.getMaxRow(testTab);
        assertEquals(2,row);
        int col = boxService.getMaxCol(testTab);
        assertEquals(3,col);
    }

    @Test
    public void shouldGenerateNextMatrix() {
        boolean[][] testTab = {{true,true,true}};
        boolean[][] result=boxService.next(testTab);
        boolean[][] expect= {{false,true,false}};
        //[[true,true,true]]
        assertArrayEquals(expect,result);
    }

    @Test
    public void shouldCellAlice() {
        boolean[][] testTab = {{true,true,true}};
        assertTrue(boxService.isCellAlive(testTab,0,1));
    }

    @Test
    public void shouldMatrixLengthEqualsZero() {
        assertEquals(0,boxService.getMaxRow(null));
        assertEquals(0,boxService.getMaxCol(null));
    }
}