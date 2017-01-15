package mainGame;

import java.awt.*;

public interface Figure {
    void initFigure();
    void move();
    void rightFigure();
    void leftFigure();
    Cell[][] getCells();
    public int getWorkWidth();
    public int getWorkHeight();
}
