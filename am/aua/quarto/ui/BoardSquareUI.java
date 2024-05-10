package am.aua.quarto.ui;

import javax.swing.*;
import java.awt.*;

public class BoardSquareUI extends JButton {

    public static final Color LIGHT_COLOR = Color.WHITE;
    public static final Color DARK_COLOR = new Color(65, 104, 134, 255);

    private int x;
    private int y;
    private Color color;

    public BoardSquareUI(){
        setBackground(LIGHT_COLOR);
    }
    public BoardSquareUI (int x, int y, boolean isLight){
        this.x = x;
        this.y = y;
        setBackground(this.color = isLight? LIGHT_COLOR : DARK_COLOR);
    }

    public int[] getCoordinates(){
        return new int[]{x, y};
    }


    public void setPiece(String s){
        Icon icon = null;
        icon = new ImageIcon("src/pieces/"+s+".png");
        setIcon(icon);

    }



    public void setPiece(){
        setIcon(null);
    }

}
