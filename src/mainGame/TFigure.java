package mainGame;

//###
//*#*
//***
public class TFigure extends FigureAdapter {
    public TFigure(Cell[][] cellsBoardd) {
        //create figure
        initFigure(cellsBoardd.length, cellsBoardd[0].length, 3, 3);
        //visible figure
        //###
        //*#*
        //***
        cells[0][0].setVisible(true);
        cells[0][1].setVisible(true);
        cells[0][2].setVisible(true);
        cells[1][1].setVisible(true);
        //random starting position
        randomStartPosition(cellsBoardd);
    }
}
