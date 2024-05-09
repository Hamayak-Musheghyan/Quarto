package am.aua.quarto.core;

import am.aua.quarto.core.cards.Card;
import am.aua.quarto.core.figures.*;
import am.aua.quarto.core.players.*;

public class Quarto implements Cloneable{

    // static variables
    public static final int BOARD_LENGTH = 4;
    public static final int BOARD_HEIGHT = 4;
    public static final int MAX_RANDOM_CARD_NUMBER = 4;

    // instance variables
    private Position lastPosition;
    private Puttable[][] board;
    private int counter;
    private boolean turn;
    private ActualFigure[] figures;
    private HumanPlayer p1;
    private Player p2;


    // the only constructor
    public Quarto (String name, String input){

        // initialises instance variables to default values
        this.counter = 0;
        this.turn = false;
        this.board = new Puttable[BOARD_LENGTH][BOARD_HEIGHT];

        // sets players
        try {
            this.p1 = new HumanPlayer(name);
            if (input.equalsIgnoreCase("easy")) {
                p2 = new EasyComputerPlayer();
            } else if (input.equalsIgnoreCase("medium")) {
                p2 = new MediumComputerPlayer();
            }
//            } else if (input.equalsIgnoreCase("hard")) {
//                p2 = new HardComputerPlayer();
//            }
            else {
                p2 = new HumanPlayer(input);
            }
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }

        // creation of the static figures
        this.figures = new ActualFigure[16];
        for (int i = 0; i < ActualFigure.actualFigures.length; i++) {
            figures[i] = ActualFigure.actualFigures[i].clone();
        }

        // random creation of cards
        for (int i = 0; i < MAX_RANDOM_CARD_NUMBER; i++) {
            int randomRow = (int) (Math.random() * 4);
            int randomColumn = (int) (Math.random() * 4);
            board[randomRow][randomColumn] = new Card("This is a card", 100);
        }

    }

    public Puttable[][] getBoard(){
        Puttable[][] newBoard = new Puttable[BOARD_LENGTH][BOARD_HEIGHT];
        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                if(this.board[i][j] != null)
                    newBoard[i][j] = this.board[i][j].clone();
            }
        }
        return newBoard;
    }

    public boolean getTurn(){
        return this.turn;
    }


    public ActualFigure[] getFigures(){
        ActualFigure[] copy = new ActualFigure[figures.length];
        for (int i = 0; i < copy.length; i++) {
            if(figures[i] == null)
                    copy[i] = null;
            else  {
                copy[i] = figures[i].clone();
            }
        }
        return copy;
    }

    public void setFigureToNull(int i){
        this.figures[i] = null;
    }

    public Player getPlayer(boolean turn){
        if(turn){
            return this.p1;
        }
        else{
            return this.p2;
        }
    }

    public boolean isDraw(){
        if(this.counter >= 16)
            return true;
        return false;
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

            if (k == 2 && r != c)
                continue;
            if (k == 3 && (r + c) != BOARD_HEIGHT - 1) {
                continue;
            }


            r -= rowValue;
            c -= columnValue;
            while (r >= 0 && c >= 0){
                Position addedPosition = new Position(r, c);
                positions[i] = addedPosition;
                r -= rowValue;
                c -= columnValue;
                i++;
            }

            r = this.lastPosition.getRow();
            c = this.lastPosition.getColumn();

            r += rowValue;
            c += columnValue;
            while (r < BOARD_HEIGHT && c < BOARD_LENGTH){
                Position addedPosition = new Position(r, c);
                positions[i] = addedPosition;
                r += rowValue;
                c += columnValue;
                i++;
            }

            if (isSameByPositions(positions)) {
                return true;
            }
        }

        return false;
    }

    public boolean isSameByPositions(Position[] positions){
        Puttable[][] copyBoard = this.getBoard();
        Figure f = (Figure) copyBoard[this.lastPosition.getRow()][this.lastPosition.getColumn()];
        if (f == null){
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (f.isSameByCharacteristic(i, this.getFigureAt(positions[0])) &&
                    f.isSameByCharacteristic(i, this.getFigureAt(positions[1])) &&
                    f.isSameByCharacteristic(i, this.getFigureAt(positions[2]))) {
                return true;
            }
        }
        return false;
    }

    public boolean isFigure(Position p){
        if(p != null)
            return board[p.getRow()][p.getColumn()] instanceof Figure;
        return false;
    }

    public boolean isEmpty(Position p){
        return !(isFigure(p));
    }

    public Figure getFigureAt(Position p){
        if(isEmpty(p))
            return  null;
        return (Figure) this.board[p.getRow()][p.getColumn()];
    }

    public Card getCardAt(Position p){
        if(this.board[p.getRow()][p.getColumn()] instanceof Card)
            return ((Card) this.board[p.getRow()][p.getColumn()]).clone();
        return null;
    }

    public ActualFigure takeFigure(int index){
        ActualFigure f = null;
        if(figures[index] != null) {
            f = this.figures[index].clone();
        }
        this.figures[index] = null;
        return f;
    }

    public boolean performPut (Position p, Figure f){

        if(this.getCardAt(p) != null){
            this.getPlayer(getTurn()).setPoints(this.getCardAt(p).getPoint());
        }

        if(this.isEmpty(p) && f != null){
            this.board[p.getRow()][p.getColumn()] = f;
            lastPosition = p;
            counter++;
            turn = !turn;
            return true;
        }

        return false;
    }

    public void setBoard(Position p, Figure f){
        if(this.isEmpty(p)){
            this.board[p.getRow()][p.getColumn()] = f;
        }
    }

    public void setCounter(int counter){
        this.counter = counter;
    }

    public int getCounter(){
        return this.counter;
    }

    public void setLastPosition(Position p){
        this.lastPosition = p;
    }

    public void setTurn(boolean turn){
        this.turn = turn;
    }


    public SpecialFigure buyFromShop(Player p){
        if(p.getPoints() >= SpecialFigure.PRICE){
            p.setPoints(p1.getPoints() - SpecialFigure.PRICE);
            return SpecialFigure.specialFigures[(int)(Math.random()*10)];
        }
        return null;
    }

    public Quarto clone(){
        Quarto clone = null;
        try{
            clone = (Quarto) super.clone();
        } catch (CloneNotSupportedException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return clone;
    }

    public Quarto (Quarto that){
        this.counter = that.counter;
        this.turn = that.turn;
        this.board = that.getBoard();
        this.p1 = that.p1;
        this.p2 = that.p2;
        this.figures = that.getFigures();
        this.lastPosition = Position.generatePosition(that.lastPosition.getRow(), that.lastPosition.getColumn());
    }

}