package windowSetting;

import javax.swing.*;
import java.awt.*;

public class PanelNextFigure extends JPanel {
    public PanelNextFigure() {
        //super(new GridBagLayout());
        setLayout(null);
        setBackground(new Color(200,200,200));
        setBorder(BorderFactory.createRaisedBevelBorder());
        Button b = new Button();
        b.setBounds(0 ,10, 100, 100);
        add(b);
    }
}
