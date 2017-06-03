package org.coach.tdd.template;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by czfree on 2017/6/3.
 */
public class GameServiceTest {
    private GameService gameService;
    @Before
    public void initCellGroup() {
        CellArray cellArray = new CellArray(10, 10);
        cellArray.setCellStatus(0, 0, CellStatus.Active);
        cellArray.setCellStatus(0, 1, CellStatus.Active);
        cellArray.setCellStatus(0, 2, CellStatus.Active);
        cellArray.setCellStatus(1, 0, CellStatus.Active);
        cellArray.setCellStatus(1, 1, CellStatus.Active);
        cellArray.setCellStatus(2, 2, CellStatus.Active);
        gameService = new GameService(cellArray);
    }

    @Test
    public void calculateActiveNeighborShouldCorrect() {
        assertEquals(gameService.calculateActiveNeighbor(1, 1),  4);
        assertEquals(gameService.calculateActiveNeighbor(5, 5),  0);
        assertEquals(gameService.calculateActiveNeighbor(0, 0),  3);
    }

    @Test
    public void updateCellArrayShouldCorrect() {
        gameService.updateCellArray();
        assertEquals(gameService.getCells().getCellStatus(0, 0), CellStatus.Active);
        assertEquals(gameService.getCells().getCellStatus(0, 2), CellStatus.Active);
        assertEquals(gameService.getCells().getCellStatus(1, 1), CellStatus.DEAD);
        assertEquals(gameService.getCells().getCellStatus(2, 2), CellStatus.DEAD);
    }
}
