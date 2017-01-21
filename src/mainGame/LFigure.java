package mainGame;

//***
//###
//#**
public class LFigure extends FigureAdapter{
    public LFigure(Cell[][] cellsBoard) {
        //create figure
        initFigure(cellsBoard.length, cellsBoard[0].length, 3, 3);
        //visible figure
        cells[1][0].setVisible(true);
        cells[1][1].setVisible(true);
        cells[1][2].setVisible(true);
        cells[2][0].setVisible(true);
        //random starting position
        randomStartPosition(cellsBoard, 4);
    }
}
