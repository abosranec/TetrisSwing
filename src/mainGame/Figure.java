package mainGame;

import java.awt.*;
import java.util.Random;

public interface Figure {
    void initFigure(int wigthBoard, int heightBoard);
    void move();
    void right();
    void left();
    Cell[][] getCells();
    int getWorkWidth();
    int getWorkHeight();

    static Color randomColor(){
        Random random = new Random();
        return new Color(
                50 + (int)(System.currentTimeMillis() % 150),
                50 + random.nextInt(150),
                50 + random.nextInt(75) + (int)(System.currentTimeMillis() % 75));
    }
}
