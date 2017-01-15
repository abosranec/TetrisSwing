package mainGame;

import java.awt.*;
import java.util.Random;

//   ##
//   ##
public class OFigure implements Figure {
    private int maxWidth = 2;
    private int maxHeight = 2;
    private int workWidth = 2;
    private int workHeight = 2;
    private Cell[][] cells;
    private Color color;

    public OFigure() {
        //create random color
        randomColor();

        //make figure
        initFigure();
    }

    public void randomColor(){
        Random random = new Random();
        color = new Color(
                50 + (int)(System.currentTimeMillis() % 150),
                50 + random.nextInt(150),
                50 + random.nextInt(75) + (int)(System.currentTimeMillis() % 75));
    }

    @Override
    public void initFigure() {
        cells = new Cell[maxWidth][maxHeight];
        //*#
        //##
        cells[0][0] = new Cell(true, color);
        //#*
        //##
        cells[0][1] = new Cell(true, color);
        //##
        //*#
        cells[1][0] = new Cell(true, color);
        //##
        //#*
        cells[1][1] = new Cell(true, color);
    }

    @Override
    public void move() {

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
