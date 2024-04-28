package am.aua.quarto.core.figures;
public class ShapeJoker extends SpecialFigure{
    public ShapeJoker(Color color, Height height, Form form){
        this.height = height;
        this.shape = null;
        this.form = form;
        this.color = color;
    }


    public boolean isSameShape(Figure other){
        return  true;
    }
}
