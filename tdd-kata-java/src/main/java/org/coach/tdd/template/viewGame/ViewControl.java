package org.coach.tdd.template.viewgame;

import org.coach.tdd.template.service.GameService;


public class ViewControl {
    private ViewJFrame viewJFrame;
    private ViewJPanel viewJPanel;
    private GameService gameService;
    private int frameWidth = 1000;
    private int frameHeigh = 600;
    private int cellSize = 20;
    private int iterationCnt = 50;
    private int internalTime = 1000;

    public ViewControl (GameService gameService) {
        viewJFrame = new ViewJFrame();
        viewJPanel = new ViewJPanel();
        viewJFrame.add(viewJPanel);
        this.gameService = gameService;
    }

    public void startGame() {
        viewJFrame.setSize(frameWidth, frameHeigh);
        viewJPanel.setCellSize(cellSize);
        viewJFrame.setVisible(true);
        for (int i = 0 ; i < iterationCnt ; i++) {
            gameService.updateCellArray();
            viewJPanel.setCells(gameService.getCells());
            viewJPanel.repaint();
            try {
                Thread.sleep(internalTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    public void setFrameHeigh(int frameHeigh) {
        this.frameHeigh = frameHeigh;
    }

    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }

    public void setIterationCnt(int iterationCnt) {
        this.iterationCnt = iterationCnt;
    }

    public void setInternalTime(int internalTime) {
        this.internalTime = internalTime;
    }
}
