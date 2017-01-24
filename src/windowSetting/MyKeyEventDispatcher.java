package windowSetting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MyKeyEventDispatcher implements KeyEventDispatcher{
    private volatile boolean up;
    private volatile boolean down;
    private volatile boolean right;
    private volatile boolean left;
    private int speedDown = 20;
    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (KeyStroke.getKeyStrokeForEvent(e).getKeyEventType() == 401){
            if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP && !up)
                up = true;
            if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN && !down)
                down = true;
            if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT && !right)
                right = true;
            if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT && !left)
                left = true;
        }
        if (KeyStroke.getKeyStrokeForEvent(e).getKeyEventType() == 402){
            if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN)
                down = false;
        }
        return false;
    }

    public int setSpeed(int currentSpeed){
        if (isDown())
            return speedDown;
        else
            return currentSpeed;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    public void resetUp() {
        up = false;
    }

    public void resetDown() {
        down = false;
    }

    public void resetRight() {
        right = false;
    }

    public void resetLeft() {
        left = false;
    }
}
