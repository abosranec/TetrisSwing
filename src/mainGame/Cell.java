package mainGame;

import javax.swing.*;
import java.awt.*;

public class Cell extends JLabel {
    private Image image;

    public Cell(int x, int y, int width, int height) {
        //setHorizontalAlignment(JLabel.CENTER);
        setBorder(BorderFactory.createRaisedBevelBorder());
        setBounds(x, y, width, height);
    }
}
