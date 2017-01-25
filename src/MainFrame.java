import windowSetting.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Image imageIcon = new ImageIcon("image\\cat.jpg").getImage();
    private GameBoard gameBoard;
    private JPanel panelGameSetting;
    private Score score;
    private PanelNextFigure panelNextFigure;
    private PanelBonus panelBonus;
    private PanelMenu panelMenu;
    private int width = 484;
    private int height = 652;
    private int indent = 10;

    private void create(){
        setTitle("TETRIS");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setCenterPosition();
        setResizable(false);
        setIconImage(imageIcon);        //need icon
        setLayout(null);
        setBackground(new Color(0,100,100));
    }

    private void setCenterPosition() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - width) / 2, (screenSize.height - height) / 2);
    }


    public MainFrame() {
        //create window
        create();

        //game board
        gameBoard = new GameBoard(indent, indent, (width*2/3) - indent*2, height - indent*2 - 30);
        gameBoard.setBorder(BorderFactory.createRaisedBevelBorder());
        add(gameBoard);

        //settings
        panelGameSetting = new JPanel(new GridBagLayout());
        panelGameSetting.setBounds((width*2/3), indent, (width/3) - indent - 5, height - indent*2 - 30);
        panelGameSetting.setBackground(new Color(100,0,100));
        panelGameSetting.setBorder(BorderFactory.createRaisedBevelBorder());
        add(panelGameSetting);

        //settings.score
        score = new Score();
        panelGameSetting.add(score, new GridBagConstraints(
                0, 0, 1, 1, 0, 1,
                GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL,
                new Insets(-10, 5, -10, 5), 0, 0 ));

        //settings.nextFigure
        panelNextFigure = new PanelNextFigure();
        panelGameSetting.add(panelNextFigure, new GridBagConstraints(
                0, 1, 1, 3, 0, 3,
                GridBagConstraints.CENTER,
                GridBagConstraints.VERTICAL,
                new Insets(0, 5, 5, 5), 135, 0 ));

        //settingsBonus
        panelBonus = new PanelBonus();
        panelGameSetting.add(panelBonus, new GridBagConstraints(
                0, 4, 1, 5, 0, 5,
                GridBagConstraints.CENTER,
                GridBagConstraints.VERTICAL,
                new Insets(5, 5, 5, 5), 132, 0 ));

        //settings.Menu
        panelMenu = new PanelMenu();
        panelGameSetting.add(panelMenu, new GridBagConstraints(
                0, 9, 1, 3, 0, 3,
                GridBagConstraints.CENTER,
                GridBagConstraints.VERTICAL,
                new Insets(5, 5, 10, 5), 20, 0 ));

        //finish to create window
        setVisible(true);
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Score getScore() {
        return score;
    }

    public PanelNextFigure getPanelNextFigure() {
        return panelNextFigure;
    }

    public PanelBonus getPanelBonus() {
        return panelBonus;
    }

    public PanelMenu getPanelMenu() {
        return panelMenu;
    }
}







//public class MainFrame extends JFrame {
//    private Image img;
//    private JPanel jp;
//    private JLabel jl;
//    private void init(){
//        img = new ImageIcon("image\\cat.jpg").getImage();
//    }
//    public MainFrame() {
//        init();
//        setLayout(null);
//
//
//        jp = new JPanel(){
//            @Override
//            public void paint(Graphics g) {
//                super.paint(g);
//                Image img = new ImageIcon("src\\image\\cat.jpg").getImage();
//                g.drawImage(img, 0, 0,getWidth(),getHeight(), null);
//            }
//        };
//
//        add(new JPanel());
//        jl = new JLabel(new ImageIcon("image\\cat.jpg"));
//        add(jl);
//    }
//
//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//        Image img = new ImageIcon("image\\cat.jpg").getImage();
//        g.drawImage(img, 0, 0,getWidth(),getHeight(), null);
//    }
//}