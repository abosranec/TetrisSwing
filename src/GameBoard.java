import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {
    private int x;
    private int y;
    private int width;
    private int height;
    private int indent;
    public GameBoard(int x, int y, int width, int height, int indent) {
        super(null);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.indent = indent;
        setBounds(x, y, width, height);
        setBackground(new Color(100,0,0));
    }
}
