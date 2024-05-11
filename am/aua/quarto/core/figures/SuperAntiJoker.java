package am.aua.quarto.core.figures;

public class SuperAntiJoker extends SpecialFigure {

    public SuperAntiJoker(){
        super(500);
    }

    public String toString(){
        return "####";
    }
    public boolean isSameColor(Figure other){
        return  false;
    }
    public boolean isSameHeight(Figure other){
        return false;
    }
    public boolean isSameShape(Figure other){
        return false;
    }
    public boolean isSameForm(Figure other){
        return  false;
    }
}
