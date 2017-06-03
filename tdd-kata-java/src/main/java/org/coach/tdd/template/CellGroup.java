package org.coach.tdd.template;

/**
 * Created by czfree on 2017/6/3.
 */
public class CellGroup {
    private CellStatus[][] currentCellGroupStatus;
    private CellStatus[][] nextCellGroupStatus;
    private int rows;
    private int colums;
    //细胞状态
    static enum CellStatus {
        Active,
        Dead;
    }

    public CellGroup(int[][] initCell){
        rows = initCell.length;
        colums = initCell[0].length;
        currentCellGroupStatus = new CellStatus[rows][colums];
        nextCellGroupStatus = new CellStatus[rows][colums];

        for(int i = 0 ;i < rows ; i++){
            for(int j = 0 ; j < colums ; j++){
                currentCellGroupStatus[i][j] = (initCell[i][j] == 0 ? CellStatus.Dead : CellStatus.Active);
            }
        }
    }

    public boolean isActive(int x,int y){
        if(!isLegal(x,y))
            throw new ArrayIndexOutOfBoundsException("input x y out of bounds");
        return currentCellGroupStatus[x][y] == CellStatus.Active;
    }

    public boolean isDead(int x, int y){
        if(!isLegal(x,y))
            throw new ArrayIndexOutOfBoundsException("input x y out of bounds");
        return currentCellGroupStatus[x][y] == CellStatus.Dead;
    }

    public int getRows(){
        return rows;
    }

    public int getColums(){
        return  colums;
    }

    private boolean isLegal(int x,int y){
        if(x < 0 || y < 0 || x >= rows || y >= colums)
            return false;
        return true;
    }
}
