package windowSetting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelMenu extends JPanel {
    private JButton bStart;
    private JButton bRepeat;
    private JButton bExit;
    private boolean start = false;
    private boolean restart = false;
    public PanelMenu() {
        super(new GridBagLayout());
        setBorder(BorderFactory.createRaisedBevelBorder());
        init();
    }
    private void init(){
        //create button start/stop
        createBStart();
        //create button restart
        createBRepeat();
        //create button exit game
        createBExit();
    }

    //create button start/stop
    private void createBStart(){
        bStart = new JButton("СТАРТ");
        bStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                start = !start;
                if(start)
                    bStart.setText("ПАУЗА");
                else
                    bStart.setText("СТАРТ");
            }
        });
        add(bStart, new GridBagConstraints(
                0, 0, 1, 1, 0, 1,
                GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL,
                new Insets(-15,0,-15,0), 0, 0 ));
    }

    //create button restart
    private void createBRepeat() {
        bRepeat = new JButton("СНАЧАЛА");
        add(bRepeat, new GridBagConstraints(
                0, 1, 1, 1, 0, 1,
                GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL,
                new Insets(-15,0,-15,0), 0, 0 ));
        bRepeat.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                restart = true;
            }
        });
    }

    //create button exit game
    private void createBExit(){
        bExit = new JButton("ВЫХОД");
        add(bExit, new GridBagConstraints(
                0, 2, 1, 1, 0, 1,
                GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL,
                new Insets(-15,0,-15,0), 0, 0 ));
        bExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });
    }

    public boolean isStart() {
        return start;
    }

    public void resetStart() {
        bStart.setText("ПАУЗА");
        this.start = true;
    }

    public boolean isRestart() {
        return restart;
    }

    public void resetRestart() {
        this.restart = false;
    }
}
