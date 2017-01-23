import mainGame.*;
import windowSetting.MyKeyEventDispatcher;

import javax.swing.*;
import java.awt.*;

public class RunGame implements Runnable {
    private MainFrame mainFrame;
    private GameBoard gameBoard;
    private MyKeyEventDispatcher myKeyEventDispatcher;
    private int gameSpeed = 2000;
    private boolean gameOver = true;
    public RunGame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        gameBoard = mainFrame.getGameBoard();
        //for global keyListener
        myKeyEventDispatcher = new MyKeyEventDispatcher();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(myKeyEventDispatcher);
    }

    @Override
    public void run() {
        while(true) {
            //start new game
            while (gameOver) {
                // for game speed
                long currentTime = System.currentTimeMillis();
                //select random figure
                Figure currentFigure = Figure.randomFigure(gameBoard.getGridLayout());
                gameBoard.newCurrentFigure(currentFigure);
                //use new figure
                while (currentFigure.isStatus()) {
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
                    while (Math.abs(System.currentTimeMillis() - currentTime) > myKeyEventDispatcher.setSpeed(gameSpeed)) {
                        // for game speed
                        currentTime = System.currentTimeMillis();
                        //move figure for board
                        gameBoard.moveCurrentFigure(GameBoard.MOVE);
                    }
                }
                //after destroy figure need check board on full string
                if (gameBoard.checkBoardOnString() == gameBoard.GAME_OVER) {
                    System.out.println("game over");
                    gameOver = false;
                    JOptionPane.showMessageDialog(null, "", "GAME OVER",
                            JOptionPane.INFORMATION_MESSAGE,
                            new ImageIcon("image\\gameOver.jpg"));
                }
            }



        }
    }
}
