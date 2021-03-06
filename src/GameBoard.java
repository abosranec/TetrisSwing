import mainGame.Cell;
import mainGame.Figure;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {
    private int indentCell = 2; //between cell
    private int widthCell; //width cell
    private int heightCell; //height cell
    private Cell[][] gridLayout = new Cell[10][20];
    private Figure currentFigure;
    public final static int MOVE = 2;
    public final static int NEXT = 3;
    public final static int RIGHT = 1;
    public final static int LEFT = -1;
    public final static int GAME_OVER = 10;
    public GameBoard(int x, int y, int width, int height) {
        setLayout(null);
        setBounds(x, y, width, height);
        setBackground(new Color(210,210,210));
        widthCell = (getWidth() - indentCell * (gridLayout.length + 1)) / gridLayout.length;
        heightCell = widthCell;
        createCell();
    }

    private void createCell(){
        for (int i = 0; i < gridLayout.length; i++) {
            for (int j = 0; j < gridLayout[i].length; j++) {
                gridLayout[i][j] = new Cell(
                        (i+1)*indentCell + i * widthCell,
                        (j+1)*indentCell + j * heightCell,
                        widthCell, heightCell, i, j);
                gridLayout[i][j].setOpaque(true);
                gridLayout[i][j].setVisible(false);
                add(gridLayout[i][j]);
            }
        }
    }

    public void newCurrentFigure(Figure newFigure) {
        this.currentFigure = newFigure;
        drawCurrentFigure(true);
    }

    private void drawCurrentFigure(boolean visible) {
        for (int i = 0; i < currentFigure.getCells().length; i++) {
            for (int j = 0; j < (currentFigure.getCells())[i].length; j++) {
                if (currentFigure.getCells()[i][j].isVisible()) {
                    int xBoard = currentFigure.getCells()[i][j].getxBoard();
                    int yBoard = currentFigure.getCells()[i][j].getyBoard();
                    if (xBoard > -1 && yBoard > -1) {
                        gridLayout[xBoard][yBoard].setBackground((currentFigure.getCells()[i][j]).getBackground());
                        gridLayout[xBoard][yBoard].setVisible(visible);
                    }
                }
            }
        }
    }

    //type only MOVE, UP, RIGHT, LEFT
    public void moveCurrentFigure(int type){
        //erase old figure
        drawCurrentFigure(false);

        //move new figure
        switch (type){
            case MOVE: currentFigure.move(gridLayout); break;
            case NEXT: currentFigure.next(gridLayout); break;
            case RIGHT: currentFigure.rightAndLeft(gridLayout, RIGHT); break;
            case LEFT: currentFigure.rightAndLeft(gridLayout, LEFT); break;
        }

        //draw new figure
        drawCurrentFigure(true);
    }

    public Cell[][] getGridLayout() {
        return gridLayout;
    }

    //destroy all board
    public int checkBoardOnString(){
        int counterString = 0;
        int counterCells = 0;
        for (int i = 0; i < gridLayout[0].length; i++) {
            //count cells on one string
            for (int j = 0; j < gridLayout.length; j++) {
                if (gridLayout[j][i].isVisible()) {
                    counterCells++;
                }
            }
            //if need to destroy string
            if (counterCells == gridLayout.length){
                counterString++;
                for (int k = 0; k < gridLayout.length; k++) {
                    for (int l = i; l > 0; l--) {
                        gridLayout[k][l].setBackground(gridLayout[k][l - 1].getBackground());
                        gridLayout[k][l].setVisible(gridLayout[k][l - 1].isVisible());
                        gridLayout[k][l - 1].setVisible(false);
                    }
                }
            }
            counterCells = 0;
        }
        //check figure on the game over
        T:
        for (int i = 0; i < currentFigure.getCells().length; i++) {
            for (int j = 0; j < (currentFigure.getCells())[i].length; j++) {
                if (currentFigure.getCells()[i][j].isVisible()) {
                    int yBoard = currentFigure.getCells()[i][j].getyBoard();
                    if (yBoard + counterString < 0) {
                        counterString = GAME_OVER;
                        break T;
                    }
                }
            }
        }
        return counterString;
    }

    //destroy all board
    public void resetGridLayout(){
        for (int i = 0; i < gridLayout.length; i++) {
            for (int j = 0; j < gridLayout[i].length; j++) {
                gridLayout[i][j].setVisible(false);
            }
        }
    }

    public Figure getCurrentFigure() {
        return currentFigure;
    }
}
