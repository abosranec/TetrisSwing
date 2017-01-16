package mainGame;

import javax.swing.*;
import java.awt.*;

public class Cell extends JLabel {
    private Image image;
    private int xBoard;
    private int yBoard;

    public Cell(int x, int y, int width, int height, int xBoard, int yBoard) {
        //setHorizontalAlignment(JLabel.CENTER);
        setBorder(BorderFactory.createRaisedBevelBorder());
        setBounds(x, y, width, height);
        this.xBoard = xBoard;
        this.yBoard = yBoard;
    }

    public Cell(boolean isUse, Color color) {
        setVisible(isUse);
        setBackground(color);
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
