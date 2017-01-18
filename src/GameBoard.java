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

    public void drawCurrentFigure(boolean visible) {
        for (int i = 0; i < currentFigure.getCells().length; i++) {
            for (int j = 0; j < (currentFigure.getCells())[i].length; j++) {
                if (currentFigure.getCells()[i][j].isVisible()) {
                    int xBoard = currentFigure.getCells()[i][j].getxBoard();
                    int yBoard = currentFigure.getCells()[i][j].getyBoard();
                    gridLayout[xBoard][yBoard].setBackground((currentFigure.getCells()[i][j]).getBackground());
                    gridLayout[xBoard][yBoard].setVisible(visible);
                }
            }
        }
    }

    public void moveCurrentFigure(){
        //erase old figure
        drawCurrentFigure(false);
        //move new figure
        currentFigure.move();
        //draw new figure
        drawCurrentFigure(true);
    }

    public Cell[][] getGridLayout() {
        return gridLayout;
    }
}
