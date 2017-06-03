package org.coach.tdd.template;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class CellArrayTest {
    private CellArray cellArray;

    @Before
    public void initCellGroup() {
        cellArray = new CellArray(10, 10);
    }

    @Test
    public void setStatueAndGetStatueShouldCorrect() {
        assertEquals(cellArray.getCellStatus(2, 2), CellStatus.DEAD);
        cellArray.setCellStatus(2, 2, CellStatus.Active);
        assertEquals(cellArray.getCellStatus(2, 2), CellStatus.Active);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getCellStatueArgumentOutOfBoundsShouldThrowExpection() {
        cellArray.getCellStatus(11, 11);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void setCellStatueArgumentOutOfBoundsShouldThrowExpection() {
        cellArray.setCellStatus(11, 11, CellStatus.Active);
    }
}
