package am.aua.quarto.core.figures;
public class FormJoker extends SpecialFigure{
    public FormJoker(Color color, Height height, Shape shape){
        this.height = height;
        this.shape = shape;
        this.form = null;
        this.color = color;
    }

    public boolean isSameForm(Figure other){
        return  true;
    }
}
