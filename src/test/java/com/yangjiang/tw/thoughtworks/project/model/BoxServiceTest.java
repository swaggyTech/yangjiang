package com.yangjiang.tw.thoughtworks.project.model;

import com.yangjiang.tw.thoughtworks.project.service.BoxService;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoxServiceTest {

    @Test
    public void shouldNextGenerationBeDead() {
        boolean[][] testTab = {{false,false,false},{true,true,true},{false,false,false}};
        BoxService boxService = new BoxService();
        assertTrue(boxService.isNextAlive(testTab,1,1));
        assertTrue(boxService.isNextAlive(testTab,0,1));
        assertTrue(boxService.isNextAlive(testTab,2,1));
        assertFalse(boxService.isNextAlive(testTab,1,0));
        assertFalse(boxService.isNextAlive(testTab,1,2));
    }

    @Test
    public void shouldNextGenerationBeAlive() {
        boolean[][] testTab = {{false,false,true},{false,false,false},{true,true,false}};
        BoxService box = new BoxService();
        boolean result = box.isNextAlive(testTab,1,1);
        assertTrue(result);
    }

    @Test
    public void shouldNextGenerationBeSame() {
        boolean[][] testTab = {{false,false,true},{false,true,false},{false,true,false}};
        BoxService box = new BoxService();
        boolean result = box.isNextAlive(testTab,1,1);
        assertTrue(result);
        boolean result2 = box.isNextAlive(testTab,1,1);
        assertTrue(result2);
    }

}