package mainGame;

import javax.swing.*;
import java.awt.*;

public class Cell extends JLabel {
    private Image image;
    private int x;
    private int y;
    private int width;
    private int height;

    public Cell(Icon image, int horizontalAlignment, int x, int y, int width, int height) {
        super(image, horizontalAlignment);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
