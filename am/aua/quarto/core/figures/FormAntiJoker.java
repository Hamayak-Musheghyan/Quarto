package am.aua.quarto.core.figures;

public class FormAntiJoker extends SpecialFigure {



    public FormAntiJoker(Color color, Height height, Shape shape){
        super(100);
        this.height = height;
        this.shape = shape;
        this.form = null;
        this.color = color;
    }

    public boolean isSameForm(Figure other){
        return  false;
    }
}