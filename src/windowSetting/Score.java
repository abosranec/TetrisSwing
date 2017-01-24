package windowSetting;

import javax.swing.*;
import java.awt.*;

public class Score extends JLabel {
    private Font f;
    private int level = 0;
    private int counter = 0;
    public Score() {
        //settings.score
        super("0", JLabel.CENTER);
        setOpaque(true);
        setBackground(new Color(100,150,200));
        setBorder(BorderFactory.createRaisedBevelBorder());

        //font
        f = new Font(Font.SERIF, Font.PLAIN, 24);
        setFont(f);
        setForeground(new Color(255,255,255));
    }

    public void setCounter(int numString){
        //recalculate counter
        int value = 0;
        while (numString-- > 0)
            value = value * 2 + 100;
        counter += value;
        //recalculate level

        //update label
        updateValue();
    }

    private void updateValue(){
        setText(level + " : " + counter);
    }
}
