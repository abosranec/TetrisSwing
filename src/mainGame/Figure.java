package mainGame;

import java.awt.*;
import java.util.Random;

public interface Figure {
    void initFigure(int widthBoard, int heightBoard, int wWidth, int wHeight);
    void move(Cell[][] cellsBoard);
    void rightAndLeft(Cell[][] cellsBoard, int type);
    void next(Cell[][] cellsBoard);
    Cell[][] getCells();
    boolean isStatus();

    static Color randomColor(){
        Random random = new Random();
        return new Color(
                50 + (int)(System.currentTimeMillis() % 150),
                50 + random.nextInt(150),
                50 + random.nextInt(75) + (int)(System.currentTimeMillis() % 75));
    }
}
