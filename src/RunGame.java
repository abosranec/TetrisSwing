import mainGame.*;
import windowSetting.*;

import javax.swing.*;
import java.awt.*;

public class RunGame implements Runnable {
    private MainFrame mainFrame;
    private GameBoard gameBoard;
    private PanelMenu panelMenu;
    private MyKeyEventDispatcher myKeyEventDispatcher;
    private int gameSpeed = 1000;
    private boolean gameOver = true;
    private boolean reStartGame = false;
    public RunGame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        gameBoard = mainFrame.getGameBoard();
        panelMenu = mainFrame.getPanelMenu();
        //for global keyListener
        myKeyEventDispatcher = new MyKeyEventDispatcher();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(myKeyEventDispatcher);
    }

    @Override
    public void run() {
        while(true) {
            //start new game
            System.out.print("");
            if (panelMenu.isStart()) {
                while (gameOver) {
                    // for game speed
                    long currentTime = System.currentTimeMillis();
                    //select random figure
                    Figure currentFigure = Figure.randomFigure(gameBoard.getGridLayout());
                    gameBoard.newCurrentFigure(currentFigure);
                    //use new figure
                    while (currentFigure.isStatus()) {
                        //if game start, listen the moving buttons
                        listenButtonMoving(panelMenu.isStart());
                        //simple move down
                        while (Math.abs(System.currentTimeMillis() - currentTime) > myKeyEventDispatcher.setSpeed(gameSpeed)) {
                            // for game speed
                            currentTime = System.currentTimeMillis();
                            //move figure for board if game start
                            if (panelMenu.isStart())
                                gameBoard.moveCurrentFigure(GameBoard.MOVE);
                        }
                        //check restart game
                        if(panelMenu.isRestart()){
                            restartGame();
                            break;
                        }
                    }
                    //after destroy figure need check board on full string
                    System.out.println(gameBoard.checkBoardOnString());
                    if (gameBoard.checkBoardOnString() == GameBoard.GAME_OVER && !reStartGame)
                        callGameOver();
                }
            }
            //if game over, game reset after button reset
            if(panelMenu.isRestart())
                restartGame();
        }
    }

    //if game start, listen the moving buttons
    private void listenButtonMoving(boolean moving){
        if (moving) {
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
        }
        else{
        //reset move and rotate figure
            myKeyEventDispatcher.resetRight();
            myKeyEventDispatcher.resetLeft();
            myKeyEventDispatcher.resetUp();
        }
    }

    //after destroy figure need check board on full string
    private void callGameOver(){
        gameOver = false;
        JOptionPane.showMessageDialog(null, "", "GAME OVER",
                JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon("image\\gameOver.jpg"));
    }

    //check restart game
    private void restartGame(){
        //destroy game board
        gameBoard.resetGridLayout();
        //reset button restart
        reStartGame = false;
        panelMenu.resetRestart();
        //reset button start
        panelMenu.resetStart();
        gameOver = true;
    }
}
