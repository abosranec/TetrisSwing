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

    static Figure randomFigure(Cell[][] cellsBoard){
        Random random = new Random();
        switch (random.nextInt(7)){
            case 0: return new IFigure(cellsBoard);
            case 1: return new JFigure(cellsBoard);
            case 2: return new LFigure(cellsBoard);
            case 3: return new OFigure(cellsBoard);
            case 4: return new SFigure(cellsBoard);
            case 5: return new TFigure(cellsBoard);
            case 6: return new ZFigure(cellsBoard);
            default: return new TFigure(cellsBoard);
        }
    }
}
