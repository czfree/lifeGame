package org.coach.tdd.template;

public class GameService {
    private CellArray cells;

    GameService(int x, int y) {
        cells = new CellArray(x ,y);
    }

    GameService(CellArray cells) {
        this.cells = cells;
    }


    public int calculateActiveNeighbor(int x ,int y) {
        int count = 0;
        for (int i = x - 1 ; i <= x + 1 ; i++) {
            for (int j = y - 1 ; j <= y + 1 ; j++) {
                if(i < 0 || j < 0 || i >= cells.getRows() || j >= cells.getColums()) {
                    continue;
                }
                count += cells.getCellStatus(i, j) == CellStatus.Active ? 1 : 0;
            }
        }
        count -= cells.getCellStatus(x, y) == CellStatus.Active ? 1 : 0;
        return count;
    }

    public void updateCellArray(){
        CellArray nextCellArray = new CellArray(cells.getRows(),cells.getColums());
        for (int i = 0 ; i < cells.getRows() ; i++){
            for (int j = 0 ; j < cells.getColums() ; j++){
                switch (calculateActiveNeighbor(i,j)) {
                    case 3 :
                        nextCellArray.setCellStatus(i, j, CellStatus.Active);
                        break;
                    case 2 :
                        if(cells.getCellStatus(i, j) == CellStatus.Active) {
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
