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
//                gridLayout[i][j].setBackground(new Color(i*25,j*12,i*j+50));
                gridLayout[i][j].setOpaque(true);
//                add(gridLayout[i][j]);
            }
        }
    }

    public Cell[][] getGridLayout() {
        return gridLayout;
    }

    public void newCurrentFigure(Figure newFigure) {
        this.currentFigure = newFigure;
        drawCurrentFigure(newFigure);
    }

    public void drawCurrentFigure(Figure currentFigure) {
        for (int i = 0; i < currentFigure.getCells().length; i++) {
            for (int j = 0; j < (currentFigure.getCells())[i].length; j++) {
                if (currentFigure.getCells()[i][j].isOpaque()) {
                    int x = (gridLayout.length - currentFigure.getWorkWidth()) / 2;
                    currentFigure.getCells()[i][j].setxBoard(x+j);
                    currentFigure.getCells()[i][j].setyBoard(i);
                    gridLayout[x + j][i].setBackground((currentFigure.getCells()[i][j]).getBackground());
                    add(gridLayout[x + j][i]);
                    gridLayout[x + j][i].repaint();
                }
            }
        }
    }

    public void moveCurrentFigure(){
        //delete old figure
        for (int i = 0; i < currentFigure.getCells().length; i++) {
            for (int j = 0; j < (currentFigure.getCells())[i].length; j++) {
                Cell cell = currentFigure.getCells()[i][j];
                if (cell.isOpaque()) {
                    int xBoard = currentFigure.getCells()[i][j].getxBoard();
                    int yBoard = currentFigure.getCells()[i][j].getyBoard();

                    remove(gridLayout[xBoard][yBoard]);
                    repaint(gridLayout[xBoard][yBoard].getBounds());

                    cell.setyBoard(yBoard + 1);
                }
            }
        }

        //move new figure
        for (int i = 0; i < currentFigure.getCells().length; i++) {
            for (int j = 0; j < (currentFigure.getCells())[i].length; j++) {
                if (currentFigure.getCells()[i][j].isOpaque()) {
                    int xBoard = currentFigure.getCells()[i][j].getxBoard();
                    int yBoard = currentFigure.getCells()[i][j].getyBoard();

                    gridLayout[xBoard][yBoard].setBackground((currentFigure.getCells()[i][j]).getBackground());
                    add(gridLayout[xBoard][yBoard]);
                    gridLayout[xBoard][yBoard].repaint();
                }
            }
        }
    }
}
