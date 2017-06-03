package org.coach.tdd.template;

import org.coach.tdd.template.service.GameService;
import org.coach.tdd.template.viewgame.ViewControl;

public class MainControl {
    public static void main(String[] args) {
        GameService gameService = new GameService(30, 50);
        gameService.randInitCellArray();
        ViewControl viewControl = new ViewControl(gameService);

        viewControl.setCellSize(20);
        viewControl.setFrameHeigh(700);
        viewControl.setFrameWidth(1100);
        viewControl.setInternalTime(1000);

        viewControl.startGame();
    }
}
