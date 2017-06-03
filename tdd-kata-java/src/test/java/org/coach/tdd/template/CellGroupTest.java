package org.coach.tdd.template;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CellGroupTest {
    private CellGroup cellGroupOne;

    @Before
    public void initCellGroup(){
        int[][] initCellOne = {
                {1,1,0,1,0},
                {0,0,1,0,1},
                {1,1,1,1,1},
                {0,0,0,0,0}
        };
        cellGroupOne = new CellGroup(initCellOne);

    }

    @Test
    public void cellGroupInstantiationShouldLegalWithTwoDimensionalArray(){
        assertEquals(cellGroupOne.getColums(),5);
        assertEquals(cellGroupOne.getRows(),4);
        assertTrue(cellGroupOne.isActive(1,2));
        assertTrue(cellGroupOne.isDead(3,4));
        assertFalse(cellGroupOne.isActive(0,2));
        assertFalse(cellGroupOne.isDead(0,0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalInputArrayShouldThrowException(){
        int[][] initCellIllegal = {
            {1,1,0,1,0},
            {0,0,0,1},
            {1,1,1,1,1,0},
            {0,0,0,0,0}
        };
        CellGroup cellGroupIllegal = new CellGroup(initCellIllegal);

    }
}