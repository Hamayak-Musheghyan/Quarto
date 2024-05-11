package am.aua.quarto.core.figures;
public class SuperJoker extends SpecialFigure {

    public SuperJoker(){
        super(600);
    }

    public String toString(){
        return "++++";
    }
    public boolean isSameColor(Figure other){
        return  true;
    }
    public boolean isSameHeight(Figure other){
        return true;
    }
    public boolean isSameShape(Figure other){
        return true;
    }
    public boolean isSameForm(Figure other){
        return  true;
    }

}
