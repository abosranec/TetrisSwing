
public class Application {

    public static void main(String[] args) {
        //создаем окно
        MainFrame mainFrame = new MainFrame();

        //запускаем игрушку
        Thread thread = new Thread(new RunGame(mainFrame));
        thread.start();


        /////////////////////////////////////////
//        int m = 4;
//        int[][] A = new int[m][m];
//        // fill matrix
//        for (int i=0; i<m; i++)
//        {
//            for (int j=0; j<m; j++)
//            {
//                A[i][j] = m*i + j;
//            }
//        }
//        // print
//        for (int i=0; i<m; i++)
//        {
//            for (int j=0; j<m; j++)
//            {
//                System.out.printf("%3d ", A[i][j]);
//            }
//            System.out.print("\n");
//        }
//        System.out.print("rotated\n");
//        // rotate
//        for (int i=0; i<m/2; i++) // border -> center
//        {
//            for (int j=i; j<m-1-i; j++) // left -> right
//            {
//                // меняем местами 4 угла
//                int tmp         = A[i][j];
//
//                A[i][j]         = A[m-j-1][i];
//                A[m-j-1][i]     = A[m-i-1][m-j-1];
//                A[m-i-1][m-j-1] = A[j][m-i-1];
//                A[j][m-i-1]     = tmp;
//
//            }
//        }
//        // print
//        for (int i=0; i<m; i++)
//        {
//            for (int j=0; j<m; j++)
//            {
//                System.out.printf("%3d ", A[i][j]);
//            }
//            System.out.print("\n");
//        }
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
