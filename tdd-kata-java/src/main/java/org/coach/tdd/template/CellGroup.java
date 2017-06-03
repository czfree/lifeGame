package org.coach.tdd.template;

public class CellGroup {
    private CellStatus[][] currentCellGroupStatus;
    private CellStatus[][] nextCellGroupStatus;
    private int rows;
    private int colums;
    //细胞状态,枚举类
    static enum CellStatus {
        Active,
        Dead;
    }
    /*
     * @param initCell 用于初始化的该类的二维数组，为0表示初始死亡，非0表示存活，数组不合法抛异常
     */
    public CellGroup(int[][] initCell){
        rows = initCell.length;
        colums = initCell[0].length;
        for(int i = 1 ; i < rows ; i++){
            if(initCell[i].length != colums)
                throw new IllegalArgumentException("argument illegal");
        }
        currentCellGroupStatus = new CellStatus[rows][colums];
        nextCellGroupStatus = new CellStatus[rows][colums];

        for(int i = 0 ;i < rows ; i++){
            for(int j = 0 ; j < colums ; j++){
                currentCellGroupStatus[i][j] = (initCell[i][j] == 0 ? CellStatus.Dead : CellStatus.Active);
            }
        }
    }
    /*
     * 计算细胞周围存活细胞的数量
     * @param x,y 指定细胞的坐标
     * @return 指定细胞周围存活细胞的数量
     */
    public int calculateAroundCellNum(int x,int y){
        if(!isLegal(x,y)) throw new ArrayIndexOutOfBoundsException("input x y out of bounds");
        int aroundCellNum = 0;
        for(int i = x - 1 ; i <= x + 1 ;i++){
            for(int j = y - 1 ; j <= y + 1; j++){
                if(isLegal(i,j)){
                    if(i==x && j == y) continue;
                    aroundCellNum += isActive(i,j) ? 1 : 0;
                }
            }
        }
        return aroundCellNum;
    }
    /*
         * 计算当前指定细胞的下一个状态
         * @param x,y 当前指定细胞的坐标
         * @return 当前指定细胞的下一个状态
         */
    public CellStatus nextCellStatus(int x,int y){
        if(!isLegal(x,y)) throw new ArrayIndexOutOfBoundsException("input x y out of bounds");
        switch (calculateAroundCellNum(x,y)){
            case 3:
                return CellStatus.Active;
            case 2:
                return isActive(x,y) ? CellStatus.Active:CellStatus.Dead;
        }
        return CellStatus.Dead;
    }
    /*
        * 更新所有细胞的当前状态
     */
    public void updateCellGroupStatus(){
        nextCellGroupStatus = new CellStatus[rows][colums];
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < colums ; j++){
                nextCellGroupStatus[i][j] = nextCellStatus(i,j);
            }
        }
        currentCellGroupStatus = nextCellGroupStatus;
    }
    /*
        * 判断当前指定细胞的状态
        * @param x，y  当前指定细胞的坐标
        * @return 当前指定细胞的状态
     */
    public boolean isActive(int x,int y){
        if(!isLegal(x,y)) throw new ArrayIndexOutOfBoundsException("input x y out of bounds");
        return currentCellGroupStatus[x][y] == CellStatus.Active;
    }

    public boolean isDead(int x, int y){
        if(!isLegal(x,y)) throw new ArrayIndexOutOfBoundsException("input x y out of bounds");
        return currentCellGroupStatus[x][y] == CellStatus.Dead;
    }

    public int getRows(){
        return rows;
    }

    public int getColums(){
        return  colums;
    }
    /*
      * 判断单个细胞的坐标范围是否合法
      * @return ture 合法，false 不合法
     */
    private boolean isLegal(int x,int y){
        if(x < 0 || y < 0 || x >= rows || y >= colums)
            return false;
        return true;
    }
}
