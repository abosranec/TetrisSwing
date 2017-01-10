import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Image imageIcon = new ImageIcon("image\\cat.jpg").getImage();
    private JPanel gameBoard;
    private JPanel panelGameSetting;
    private JTextField score;
    private JPanel panelNextFigure;
    private JPanel panelBonus;
    private JPanel panelMenu;
    private int width = 550;
    private int height = 600;
    private int indent = 10;

    private void create(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Teeeetris");
                setSize(width, height);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });

        setCenterPosition();
        setResizable(false);
        setIconImage(imageIcon);        //need icon
        setLayout(null);
    }

    private void setCenterPosition() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - width) / 2, (screenSize.height - height) / 2);
    }


    public MainFrame() {
        //create window
        create();

        //game board
        gameBoard = new JPanel(null);
        gameBoard.setBounds(indent, indent, (width*3/4) - indent*2, height - indent*2 - 30);
        gameBoard.setBackground(new Color(100,0,0));
        add(gameBoard);

        //settings
        panelGameSetting = new JPanel(new GridBagLayout());
        panelGameSetting.setBounds((width*3/4), indent, (width/4) - indent, height - indent*2 - 30);
        panelGameSetting.setBackground(new Color(100,0,100));
        add(panelGameSetting);

        //settings.score
        score = new JTextField("10000");
        score.setFont(new Font("Default", 1, 24));
        panelGameSetting.add(score, new GridBagConstraints(
                0, 0, 1, 1, 0, 1,
                GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 0 ));

        //settings.nextFigure
        panelNextFigure = new JPanel();
        panelGameSetting.add(panelNextFigure, new GridBagConstraints(
                0, 1, 1, 3, 0, 3,
                GridBagConstraints.CENTER,
                GridBagConstraints.VERTICAL,
                new Insets(5, 5, 5, 5), 20, 30 ));

        //settingsBonus
        panelBonus = new JPanel();
        panelGameSetting.add(panelBonus, new GridBagConstraints(
                0, 4, 1, 5, 0, 5,
                GridBagConstraints.CENTER,
                GridBagConstraints.VERTICAL,
                new Insets(5, 5, 5, 5), 20, 30 ));

        //settings.Menu
        panelMenu = new JPanel(new GridBagLayout());
        panelGameSetting.add(panelMenu, new GridBagConstraints(
                0, 9, 1, 3, 0, 3,
                GridBagConstraints.CENTER,
                GridBagConstraints.VERTICAL,
                new Insets(5, 5, 5, 5), 20, 0 ));


        panelMenu.add(new Button("старт/пауза"), new GridBagConstraints(
                0, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER,
                GridBagConstraints.VERTICAL,
                new Insets(0,0,0,0), 0, 0 ));
        panelMenu.add(new Button("сначала"), new GridBagConstraints(
                0, 1, 1, 1, 0, 0,
                GridBagConstraints.CENTER,
                GridBagConstraints.VERTICAL,
                new Insets(0,0,0,0), 0, 0 ));
        panelMenu.add(new Button("выход"), new GridBagConstraints(
                0, 2, 1, 1, 0, 0,
                GridBagConstraints.CENTER,
                GridBagConstraints.VERTICAL,
                new Insets(0,0,0,0), 0, 0 ));




        //finish to create window
        setVisible(true);
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