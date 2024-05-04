package am.aua.quarto.core.player;

import am.aua.quarto.core.figures.SpecialFigure;

public class HumanPlayer extends Player{

    private SpecialFigure specialFigure;


    public HumanPlayer(String name){
        super(name);
    }

    public void setSpecialFigure(SpecialFigure specialFigure){
        this.specialFigure = (SpecialFigure) specialFigure.clone();
    }





}
