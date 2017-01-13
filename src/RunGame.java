
public class RunGame implements Runnable {
    private MainFrame mainFrame;
    private GameBoard gameBoard;
    private long gameSpeed = 100;
    public RunGame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        gameBoard = mainFrame.getGameBoard();
    }

    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();
        while((System.currentTimeMillis() - currentTime) > 100){
            System.out.println("opa");
        }
    }
}
