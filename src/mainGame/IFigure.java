package mainGame;

//****
//####
//****
//****
public class IFigure extends FigureAdapter {
    public IFigure(Cell[][] cellsBoard) {
        //create figure
        initFigure(cellsBoard.length, cellsBoard[0].length, 4, 4);
        //visible figure
        cells[1][0].setVisible(true);
        cells[1][1].setVisible(true);
        cells[1][2].setVisible(true);
        cells[1][3].setVisible(true);
        //random starting position
        randomStartPosition(cellsBoard, 2);
    }
}
