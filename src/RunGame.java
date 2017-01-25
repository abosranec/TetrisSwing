import mainGame.*;
import windowSetting.*;

import javax.swing.*;
import java.awt.*;

public class RunGame implements Runnable {
    private GameBoard gameBoard;
    private PanelMenu panelMenu;
    private PanelNextFigure panelNextFigure;
    private Score score;
    private MyKeyEventDispatcher myKeyEventDispatcher;
    private int gameSpeed;
    public static final int START_SPEED = 900;
    public static final int MIN_SPEED = 100;
    public static final int TIME_LEVEL_SPEED = 9000;
    public static final int NUMBER_LEVEL = 20;
    private boolean gameOver = true;
    long timeSpeed = System.currentTimeMillis();
    private int currentLevel = 0;
    private Figure currentFigure;
    private boolean useNextFigure = false;
    public RunGame(MainFrame mainFrame) {
        gameBoard = mainFrame.getGameBoard();
        panelMenu = mainFrame.getPanelMenu();
        score = mainFrame.getScore();
        panelNextFigure = mainFrame.getPanelNextFigure();
        //for global keyListener
        myKeyEventDispatcher = new MyKeyEventDispatcher();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(myKeyEventDispatcher);
        gameSpeed = START_SPEED;
        currentFigure = Figure.randomFigure(gameBoard.getGridLayout());
    }

    @Override
    public void run() {
        while(true) {
            //start new game
            System.out.print("");
            if (panelMenu.isStart()) {
                T:
                while (gameOver) {
                    // for game speed
                    long currentTime = System.currentTimeMillis();
                    //recalculate speed and level
                    timeSpeed = recalculateSpeed(timeSpeed);
                    //select random figure
                    gameBoard.newCurrentFigure(currentFigure);
                    currentFigure = Figure.randomFigure(gameBoard.getGridLayout());
                    panelNextFigure.newCurrentFigure(currentFigure);
                    //use new figure
                    while (gameBoard.getCurrentFigure().isStatus()) {
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
                            break T;
                        }
                    }
                    //check board on full string
                    int numberString = gameBoard.checkBoardOnString();
                    if (numberString == GameBoard.GAME_OVER) {
                        //after destroy figure
                        callGameOver();
                    }
                    else {
                        //recalculate counter and speed
                        score.setCounter(numberString);
                    }
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
        panelMenu.resetRestart();
        //reset button start
        panelMenu.resetStart();
        gameOver = true;
        //reset level and speed
        score.resetValue();
        gameSpeed = START_SPEED;
        timeSpeed = System.currentTimeMillis();
        currentLevel = 0;
        //reset next figure
        panelNextFigure.resetGridLayout();
        useNextFigure = false;
    }

    private long recalculateSpeed(long time){
        //check how many count and decrease level
        if (score.getNumberAddSpeed() > 0){
            currentLevel-= score.getNumberAddSpeed();
            gameSpeed += (score.getNumberAddSpeed()) * (START_SPEED - MIN_SPEED) / NUMBER_LEVEL;
            score.resetNumberAddSpeed(currentLevel);
        }
        //if time for the next level come
        if ((System.currentTimeMillis() - time) > TIME_LEVEL_SPEED){
            if (currentLevel < NUMBER_LEVEL) {
                currentLevel++;
                //recalculate speed
                gameSpeed = START_SPEED - (currentLevel) * (START_SPEED - MIN_SPEED) / NUMBER_LEVEL;
                //update level on score
                score.setLevel(currentLevel);
            }
            return System.currentTimeMillis();
        }
        else return time;
    }
}
