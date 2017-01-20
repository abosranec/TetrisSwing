package mainGame;

import java.awt.*;

public abstract class FigureAdapter implements Figure {
    protected int workWidth;
    protected int workHeight;
    protected Cell[][] cells;
    protected Color color;

    @Override
    public void move() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j].setyBoard(cells[i][j].getyBoard() + 1);
            }
        }
    }

    //type only RIGHT or LEFT
    @Override
    public void rightAndLeft(Cell[][] cellsBoard, int type) {
        Cell[][] oldCells = new Cell[workWidth][workHeight]; //copy figure
        boolean good = false;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                oldCells[i][j] = new Cell(cells[i][j]);
                //check figure to display
                if (cells[i][j].isVisible()
                        && (cells[i][j].getxBoard() + type < cellsBoard.length)
                        && (cells[i][j].getxBoard() + type > -1)) {
                    if (!cellsBoard[cells[i][j].getxBoard() + type][cells[i][j].getyBoard()].isVisible()) {
                        cells[i][j].setxBoard(cells[i][j].getxBoard() + type);
                        continue;
                    }
                }
                //if have mistake
                good = true;
            }
        }
        //if new figure is impossible, use copy figure
        if (good){
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    cells[i][j] = oldCells[i][j];
                }
            }
        }
    }

    @Override
    public void next(Cell[][] cellsBoard) {
        Cell[][] oldCells = new Cell[workWidth][workHeight]; //copy figure
        boolean good = false;
        //initialize copy figure
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                oldCells[i][j] = new Cell(cells[i][j]);
            }
        }
        //get new figure
        for (int i=0; i<workWidth/2; i++)
        {
            for (int j=i; j<workHeight-1-i; j++)
            {
                int x = cells[i][j].getxBoard();
                int y = cells[i][j].getyBoard();
                cells[i][j].setxBoard(cells[j][workWidth-1-i].getxBoard());
                cells[i][j].setyBoard(cells[j][workWidth-1-i].getyBoard());
                cells[j][workWidth-1-i].setxBoard(cells[workWidth-1-i][workWidth-1-j].getxBoard());
                cells[j][workWidth-1-i].setyBoard(cells[workWidth-1-i][workWidth-1-j].getyBoard());
                cells[workWidth-1-i][workWidth-1-j].setxBoard(cells[workWidth-1-j][i].getxBoard());
                cells[workWidth-1-i][workWidth-1-j].setyBoard(cells[workWidth-1-j][i].getyBoard());
                cells[workWidth-1-j][i].setxBoard(x);
                cells[workWidth-1-j][i].setyBoard(y);
            }
        }
        //check figure to display
        T:
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].isVisible()) {
                    if ((cells[i][j].getxBoard() < cellsBoard.length)
                            && (cells[i][j].getxBoard() > -1)
                            && (cells[i][j].getyBoard() < cellsBoard[i].length)
                            && (cells[i][j].getyBoard() > -1))
                        if(!cellsBoard[cells[i][j].getxBoard()][cells[i][j].getyBoard()].isVisible()) {
                            continue ;
                        }
                }
                //if have mistake
                good = true;
                break T;
            }
        }
        //if new figure is impossible, use copy figure
        if (good){
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    cells[i][j] = oldCells[i][j];
                }
            }
        }
    }

    @Override
    public Cell[][] getCells() {
        return cells;
    }
}
