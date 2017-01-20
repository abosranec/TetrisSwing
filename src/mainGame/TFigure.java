package mainGame;

import java.awt.*;

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
        //###
        //*#*
        cells[0][0] = new Cell(true,  new Color(0,250,0), (widthBoard - workWidth) / 2, -1);
        //###
        //*#*
        cells[0][1] = new Cell(true,  new Color(250,0,250), 1 + (widthBoard - workWidth) / 2, -1);
        //###
        //*#*
        cells[0][2] = new Cell(true, new Color(250,0,0), 2 + (widthBoard - workWidth) / 2, -1);
        //###
        //*#*
        cells[1][1] = new Cell(true, color, 1 + (widthBoard - workWidth) / 2, 0);




        cells[1][0] = new Cell(false, color, (widthBoard - workWidth) / 2, 0);
        cells[1][2] = new Cell(false, color, 2 + (widthBoard - workWidth) / 2, 0);

        cells[2][0] = new Cell(false, color, (widthBoard - workWidth) / 2, 1);
        cells[2][1] = new Cell(false, color, 1 + (widthBoard - workWidth) / 2, 1);
        cells[2][2] = new Cell(false, new Color(250,0,0), 2 + (widthBoard - workWidth) / 2, 1);

//        for (int i = 0; i < workWidth; i++) {
//            for (int j = 0; j < workHeight; j++) {
//                if (cells[i][j] == null){
//                    cells[i][j] = new Cell(false, color, 0, 0);
//                }
//            }
//        }
    }
}
