package mainGame;

//*##
//##*
//***
public class SFigure extends FigureAdapter {
    public SFigure(Cell[][] cellsBoard) {
        //create figure
        initFigure(cellsBoard.length, cellsBoard[0].length, 3, 3);
        //visible figure
        cells[0][1].setVisible(true);
        cells[0][2].setVisible(true);
        cells[1][0].setVisible(true);
        cells[1][1].setVisible(true);
        //random starting position
        randomStartPosition(cellsBoard, 2);
    }
}
