package am.aua.quarto.core;

import am.aua.quarto.core.cards.Card;
import am.aua.quarto.core.figures.*;
import am.aua.quarto.core.player.*;

public class Quarto {
    public static final int BOARD_LENGTH = 4;
    public static final int BOARD_HEIGHT = 4;
    public static final int MAX_RANDOM_CARD_NUMBER = 4;

    private Position lastPosition;

    private SpecialFigure[] shop;
    private Puttable[][] board;
    private int counter;
    private ActualFigure[] figures;
    private HumanPlayer p1;
    private Player p2;


    public Quarto (String name1, String input){

        this.counter = 0;
        this.board = new Figure[BOARD_LENGTH][BOARD_HEIGHT];
        this.p1 = new HumanPlayer(name1);

        p1 = new HumanPlayer(name1);
        setP2(input);

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


    public boolean getTurn(){
        return counter%2==0;
    }

    public void setCounter(int counter){
        this.counter = counter;
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

    public Player getPlayer(boolean player){
        if(player){
            return this.p1.clone();
        }
        else{
            return this.p2.clone();
        }
    }

    private void setP2(String input){
       if(input.equalsIgnoreCase("easy")){
           p2 = new ComputerPlayer("EASY");
       }
       else if (input.equalsIgnoreCase("medium")){
            p2 = new ComputerPlayer("MEDIUM");
       }
       else if (input.equalsIgnoreCase("hard")){
            p2 = new ComputerPlayer("HARD");
       }
       else {
           p2 = new HumanPlayer(input);
       }
    }

    public boolean isGameOver(){

        if(this.lastPosition==null){
            return false;
        }

        int[] rowOffsets = {0, 1, 1, -1};
        int[] columnOffsets = {1, 0, 1, 1};

        for (int k = 0; k < rowOffsets.length; k++) {
            Position[] positions = new Position[3];

            int i = 0;
            int rowValue = rowOffsets[k];
            int columnValue = columnOffsets[k];
            int r = this.lastPosition.getRow();
            int c = this.lastPosition.getColumn();

            if(k == 2 && r != c)
                return false;
            if(k == 3 && r + c != BOARD_LENGTH -1)
                return false;


            r += rowValue;
            c+= columnValue;
            while (r < BOARD_HEIGHT && c < BOARD_LENGTH){
                Position addedPosition = new Position(r, c); // (r + rowValue, c + columnValue)
                positions[i] = addedPosition;
                r += rowValue;
                c+= columnValue;
                i++;
            }

            r = this.lastPosition.getRow();
            c = this.lastPosition.getColumn();

            r -= rowValue;
            c-= columnValue;
            while (r >= 0 && c >= 0){
                Position addedPosition = new Position(r, c); // (r - rowValue, c - columnValue)
                positions[i] = addedPosition;
                r -= rowValue;
                c-= columnValue;
                i++;
            }

            if (isSameByPositions(positions)) {
                System.out.println("k == " + k);
                return true;
            }
        }

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
    /*
    private boolean isSameByPositions(Position[] positions){
        Puttable[][] copyBoard = this.getBoard();
        Figure cur = (Figure) copyBoard[this.lastPosition.getRow()][this.lastPosition.getColumn()];
        for (int i = 0; i < 4; i++) {
            Figure f = (Figure) copyBoard[positions[i].getRow()][positions[i].getColumn()];
            if(f == null)
                continue;
            boolean isWin = cur.isSameColor(f) || cur.isSameHeight(f) || cur.isSameForm(f) || cur.isSameShape(f);
            if(isWin)
                return true;
        }
        return false;
    }

     */

    public boolean isSameByPositions(Position[] positions){
        for (int i = 0; i < positions.length; i++) {
            System.out.print("positions are " + positions[i] + " ");
        }
        System.out.println();
        Puttable[][] copyBoard = this.getBoard();
        Figure f = (Figure) copyBoard[this.lastPosition.getRow()][this.lastPosition.getColumn()];
        if (f == null){
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (f.isSameByCharacteristic(i, (Figure) copyBoard[positions[0].getRow()][positions[0].getColumn()]) &&
                    f.isSameByCharacteristic(i, (Figure) copyBoard[positions[1].getRow()][positions[1].getColumn()]) &&
                    f.isSameByCharacteristic(i, (Figure) copyBoard[positions[2].getRow()][positions[2].getColumn()])){
                System.out.println("characteristic is " + i);
                return true;
            }
        }
        return false;
    }


    /*
    public SpecialFigure buyFromShop(Player p){
        if(p.getPoints()>=SpecialFigure.PRICE){
            p.setPoints(p1.getPoints()-SpecialFigure.PRICE);
            return SpecialFigure.specialFigures[(int)(Math.random()*10)+1];
        }
        return null;
    }

     */
}