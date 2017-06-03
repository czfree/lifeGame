package org.coach.tdd.template;

public class CellGroup {
    private CellStatus[][] currentCellGroupStatus;
    private CellStatus[][] nextCellGroupStatus;
    private int rows;
    private int colums;
    static enum CellStatus {
        Active,
        Dead;
    }

    public CellGroup(int[][] initCell) {
        rows = initCell.length;
        colums = initCell[0].length;
        for (int i = 1 ; i < rows ; i++) {
            if (initCell[i].length != colums) {
                throw new IllegalArgumentException("argument illegal");
            }
        }
        currentCellGroupStatus = new CellStatus[rows][colums];
        nextCellGroupStatus = new CellStatus[rows][colums];
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < colums ; j++) {
                currentCellGroupStatus[i][j] = (initCell[i][j] == 0 ? CellStatus.Dead : CellStatus.Active);
            }
        }
    }

    public int calculateAroundCellNum(int x, int y) {
        if (!isLegal(x, y)) {
            throw new ArrayIndexOutOfBoundsException("input x y out of bounds");
        }
        int aroundCellNum = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (isLegal(i, j)) {
                    aroundCellNum += isActive(i, j) ? 1 : 0;
                }
            }
        }
        aroundCellNum -= isActive(x, y) ?  1 : 0;
        return aroundCellNum;
    }

    public CellStatus nextCellStatus(int x, int y) {
        CellStatus cellStatusRet;
        if (!isLegal(x, y)) {
            throw new ArrayIndexOutOfBoundsException("input x y out of bounds");
        }
        switch (calculateAroundCellNum(x, y)) {
            case 3 :
                cellStatusRet = CellStatus.Active;
                break;
            case 2 :
                cellStatusRet = isActive(x, y) ? CellStatus.Active : CellStatus.Dead;
                break;
            default:
                cellStatusRet = CellStatus.Dead;
        }
        return cellStatusRet;
    }

    public void updateCellGroupStatus() {
        nextCellGroupStatus = new CellStatus[rows][colums];
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < colums ; j++) {
                nextCellGroupStatus[i][j] = nextCellStatus(i, j);
            }
        }
        currentCellGroupStatus = nextCellGroupStatus;
    }

    public boolean isActive(int x, int y) {
        if (!isLegal(x, y)) {
            throw new ArrayIndexOutOfBoundsException("input x y out of bounds");
        }
        return currentCellGroupStatus[x][y] == CellStatus.Active;
    }

    public boolean isDead(int x, int y) {
        if (!isLegal(x, y)) {
            throw new ArrayIndexOutOfBoundsException("input x y out of bounds");
        }
        return currentCellGroupStatus[x][y] == CellStatus.Dead;
    }

    public int getRows() {
        return rows;
    }

    public int getColums() {
        return  colums;
    }

    private boolean isLegal(int x, int y) {
        if (x < 0 || y < 0 || x >= rows || y >= colums) {
            return false;
        }
        return true;
    }
}
