package windowSetting;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Pasha on 12.01.2017.
 */
public class Score extends JLabel {
    private Font f;
    public Score() {
        //settings.score
        super("10000", JLabel.CENTER);
        setOpaque(true);
        setBackground(new Color(100,150,200));
        setBorder(BorderFactory.createRaisedBevelBorder());

        //font
        f = new Font(Font.SERIF, Font.PLAIN, 24);
        setFont(f);
        setForeground(new Color(255,255,255));
    }
}
