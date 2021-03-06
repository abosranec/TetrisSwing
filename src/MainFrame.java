import windowSetting.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Image imageIcon = new ImageIcon("image\\icon2.jpg").getImage();
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
        setTitle("ТЕТРИС");
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
        panelGameSetting = new JPanel(null);
        panelGameSetting.setBounds((width*2/3), indent, (width/3) - indent - 5, height - indent*2 - 30);
        panelGameSetting.setBackground(new Color(120,0,120));
        panelGameSetting.setBorder(BorderFactory.createRaisedBevelBorder());
        int widthSetting = panelGameSetting.getWidth() - indent*2;
        int heightSetting = (panelGameSetting.getHeight() - indent*5)/12;
        add(panelGameSetting);

        //settings.score
        score = new Score();
        score.setBounds(indent ,indent, widthSetting, heightSetting);
        panelGameSetting.add(score);

        //settings.nextFigure
        panelNextFigure = new PanelNextFigure(indent ,indent*2 + heightSetting, widthSetting, heightSetting * 3 - indent);
        panelGameSetting.add(panelNextFigure);

        //settingsBonus
        panelBonus = new PanelBonus();
        panelBonus.setBounds(indent ,- indent + indent*3 + heightSetting*4, widthSetting, heightSetting * 5 + indent);
        panelGameSetting.add(panelBonus);

        //settings.Menu
        panelMenu = new PanelMenu();
        panelMenu.setBounds(indent ,indent*4 + heightSetting*9, widthSetting, heightSetting * 3);
        panelGameSetting.add(panelMenu);

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

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Image img = new ImageIcon("image\\fon7.jpg").getImage();
        g.drawImage(img, 0, 0, getWidth(),getHeight(), null);
        gameBoard.repaint();
        panelGameSetting.repaint();
    }
}