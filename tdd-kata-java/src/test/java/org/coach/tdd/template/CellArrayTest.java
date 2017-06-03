package org.coach.tdd.template;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CellArrayTest {
    private CellArray cellArray;

    @Before
    public void initCellGroup() {
        cellArray = new CellArray(9, 10);
    }

    @Test
    public void getRowsAndColumsShouldCorrect() {
        assertEquals(cellArray.getRows(), 9);
        assertEquals(cellArray.getColums(), 10);
    }

    @Test
    public void setStatueAndGetStatueShouldCorrect() {
        assertEquals(cellArray.getCellStatus(2, 2), CellStatus.DEAD);
        cellArray.setCellStatus(2, 2, CellStatus.Active);
        assertEquals(cellArray.getCellStatus(2, 2), CellStatus.Active);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getCellStatueArgumentOutOfBoundsShouldThrowExpectionOne() {
        cellArray.getCellStatus(11, 5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getCellStatueArgumentOutOfBoundsShouldThrowExpectionTwo() {
        cellArray.getCellStatus(-1, 5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void setCellStatueArgumentOutOfBoundsShouldThrowExpectionOne() {
        cellArray.setCellStatus(5, 11, CellStatus.Active);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void setCellStatueArgumentOutOfBoundsShouldThrowExpectionTwo() {
        cellArray.setCellStatus(5, -1, CellStatus.Active);
    }
}
