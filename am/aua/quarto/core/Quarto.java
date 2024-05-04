package am.aua.quarto.core;

import am.aua.quarto.core.cards.Card;
import am.aua.quarto.core.figures.*;
import am.aua.quarto.core.player.*;

public class Quarto {
    public static final int BOARD_LENGTH = 4;
    public static final int BOARD_HEIGHT = 4;
    public static final int MAX_RANDOM_CARD_NUMBER = 4;
    private static final Figure EMPTY = null;

    private Position lastPosition;

    private SpecialFigure[] shop;
    private Puttable[][] board;
    private int counter;
    private ActualFigure[] figures;
    private HumanPlayer p1;
    private Player p2;


    public Quarto (){

        this.counter = 0;
        this.board = new Figure[BOARD_LENGTH][BOARD_HEIGHT];

        // creation of the static figures
        ActualFigure WTRS = new ActualFigure(Figure.Color.WHITE, Figure.Height.TALL, Figure.Shape.ROUND, Figure.Form.SOLID);
        ActualFigure WTRH = new ActualFigure(Figure.Color.WHITE, Figure.Height.TALL, Figure.Shape.ROUND, Figure.Form.HOLLOW);
        ActualFigure WTSS = new ActualFigure(Figure.Color.WHITE, Figure.Height.TALL, Figure.Shape.SQUARE, Figure.Form.SOLID);
        ActualFigure WTSH = new ActualFigure(Figure.Color.WHITE, Figure.Height.TALL, Figure.Shape.SQUARE, Figure.Form.HOLLOW);

        ActualFigure WSRS = new ActualFigure(Figure.Color.WHITE, Figure.Height.SHORT, Figure.Shape.ROUND, Figure.Form.SOLID);
        ActualFigure WSRH = new ActualFigure(Figure.Color.WHITE, Figure.Height.SHORT, Figure.Shape.ROUND, Figure.Form.HOLLOW);
        ActualFigure WSSS = new ActualFigure(Figure.Color.WHITE, Figure.Height.SHORT, Figure.Shape.SQUARE, Figure.Form.SOLID);
        ActualFigure WSSH = new ActualFigure(Figure.Color.WHITE, Figure.Height.SHORT, Figure.Shape.SQUARE, Figure.Form.HOLLOW);

        ActualFigure BTRS = new ActualFigure(Figure.Color.BLACK, Figure.Height.TALL, Figure.Shape.ROUND, Figure.Form.SOLID);
        ActualFigure BTRH = new ActualFigure(Figure.Color.BLACK, Figure.Height.TALL, Figure.Shape.ROUND, Figure.Form.HOLLOW);
        ActualFigure BTSS = new ActualFigure(Figure.Color.BLACK, Figure.Height.TALL, Figure.Shape.SQUARE, Figure.Form.SOLID);
        ActualFigure BTSH = new ActualFigure(Figure.Color.BLACK, Figure.Height.TALL, Figure.Shape.SQUARE, Figure.Form.HOLLOW);

        ActualFigure BSRS = new ActualFigure(Figure.Color.BLACK, Figure.Height.SHORT, Figure.Shape.ROUND, Figure.Form.SOLID);
        ActualFigure BSRH = new ActualFigure(Figure.Color.BLACK, Figure.Height.SHORT, Figure.Shape.ROUND, Figure.Form.HOLLOW);
        ActualFigure BSSS = new ActualFigure(Figure.Color.BLACK, Figure.Height.SHORT, Figure.Shape.SQUARE, Figure.Form.SOLID);
        ActualFigure BSSH = new ActualFigure(Figure.Color.BLACK, Figure.Height.SHORT, Figure.Shape.SQUARE, Figure.Form.HOLLOW);

        this.figures = new ActualFigure[]{WTRS, WTRH, WTSS, WTSH, WSRS, WSRH, WSSS, WSSH, BTRS, BTRH, BTSS, BTSH, BSRS, BSRH, BSSS, BSSH};

        for (int i = 0; i < MAX_RANDOM_CARD_NUMBER; i++) {
            int randomRow = (int) Math.floor(Math.random()*MAX_RANDOM_CARD_NUMBER);
            int randomColumn = (int) Math.floor(Math.random()*MAX_RANDOM_CARD_NUMBER);
//            board[randomRow][randomColumn] = new Card("Message", 100); // needs to be changed by a random card
        }

//        shop = new SpecialFigure[5];
//        for (int i = 0; i < 5; i++) {
//            int index = (int)(Math.random()*10)+1;
//            shop[i] = SpecialFigure.specialFigures[index];
//        }
    }

    public Puttable[][] getBoard(){ // change when cards are added
        Puttable[][] newBoard = new Puttable[BOARD_LENGTH][BOARD_HEIGHT];
        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {

                if(this.board[i][j] != null)
                    newBoard[i][j] = this.board[i][j].clone();
                // add condition for cards
            }
        }
        return newBoard;
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
            if(figures[i] == null)
                    copy[i] = null;
            else  {
                copy[i] = figures[i].clone();
            }
        }
        return copy;
    }

    public void setCounter(int counter){
        this.counter = counter;
    }

    public Player getP1(){
        return p1.clone();
    }

    public Player getP2(){
        return p2.clone();
    }

    public void setP1(String name){
        p1 = new HumanPlayer(name);
    }

    public void setP2(String name){
       if(!name.equalsIgnoreCase("computer")){
           p2 = new HumanPlayer(name);
       }
       else {
           p2 = new ComputerPlayer();
       }
    }

    public boolean isGameOver(){

//        if(this.lastPosition==null){
//            return false;
//        }
//
//        int[] rowOffsets = {0, 1, 1, -1};
//        int[] columnOffsets = {1, 0, 1, 1};
//
//        for (int k = 0; k < rowOffsets.length; k++) {
//            Position[] positions = new Position[3];
//            int i = 0;
//            int rowValue = rowOffsets[k];
//            int columnValue = columnOffsets[k];
//            int r = this.lastPosition.getRow();
//            int c = this.lastPosition.getColumn();
//
//            if(k == 2 && r != c)
//                return false;
//            if(k == 3 && r + c != BOARD_LENGTH -1)
//                return false;
//
//
//            while (r < BOARD_HEIGHT && c < BOARD_LENGTH){
//                Position addedPosition = new Position(r + rowValue, c + columnValue);
//                positions[i] = addedPosition;
//                r += rowValue;
//                c+= columnValue;
//                i++;
//            }
//
//            r = this.lastPosition.getRow();
//            c = this.lastPosition.getColumn();
//
//            while (r >= 0 && c >= 0){
//                Position addedPosition = new Position(r - rowValue, c - columnValue);
//                positions[i] = addedPosition;
//                r -= rowValue;
//                c-= columnValue;
//                i++;
//            }
////            for (int i = 1; i < 4; i++) {
////
////                if ((k == 2 && this.lastPosition.getRow() == this.lastPosition.getColumn()) ||
////                        (k == 3 && this.lastPosition.getRow() + this.lastPosition.getColumn() == BOARD_LENGTH)) {
////                    Position addedPosition1 = new Position(this.lastPosition.getRow() + rowValue * i, this.lastPosition.getColumn() + columnValue * i);
////                    Position addedPosition2 = new Position(this.lastPosition.getRow() - rankValue * i, this.lastPosition.getColumn() - columnValue * i);
////                    if(addedPosition1!=null) {
////                        positions.add(addedPosition1);
////                    }
////                    if(addedPosition2!=null){
////                        positions.add(addedPosition2);
////                    }
////
////                }
////
////            }
//
////            System.out.println(positions.size());
//            if (isSameByPositions(positions)) {
//                return true;
//            }
//            positions = new Position[3];
//        }

        return false;
    }

    public boolean isFigure(Position p){
        return board[p.getRow()][p.getColumn()] instanceof Figure;
    }

    public boolean isEmpty(Position p){
        return !(isFigure(p));
    }

    private Figure getPieceAt(Position p){
        if(isEmpty(p))
            return  null;
        return (Figure) this.board[p.getRow()][p.getColumn()];
    }

    public Figure takeFigure(int index){
        Figure f = null;
        if(figures[index] != null) {
            f = this.figures[index].clone();
        }
        this.figures[index] = null;
        return f;
    }

     public boolean performPut (Position p, Figure f){
        if(this.getPieceAt(p) == null && f != null){
            this.board[p.getRow()][p.getColumn()] = f;
            lastPosition = p;
            counter++;
            return true;
        }

        return false;
    }
    private boolean isSameByPositions(Position[] positions){
        Puttable[][] copyBoard = this.getBoard();
        Figure cur = (Figure) copyBoard[this.lastPosition.getRow()][this.lastPosition.getColumn()];
        for (int i = 0; i < 4; i++) {
            Figure f = (Figure) copyBoard[positions[i].getRow()][positions[i].getColumn()];
            boolean isWin = cur.isSameColor(f) || cur.isSameHeight(f) || cur.isSameForm(f) || cur.isSameShape(f);
            if(isWin)
                return true;
        }
        return false;
    }
    public boolean buy(int index){
        if(p1.getPoints()>=shop[index].getPrice()){
            p1.setSpecialFigure(shop[index]);
            p1.setPoints(p1.getPoints()-shop[index].getPrice());
            return true;
        }
        return false;
    }
}