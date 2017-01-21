package mainGame;

//###
//*#*
//***
public class TFigure extends FigureAdapter {
    public TFigure(int widthBoard, int heightBoard) {
        initFigure(widthBoard, heightBoard);
    }

    //need to initialize color, workWidth, workHeight and cells
    @Override
    public void initFigure(int widthBoard, int heightBoard) {
        //create random color
        color = Figure.randomColor();
        //make figure
        workWidth = 3;
        workHeight = 3;
        cells = new Cell[workWidth][workHeight];
        //initial cells
        for (int i = 0; i < workWidth; i++) {
            for (int j = 0; j < workHeight; j++) {
                cells[i][j] = new Cell(false,  color, j + (widthBoard - workWidth) / 2, i-1);
            }
        }
        //visible figure
        //###
        //*#*
        cells[0][0].setVisible(true);
        //###
        //*#*
        cells[0][1].setVisible(true);
        //###
        //*#*
        cells[0][2].setVisible(true);
        //###
        //*#*
        cells[1][1].setVisible(true);
    }
}
