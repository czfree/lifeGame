package org.coach.tdd.template;

/**
 * Created by czfree on 2017/6/3.
 */
public class CellArrayOutput {
    public static final String ACTIVEOUT = "*";
    public static final String DEADOUT = " ";

    public static void printCells(CellArray cells) {
        for (int i = 0 ; i < cells.getRows() ; i++) {
            StringBuffer s = new StringBuffer();
            for (int j = 0 ; j < cells.getColums() ; j++) {
                if (cells.getCellStatus(i, j) == CellStatus.Active) {
                    s.append(ACTIVEOUT);
                } else {
                    s.append(DEADOUT);
                }
            }
            System.out.println(s);
        }
    }
}
