package am.aua.quarto.core.cards;

import am.aua.quarto.core.Quarto;
import am.aua.quarto.core.figures.Puttable;

public abstract class Card implements Puttable {
    private String message;
    private int point;

    public Card(String message, int point){
        this.message = message;
        this.point = point;
    }
    public Card clone(){
        try{
            return (Card) super.clone();
        }
        catch(CloneNotSupportedException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public abstract void act (Quarto game);
}