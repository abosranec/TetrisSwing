package mainGame;

import java.awt.*;

public abstract class FigureAdapter implements Figure {
    protected int workWidth;
    protected int workHeight;
    protected Cell[][] cells;
    protected Color color;

    //need to initialize color, workWidth, workHeight and cells
    @Override
    public void initFigure(int widthBoard, int heightBoard, int wWidth, int wHeight) {
        //create random color
        color = Figure.randomColor();
        //make figure
        workWidth = wWidth;
        workHeight = wHeight;
        cells = new Cell[workWidth][workHeight];
        //initial cells
        for (int i = 0; i < workWidth; i++) {
            for (int j = 0; j < workHeight; j++) {
                cells[i][j] = new Cell(false,  color, j + (widthBoard - workWidth) / 2, i-(workHeight - 1));
            }
        }
    }

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

                cells[i][j].setxBoard(cells[i][j].getxBoard() + type);
                //check figure to display
                if (cells[i][j].isVisible()){
                    if((cells[i][j].getxBoard() < cellsBoard.length)
                            && (cells[i][j].getxBoard() > -1)
                            && (cells[i][j].getyBoard() < cellsBoard[i].length)) {
                        if ((cells[i][j].getyBoard() > -1)) {
                            if (!cellsBoard[cells[i][j].getxBoard()][cells[i][j].getyBoard()].isVisible()) {
                                continue;
                            }
                        }
                        else continue;
                    }
                    //if have mistake
                    good = true;
                }
            }
        }
        //if new figure is impossible, use copy figure
        if (good){
            for (int i = 0; i < workWidth; i++) {
                for (int j = 0; j < workHeight; j++) {
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
                boolean visible = cells[i][j].isVisible();

                cells[i][j].setxBoard(cells[j][workWidth-1-i].getxBoard());
                cells[i][j].setyBoard(cells[j][workWidth-1-i].getyBoard());
                //cells[i][j].setVisible(cells[j][workWidth-1-i].isVisible());

                cells[j][workWidth-1-i].setxBoard(cells[workWidth-1-i][workWidth-1-j].getxBoard());
                cells[j][workWidth-1-i].setyBoard(cells[workWidth-1-i][workWidth-1-j].getyBoard());
                //cells[j][workWidth-1-i].setVisible(cells[workWidth-1-i][workWidth-1-j].isVisible());

                cells[workWidth-1-i][workWidth-1-j].setxBoard(cells[workWidth-1-j][i].getxBoard());
                cells[workWidth-1-i][workWidth-1-j].setyBoard(cells[workWidth-1-j][i].getyBoard());
                //cells[workWidth-1-i][workWidth-1-j].setVisible(cells[workWidth-1-j][i].isVisible());

                cells[workWidth-1-j][i].setxBoard(x);
                cells[workWidth-1-j][i].setyBoard(y);
                //cells[workWidth-1-j][i].setVisible(visible);
            }
        }
        //check figure to display
        T:
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].isVisible()) {
                    //for moving figure left, if it don't can be on board
                    if (cells[i][j].getxBoard() > cellsBoard.length - 1) {
                        int maxLeft = 0;
                        for (int k = 0; k < cells.length; k++) {
                            for (int l = 0; l < cells[k].length; l++) {
                                if (cells[k][l].isVisible() && (cells[k][l].getxBoard() > maxLeft)) {
                                    maxLeft = cells[k][l].getxBoard();
                                }
                            }
                        }
                        rightAndLeft(cellsBoard, (cellsBoard.length - 1) - maxLeft);
                    }
                    //for moving figure right, if it don't can be on board
                    if (cells[i][j].getxBoard() < 0 ) {
                        int minRight = 0;
                        for (int k = 0; k < cells.length; k++) {
                            for (int l = 0; l < cells[k].length; l++) {
                                if (cells[k][l].isVisible() && (cells[k][l].getxBoard() < minRight)) {
                                    minRight = cells[k][l].getxBoard();
                                }
                            }
                        }
                        rightAndLeft(cellsBoard, 0 - minRight);
                    }
                    //end check for draw
                    if ((cells[i][j].getxBoard() < cellsBoard.length)
                            && (cells[i][j].getxBoard() > -1)
                            && (cells[i][j].getyBoard() < cellsBoard[i].length)) {
                        if (cells[i][j].getyBoard() > -1) {
                            if (!cellsBoard[cells[i][j].getxBoard()][cells[i][j].getyBoard()].isVisible()) {
                                continue;
                            }
                        }
                        else continue;
                    }
                    //if have mistake
                    good = true;
                    break T;
                }
            }
        }
        //if new figure is impossible, use copy figure
        if (good){
            for (int i = 0; i < workWidth; i++) {
                for (int j = 0; j < workHeight; j++) {
                    cells[i][j] = oldCells[i][j];
                }
            }
        }
    }

    @Override
    public Cell[][] getCells() {
        return cells;
    }

    protected void randomStartPosition(Cell[][] cellsBoard, int randomPosition){
        randomPosition = (int)(System.currentTimeMillis() % randomPosition);
        while(randomPosition-- > 0){
            next(cellsBoard);
        }
    }
}
