package mainGame;

//*****
//*****
//####*
//*****
//*****
public class IFigure extends FigureAdapter {
    public IFigure(Cell[][] cellsBoard) {
        //create figure
        initFigure(cellsBoard.length, cellsBoard[0].length, 5, 5);
        //visible figure
        cells[2][0].setVisible(true);
        cells[2][1].setVisible(true);
        cells[2][2].setVisible(true);
        cells[2][3].setVisible(true);
        //random starting position
        randomStartPosition(cellsBoard, 2);
    }
}
