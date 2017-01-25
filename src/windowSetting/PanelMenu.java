package windowSetting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelMenu extends JPanel {
    private JButton bStart;
    private Icon iconStart = new ImageIcon("image\\start.jpg");
    private Icon iconStop = new ImageIcon("image\\stop.jpg");
    private JButton bRepeat;
    private Icon iconRepeat = new ImageIcon("image\\repeat.jpg");
    private JButton bExit;
    private Icon iconExit = new ImageIcon("image\\exit.jpg");
    private boolean start = false;
    private boolean restart = false;
    public PanelMenu() {
        super(new GridBagLayout());
        setBorder(BorderFactory.createRaisedBevelBorder());
        setBackground(new Color(200,200,200));
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
        bStart.setIcon(iconStart);
        bStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                start = !start;
                if(start) {
                    bStart.setText("ПАУЗА");
                    bStart.setIcon(iconStop);
                }
                else{
                    bStart.setText("СТАРТ");
                    bStart.setIcon(iconStart);
                }
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
        bRepeat.setIcon(iconRepeat);
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
        bExit.setIcon(iconExit);
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
        bStart.setIcon(iconStop);
        this.start = true;
    }

    public boolean isRestart() {
        return restart;
    }

    public void resetRestart() {
        this.restart = false;
    }
}
