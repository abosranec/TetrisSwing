package mainGame;

import java.awt.*;
import java.util.Random;

//   ##
//   ##
public class OFigure implements Figure {
    private int workWidth = 2;
    private int workHeight = 2;
    private Cell[][] cells;
    private Color color;

    public OFigure(int wigthBoard, int heightBoard) {
        //create random color
        color = Figure.randomColor();
        //make figure
        initFigure(wigthBoard, heightBoard);
    }

    @Override
    public void initFigure(int wigthBoard, int heightBoard) {
        cells = new Cell[workWidth][workHeight];
        //*#
        //##
        cells[0][0] = new Cell(true, color, (wigthBoard - workWidth) / 2, 0);
        //#*
        //##
        cells[0][1] = new Cell(true, color, 1 + (wigthBoard - workWidth) / 2, 0);
        //##
        //*#
        cells[1][0] = new Cell(true, color, (wigthBoard - workWidth) / 2, 1);
        //##
        //#*
        cells[1][1] = new Cell(true, color, 1 + (wigthBoard - workWidth) / 2, 1);
    }

    @Override
    public void move() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j].setyBoard(cells[i][j].getyBoard() + 1);
            }
        }
    }

    @Override
    public void rightFigure() {

    }

    @Override
    public void leftFigure() {

    }

    @Override
    public Cell[][] getCells() {
        return cells;
    }

    @Override
    public int getWorkWidth() {
        return workWidth;
    }

    @Override
    public int getWorkHeight() {
        return workHeight;
    }

}
