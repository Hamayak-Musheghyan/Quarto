package am.aua.quarto.core.players;

import am.aua.quarto.core.Position;
import am.aua.quarto.core.Quarto;
import am.aua.quarto.core.figures.ActualFigure;
import am.aua.quarto.core.figures.Figure;

import java.util.ArrayList;

public abstract class Player implements Cloneable{
    private String name;

    private int points;
    private Position positionToPut;
    protected static ArrayList<Integer> availableFigureIndexes;
    protected static final int NUMBER_OF_FIGURES = 16; // number of actual figures


    public Player(String name) throws NullPointerException{
        this.points = 0;
        availableFigureIndexes = new ArrayList<>();
        for(int i = 0; i < NUMBER_OF_FIGURES; i++)
            availableFigureIndexes.add(i);
        if(name != null)
            this.name = name;
        else
            throw new NullPointerException();
    }
    public String getName(){
        return this.name;
    }

    public int getPoints(){
        return this.points;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public Position getPositionToPut(){
        return new Position(this.positionToPut);
    }

    public void setPositionToPut(Position toPut){
        this.positionToPut = toPut;
    }

    public Player clone(){
        Player copy = null;
        try {
            copy = (Player) super.clone();
        } catch (CloneNotSupportedException cnse){
            System.out.println(cnse.getMessage());
            System.exit(0);
        }
        return copy;
    }

    public abstract ActualFigure takeFigure(Quarto game);
    public abstract boolean performPut(Quarto game, Figure f);

    public boolean putToBoard(Quarto game, Figure f){
        if(game.isEmpty(positionToPut) && f != null){
            game.setBoard(positionToPut, f);
            game.setLastPosition(positionToPut);
            game.setCounter(game.getCounter()+1);
            game.setTurn(!game.getTurn());
            return true;
        }
        return false;
    }

}