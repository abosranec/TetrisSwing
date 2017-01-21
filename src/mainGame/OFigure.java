package mainGame;

//   ##
//   ##
public class OFigure extends FigureAdapter {
    public OFigure(Cell[][] cellsBoard) {
        //create figure
        initFigure(cellsBoard.length, cellsBoard[0].length, 2, 2);
        //visible figure
        cells[0][0].setVisible(true);
        cells[0][1].setVisible(true);
        cells[1][0].setVisible(true);
        cells[1][1].setVisible(true);
    }
}
