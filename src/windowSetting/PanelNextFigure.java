package windowSetting;

import javax.swing.*;
import java.awt.*;

public class PanelNextFigure extends JPanel {
    public PanelNextFigure() {
        //super(new GridBagLayout());
        setLayout(null);
        //setBounds(0, 0, 200, 300);
        setBorder(BorderFactory.createRaisedBevelBorder());
        System.out.println(getX());
        System.out.println(getWidth());
        System.out.println(getHeight());
        Button b = new Button();
        b.setBounds(0 ,0, 50, 50);
        Button b2 = new Button();
        b2.setBounds(55 ,0, 50, 50);
        repaint();
        add(b);
        add(b2);
    }
}
