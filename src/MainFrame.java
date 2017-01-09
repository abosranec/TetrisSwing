import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Image imageIcon = new ImageIcon("image\\cat.jpg").getImage();;
    private JPanel gameBoard;
    private JPanel gameSetting;
    private JTextField score;
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
                setVisible(true);
            }
        });

        setCenterPosition();
        setResizable(false);
        setIconImage(imageIcon);        //need icon
        setLayout(null);
    }

    private void setCenterPosition() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getPreferredSize();
        setLocation((screenSize.width - width) / 2, (screenSize.height - height) / 2);
    }


    public MainFrame() {
        //create window
        create();

        gameBoard = new JPanel(null);
        gameBoard.setBounds(indent, indent, (width*3/4) - indent*2, height - indent*2 - 30);
        gameBoard.setBackground(new Color(100,0,0));
        add(gameBoard);

        gameSetting = new JPanel();
        gameSetting.setLayout(new FlowLayout());
        gameSetting.setBounds((width*3/4), indent, (width*1/4) - indent, height - indent*2 - 30);
        gameSetting.setBackground(new Color(100,0,100));
        add(gameSetting);

        score = new JTextField("10000");
        gameSetting.add(score);

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