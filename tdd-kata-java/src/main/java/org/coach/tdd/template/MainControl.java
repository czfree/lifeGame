package org.coach.tdd.template;

/**
 * Created by czfree on 2017/6/3.
 */
public class MainControl {
    public static void main(String[] args) {
        GameService gameService = new GameService(50, 50);
        gameService.randInitCellArray();
        CellArrayOutput.printCells(gameService.getCells());
        for (int i = 0 ; i < 50 ; i++) {
            gameService.updateCellArray();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-----------------------------------------");
            CellArrayOutput.printCells(gameService.getCells());
        }
    }
}
