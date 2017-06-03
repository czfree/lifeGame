package org.coach.tdd.template.viewgame;

import java.awt.Graphics;
import javax.swing.JPanel;
import org.coach.tdd.template.entity.CellArray;
import org.coach.tdd.template.entity.CellStatus;

public class ViewJPanel extends JPanel {
    private CellArray cells;
    private int cellSize = 20;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < cells.getRows(); i++) {
            for (int j = 0 ; j < cells.getColums() ; j++) {
                if (cells.getCellStatus(i, j) == CellStatus.Active) {
                    g.fillRect(j * cellSize , i * cellSize , cellSize, cellSize);
                } else {
                    g.drawRect(j * cellSize , i * cellSize, cellSize, cellSize);
                }
            }
        }
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    public void setCells (CellArray cells) {
        this.cells = cells;
    }
}
