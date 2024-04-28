package am.aua.quarto.core.figures;

public class ShapeAntiJoker extends SpecialFigure {
    public ShapeAntiJoker(Color color, Height height, Form form){
        this.height = height;
        this.shape = null;
        this.form = form;
        this.color = color;
    }


    public boolean isSameShape(Figure other){
        return  false;
    }
}
