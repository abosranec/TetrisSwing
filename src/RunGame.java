
public class RunGame implements Runnable {
    private MainFrame mainFrame;
    private GameBoard gameBoard;
    private long gameSpeed = 500;
    public RunGame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        gameBoard = mainFrame.getGameBoard();
    }

    @Override
    public void run() {
        int i = 0;
        long currentTime = System.currentTimeMillis();
        System.out.println(currentTime);
        while(i < 20){
            while(Math.abs(System.currentTimeMillis() - currentTime) > gameSpeed){
                currentTime = System.currentTimeMillis();
                System.out.println("opa");
                i++;
            }
        }
    }
}
