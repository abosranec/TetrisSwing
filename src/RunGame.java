import mainGame.*;
import windowSetting.MyKeyEventDispatcher;

import java.awt.*;

public class RunGame implements Runnable {
    private MainFrame mainFrame;
    private GameBoard gameBoard;
    private MyKeyEventDispatcher myKeyEventDispatcher;
    private int gameSpeed = 10000;
    public RunGame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        gameBoard = mainFrame.getGameBoard();
        //for global keyListener
        myKeyEventDispatcher = new MyKeyEventDispatcher();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(myKeyEventDispatcher);
    }

    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();

        //select random figure
        Figure currentFigure = new TFigure(gameBoard.getGridLayout());
        gameBoard.newCurrentFigure(currentFigure);
        while(true){
            //move right
            if (myKeyEventDispatcher.isRight()) {
                gameBoard.moveCurrentFigure(GameBoard.RIGHT);
                myKeyEventDispatcher.resetRight();
            }
            //move left
            if (myKeyEventDispatcher.isLeft()) {
                gameBoard.moveCurrentFigure(GameBoard.LEFT);
                myKeyEventDispatcher.resetLeft();
            }
            //next figure
            if (myKeyEventDispatcher.isUp()) {
                gameBoard.moveCurrentFigure(GameBoard.NEXT);
                myKeyEventDispatcher.resetUp();
            }

            //simple move down
            while(Math.abs(System.currentTimeMillis() - currentTime) > myKeyEventDispatcher.setSpeed(gameSpeed)){
                // for game speed
                currentTime = System.currentTimeMillis();
                //move figure for board
                gameBoard.moveCurrentFigure(GameBoard.MOVE);
            }
        }
    }
}
