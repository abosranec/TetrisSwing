import mainGame.Figure;
import mainGame.OFigure;

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
        long currentTime = System.currentTimeMillis();

        //select random figure
        Figure currentFigure = new OFigure();
        gameBoard.newCurrentFigure(currentFigure);
        while(true){
            while(Math.abs(System.currentTimeMillis() - currentTime) > gameSpeed){
                // for game speed
                currentTime = System.currentTimeMillis();

                //move figure for board
                //System.out.println("opa");
            }
        }
    }
}
