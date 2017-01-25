package windowSetting;

import javax.swing.*;
import java.awt.*;

public class Score extends JLabel {
    private Font f;
    private int level = 1;
    private int counter = 0;
    public static final int VALUE_ADD_SPEED = 500;
    private int numberAddSpeed = 0;
    public Score() {
        //settings.score
        super("0", JLabel.CENTER);
        setOpaque(true);
        setBackground(new Color(100,150,200));
        setBorder(BorderFactory.createRaisedBevelBorder());
        //update label
        updateValue();

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
        //calculate add speed
        calculateForSpeed(value);
        //update label
        counter += value;
        updateValue();
    }

    public void setLevel(int level){
        //recalculate level
        this.level = level;
        setForeground(new Color(120,0,0));
        //update label
        updateValue();
    }

    public void resetValue(){
        level = 1;
        counter = 0;
        setForeground(new Color(255,255,255));
        //update label
        updateValue();
    }

//    public void resetFont() {
//        setForeground(new Color(255,255,255));
//    }

    private void updateValue(){
        setText(level + " : " + counter);
    }

    private void calculateForSpeed(int value){
        numberAddSpeed += ((counter % VALUE_ADD_SPEED) + value) / VALUE_ADD_SPEED;
    }

    public int getNumberAddSpeed() {
        return numberAddSpeed;
    }

    public void resetNumberAddSpeed(int level) {
        numberAddSpeed = 0;
        setForeground(new Color(0,120,0));
        this.level = level;
        //update label
        updateValue();
    }
}
