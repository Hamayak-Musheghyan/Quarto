package am.aua.quarto.core.figures;

public class ColorAntiJoker extends SpecialFigure {
    public ColorAntiJoker(Height height, Shape shape, Form form){
        super(100);
        this.height = height;
        this.shape = shape;
        this.form = form;
        this.color = null;
    }


    public boolean isSameColor(Figure other){
        return  false;
    }
}
