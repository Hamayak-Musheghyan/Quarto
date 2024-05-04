package am.aua.quarto.core.player;

import am.aua.quarto.core.figures.SpecialFigure;

public abstract class Player implements Cloneable{
    private String name;

    private int points;
    private SpecialFigure specialFigure;



    public Player(){
        this("Anonymous Player");
    }

    public Player(String name){
        this.name = name;
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

    public void setSpecialFigure(SpecialFigure specialFigure){
        this.specialFigure = (SpecialFigure) specialFigure.clone();
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


}