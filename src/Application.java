
public class Application {
    public static void main(String[] args) {
        //создаем окно
        MainFrame mainFrame = new MainFrame();

        //запускаем игрушку
        Thread thread = new Thread(new RunGame(mainFrame));
        thread.start();
    }
}














//
//        JLabel l = new JLabel(new ImageIcon("image\\cat.jpg"), JLabel.CENTER);
//        l.setFocusable(true);
//        //l.setOpaque(true);
//        l.setBounds(200, 200, 50, 50);
//        l.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                System.out.println("bum...");
//                JLabel jl =  (JLabel)e.getComponent();
//                if(e.getKeyCode()==e.VK_W){
//                    jl.setLocation(jl.getX(), jl.getY()-5);
//                    jl.repaint();
//                }
//                if(e.getKeyCode()==e.VK_S){
//                    jl.setLocation(jl.getX(), jl.getY()+5);
//                    jl.repaint();
//                }
//                if(e.getKeyCode()==e.VK_A){
//                    jl.setLocation(jl.getX()-5, jl.getY());
//                    jl.repaint();
//                }
//                if(e.getKeyCode()==e.VK_D){
//                    jl.setLocation(jl.getX()+5, jl.getY());
//                    jl.repaint();
//                }
//                if(e.getKeyCode()==e.VK_N){
//                    jl.setLocation(50, 50);
//                    jl.repaint();
//                }
//            }
//        });
//        l.addFocusListener(new FocusAdapter() {
//            @Override
//            public void focusLost(FocusEvent e) {
//                System.out.println("lost...((");
//                e.getComponent().setFocusable(true);
//            }
//        });
//        gameBoard.add(l);
