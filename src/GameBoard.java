import mainGame.Cell;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {
    private int indentCell = 2; //between cell
    private int widthCell; //width cell
    private int heightCell; //height cell
    private Cell[][] gridLayout= new Cell[10][20];
    private Icon imageIcon = new ImageIcon("image\\cat.jpg");
    public GameBoard(int x, int y, int width, int height) {
        setLayout(null);
        setBounds(x, y, width, height);
        setBackground(new Color(100,0,0));
        widthCell = (getWidth() - indentCell * (gridLayout.length + 1)) / gridLayout.length;
        heightCell = widthCell;
        System.out.println(width);
        System.out.println(widthCell);
        System.out.println(heightCell);
        createCell();
    }

    private void createCell(){
        int count = 0;
        for (int i = 0; i < gridLayout.length; i++) {
            for (int j = 0; j < gridLayout[0].length; j++) {
                gridLayout[i][j] = new Cell(imageIcon,
                        (i+1)*indentCell + i * widthCell,
                        (j+1)*indentCell + j * heightCell,
                        widthCell, heightCell);
                System.out.println(((i+1)*indentCell + i * widthCell) + "//" + ((j+1)*indentCell + j * heightCell));
                add(gridLayout[i][j]);
                count++;
            }
        }
        System.out.println(count);
    }
}
