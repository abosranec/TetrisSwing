package windowSetting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelMenu extends JPanel {
    private JButton bStart;
    private JButton bRepeat;
    private JButton bExit;
    private boolean b;
    public PanelMenu() {
        super(new GridBagLayout());
        setBorder(BorderFactory.createRaisedBevelBorder());
        init();
    }
    private void init(){
        //create buttons
        bStart = new JButton("старт/пауза");
        add(bStart, new GridBagConstraints(
                0, 0, 1, 1, 0, 1,
                GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL,
                new Insets(-15,0,-15,0), 0, 0 ));
        bRepeat = new JButton("сначала");
        add(bRepeat, new GridBagConstraints(
                0, 1, 1, 1, 0, 1,
                GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL,
                new Insets(-15,0,-15,0), 0, 0 ));
        bExit = new JButton("выход");
        add(bExit, new GridBagConstraints(
                0, 2, 1, 1, 0, 1,
                GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL,
                new Insets(-15,0,-15,0), 0, 0 ));
    }
}
