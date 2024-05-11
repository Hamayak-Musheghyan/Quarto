package am.aua.quarto.core.figures;
public class FormJoker extends SpecialFigure{


    public FormJoker(Color color, Height height, Shape shape){
        super(100);
        this.height = height;
        this.shape = shape;
        this.form = null;
        this.color = color;
    }

    public String toString(){
        return "" + color.toString().charAt(0) +
                height.toString().charAt(0) +
                shape.toString().charAt(0) +
                "+";
    }
    public boolean isSameForm(Figure other){
        return  true;
    }
}
