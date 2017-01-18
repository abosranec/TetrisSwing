package mainGame;

import javax.swing.*;
import java.awt.*;

public class Cell extends JLabel {
    private Icon image;
    private int xBoard;
    private int yBoard;

    public Cell(int x, int y, int width, int height, int xBoard, int yBoard) {
        setBorder(BorderFactory.createRaisedBevelBorder());
        setBounds(x, y, width, height);
        this.xBoard = xBoard;
        this.yBoard = yBoard;
    }

    public Cell(boolean isUse, Color color, int xBoard, int yBoard) {
        setVisible(isUse);
        setBackground(color);
        this.xBoard = xBoard;
        this.yBoard = yBoard;
    }

    public Cell(Cell cell) {
        this.image = cell.getIcon();
        this.xBoard = cell.getxBoard();
        this.yBoard = cell.getyBoard();
        setBorder(cell.getBorder());
        setBounds(cell.getBounds());
        setVisible(cell.isVisible());
        setBackground(cell.getBackground());
    }

    public int getxBoard() {
        return xBoard;
    }

    public int getyBoard() {
        return yBoard;
    }

    public void setxBoard(int xBoard) {
        this.xBoard = xBoard;
    }

    public void setyBoard(int yBoard) {
        this.yBoard = yBoard;
    }
}
