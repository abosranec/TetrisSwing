package mainGame;

import javax.swing.*;
import java.awt.*;

public class Cell extends JLabel {
    private Image image;

    public Cell(Icon image, int x, int y, int width, int height) {
        super(image, JLabel.CENTER);
        setBounds(x, y, width, height);
    }
}
