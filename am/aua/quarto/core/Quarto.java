package am.aua.quarto.core;

import am.aua.quarto.core.figures.*;
import am.aua.quarto.core.player.ComputerPlayer;
import am.aua.quarto.core.player.HumanPlayer;
import am.aua.quarto.core.player.Player;

public class Quarto {
    public static final int BOARD_LENGTH = 4;
    public static final int BOARD_HEIGHT = 4;
    private static Figure EMPTY = null;

    private Puttable[][] board;
    private int counter;
    private Figure[] figures;
    private Player p1;
    private Player p2;


    public Quarto (){

        this.counter = 0;
        this.board = new Figure[BOARD_LENGTH][BOARD_HEIGHT];

        // creation of the static figures
        Figure WTRS = new Figure(Figure.Color.WHITE, Figure.Height.TALL, Figure.Shape.ROUND, Figure.Form.SOLID);
        Figure WTRH = new Figure(Figure.Color.WHITE, Figure.Height.TALL, Figure.Shape.ROUND, Figure.Form.HOLLOW);
        Figure WTSS = new Figure(Figure.Color.WHITE, Figure.Height.TALL, Figure.Shape.SQUARE, Figure.Form.SOLID);
        Figure WTSH = new Figure(Figure.Color.WHITE, Figure.Height.TALL, Figure.Shape.SQUARE, Figure.Form.HOLLOW);

        Figure WSRS = new Figure(Figure.Color.WHITE, Figure.Height.SHORT, Figure.Shape.ROUND, Figure.Form.SOLID);
        Figure WSRH = new Figure(Figure.Color.WHITE, Figure.Height.SHORT, Figure.Shape.ROUND, Figure.Form.HOLLOW);
        Figure WSSS = new Figure(Figure.Color.WHITE, Figure.Height.SHORT, Figure.Shape.SQUARE, Figure.Form.SOLID);
        Figure WSSH = new Figure(Figure.Color.WHITE, Figure.Height.SHORT, Figure.Shape.SQUARE, Figure.Form.HOLLOW);

        Figure BTRS = new Figure(Figure.Color.BLACK, Figure.Height.TALL, Figure.Shape.ROUND, Figure.Form.SOLID);
        Figure BTRH = new Figure(Figure.Color.BLACK, Figure.Height.TALL, Figure.Shape.ROUND, Figure.Form.HOLLOW);
        Figure BTSS = new Figure(Figure.Color.BLACK, Figure.Height.TALL, Figure.Shape.SQUARE, Figure.Form.SOLID);
        Figure BTSH = new Figure(Figure.Color.BLACK, Figure.Height.TALL, Figure.Shape.SQUARE, Figure.Form.HOLLOW);

        Figure BSRS = new Figure(Figure.Color.BLACK, Figure.Height.SHORT, Figure.Shape.ROUND, Figure.Form.SOLID);
        Figure BSRH = new Figure(Figure.Color.BLACK, Figure.Height.SHORT, Figure.Shape.ROUND, Figure.Form.HOLLOW);
        Figure BSSS = new Figure(Figure.Color.BLACK, Figure.Height.SHORT, Figure.Shape.SQUARE, Figure.Form.SOLID);
        Figure BSSH = new Figure(Figure.Color.BLACK, Figure.Height.SHORT, Figure.Shape.SQUARE, Figure.Form.HOLLOW);

        this.figures = new Figure[]{WTRS, WTRH, WTSS, WTSH, WSRS, WSRH, WSSS, WSSH, BTRS, BTRH, BTSS, BTSH, BSRS, BSRH, BSSS, BSSH};

        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                if (i == 3 && j == 1)
                    continue;
                this.board[i][j] = EMPTY;
            }
        }

    }

    public Figure[][] getBoard(){
        Figure[][] board = new Figure[BOARD_LENGTH][BOARD_HEIGHT];
        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                Figure current = (Figure) this.board[i][j];
                if(board[i][j] != null)
                    board[i][j] = current.clone();
            }
        }
        return board;
    }


    public int getTurn(){
        return counter%2;
    }

    public int getCounter(){
        return this.counter;
    }

    public Figure[] getFigures(){
        Figure[] copy = new Figure[figures.length];
        for (int i = 0; i < copy.length; i++) {
            if (figures[i] != null) {
                copy[i] = figures[i].clone();
            }

        }
        return copy;
    }

    public Player getP1(){
        return p1;
    }

    public Player getP2(){
        return p2;
    }

    public void setP1(String name){
        p1 = new HumanPlayer(name);
    }

    public void setP2(String name){
       if(name != "Computer"){
           p2 = new HumanPlayer(name);
       }
       else {
           p2 = new ComputerPlayer();
       }
    }

    public boolean isGameOver(){
        return false;
    }

    public boolean isEmpty(Position p){
        return this.board[p.getRow()][p.getColumn()] == null;
    }

    private Figure getPieceAt(Position p){
        return (Figure) this.board[p.getRow()][p.getColumn()];
    }

    public Figure takeFigure(int index){
        Figure f = null;
        if(figures[index] != null) {
            f = this.figures[index];
        }
        this.figures[index] = null;
        return f;
    }

     public boolean performPut (Position p, Figure f){
        if(this.getPieceAt(p) == null && f != null){
            this.board[p.getRow()][p.getColumn()] = f;
            counter++;
            return true;
        }
        return false;
    }


}
