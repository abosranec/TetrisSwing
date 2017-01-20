package mainGame;

//   ##
//   ##
public class OFigure extends FigureAdapter {
    public OFigure(int widthBoard, int heightBoard) {
        initFigure(widthBoard, heightBoard);
    }

    //need to initialize color, workWidth, workHeight and cells
    @Override
    public void initFigure(int widthBoard, int heightBoard) {
        //create random color
        color = Figure.randomColor();
        //make figure
        workWidth = 2;
        workHeight = 2;
        cells = new Cell[workWidth][workHeight];
        //*#
        //##
        cells[0][0] = new Cell(true, color, (widthBoard - workWidth) / 2, -1);
        //#*
        //##
        cells[0][1] = new Cell(true, color, 1 + (widthBoard - workWidth) / 2, -1);
        //##
        //*#
        cells[1][0] = new Cell(true, color, (widthBoard - workWidth) / 2, 0);
        //##
        //#*
        cells[1][1] = new Cell(true, color, 1 + (widthBoard - workWidth) / 2, 0);
    }
}
