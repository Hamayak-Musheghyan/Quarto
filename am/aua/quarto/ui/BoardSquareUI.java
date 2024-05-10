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
        switch (s){
            case "BSRH":
                icon = new ImageIcon("src/pieces/BSRH.png");
                break;
            case "BSRS":
                icon = new ImageIcon("src/pieces/BSRS.png");
                break;
            case "BSSH":
                icon = new ImageIcon("src/pieces/BSSH.png");
                break;
            case "BSSS":
                icon = new ImageIcon("src/pieces/BSSS.png");
                break;
            case "BTRS":
                icon = new ImageIcon("src/pieces/BTRS.png");
                break;
            case "BTRH":
                icon = new ImageIcon("src/pieces/BTRH.png");
                break;
            case "BTSH":
                icon = new ImageIcon("src/pieces/BTSH.png");
                break;
            case "BTSS":
                icon = new ImageIcon("src/pieces/BTSS.png");
                break;
            case "WSRH":
                icon = new ImageIcon("src/pieces/WSRH.png");
                break;
            case "WSRS":
                icon = new ImageIcon("src/pieces/WSRS.png");
                break;
            case "WSSH":
                icon = new ImageIcon("src/pieces/WSSH.png");
                break;
            case "WSSS":
                icon = new ImageIcon("src\\pieces\\WSSS.png");
                break;
            case "WTRH":
                icon = new ImageIcon("src\\pieces\\WTRH.png");
                break;
            case "WTRS":
                icon = new ImageIcon("src\\pieces\\WTRS.png");
                break;
            case "WTSH":
                icon = new ImageIcon("src\\pieces\\WTSH.png");
                break;
            case "WTSS":
                icon = new ImageIcon("src\\pieces\\WTSS.png");
                break;
        }
        setIcon(icon);
    }





    public void setPiece(){
        setIcon(null);
    }

}
