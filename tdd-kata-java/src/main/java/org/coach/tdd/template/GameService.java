package org.coach.tdd.template;

import java.util.Random;

public class GameService {
    private CellArray cells;

    GameService(int x, int y) {
        cells = new CellArray(x , y);
    }

    GameService(CellArray cells) {
        this.cells = cells;
    }

    public void randInitCellArray() {
        Random r = new Random();
        for (int i = 0 ; i < cells.getRows() ; i++) {
            for (int j = 0 ; j < cells.getColums() ; j++) {
                int val = r.nextInt(2);
                if (val == 1) {
                    cells.setCellStatus(i, j, CellStatus.Active);
                } else {
                    cells.setCellStatus(i, j, CellStatus.DEAD);
                }
            }
        }
    }

    public int calculateActiveNeighbor(int x , int y) {
        int count = 0;
        int lx = Math.max (x - 1 , 0);
        int rx = Math.min (x + 1 , cells.getRows() - 1);
        int ly = Math.max (y - 1 , 0);
        int ry = Math.min (y + 1 , cells.getColums() - 1);
        for (int i = lx ; i <= rx ; i++) {
            for (int j = ly ; j <= ry ; j++) {
                count += cells.getCellStatus(i, j) == CellStatus.Active ? 1 : 0;
            }
        }
        count -= cells.getCellStatus(x, y) == CellStatus.Active ? 1 : 0;
        return count;
    }

    public void updateCellArray() {
        CellArray nextCellArray = new CellArray(cells.getRows(), cells.getColums());
        for (int i = 0 ; i < cells.getRows() ; i++) {
            for (int j = 0 ; j < cells.getColums() ; j++) {
                switch (calculateActiveNeighbor(i, j)) {
                    case 3 :
                        nextCellArray.setCellStatus(i, j, CellStatus.Active);
                        break;
                    case 2 :
                        if (cells.getCellStatus(i, j) == CellStatus.Active) {
                            nextCellArray.setCellStatus(i, j, CellStatus.Active);
                        }
                        break;
                    default:
                }
            }
        }
        cells = nextCellArray;
    }

    public CellArray getCells() {
        return cells;
    }

    public void setCells(CellArray cells) {
        this.cells = cells;
    }
}
