package windowSetting;

import mainGame.Cell;
import mainGame.Figure;

import javax.swing.*;
import java.awt.*;

public class PanelNextFigure extends JPanel {
    private int indentCell = 2; //between cell
    private int widthCell; //width cell
    private int heightCell; //height cell
    private Cell[][] gridLayout = new Cell[4][4];
    private Figure currentFigure;
    public PanelNextFigure(int x, int y, int width, int height) {
        setLayout(null);
        setBounds(x, y, width, height);
        setBackground(new Color(200,200,200));
        setBorder(BorderFactory.createRaisedBevelBorder());
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
        resetGridLayout();
        drawCurrentFigure(true);
    }

    private void drawCurrentFigure(boolean visible) {
        for (int i = 0; i < currentFigure.getCells().length; i++) {
            for (int j = 0; j < (currentFigure.getCells())[i].length; j++) {
                if (currentFigure.getCells()[i][j].isVisible()) {
                    gridLayout[j][i].setBackground((currentFigure.getCells()[i][j]).getBackground());
                    gridLayout[j][i].setVisible(visible);
                }
            }
        }
    }

    //destroy all board
    public void resetGridLayout(){
        for (int i = 0; i < gridLayout.length; i++) {
            for (int j = 0; j < gridLayout[i].length; j++) {
                gridLayout[i][j].setVisible(false);
            }
        }
    }
}
