package org.coach.tdd.template;

/**
 * Created by czfree on 2017/6/3.
 */
public class CellArray {
    private CellStatus[][] cells;
    private int rows;
    private int colums;

    public CellArray(int rows, int colums) {
        this.rows = rows;
        this.colums = colums;
        cells = new CellStatus[rows][colums];
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < colums ; j++) {
                cells[i][j] = CellStatus.DEAD;
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColums() {
        return colums;
    }

    public CellStatus getCellStatus(int x, int y) {
        if (!isCoordinateLegal(x, y)) {
            throw new ArrayIndexOutOfBoundsException("input x y out of bounds");
        }
        return cells[x][y];
    }

    public void setCellStatus(int x, int y, CellStatus s) {
        if (!isCoordinateLegal(x, y)) {
            throw new ArrayIndexOutOfBoundsException("input x y out of bounds");
        }
        cells[x][y] = s;
    }

    private boolean isCoordinateLegal(int x, int y) {
        if (x < 0 || y < 0 || x >= rows || y >= colums) {
            return false;
        }
        return true;
    }
}
