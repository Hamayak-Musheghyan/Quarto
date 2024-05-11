package am.aua.quarto.core.figures;
public class ColorJoker extends SpecialFigure{


    public ColorJoker(Height height, Shape shape, Form form){
        super(100);
        this.height = height;
        this.shape = shape;
        this.form = form;
        this.color = null;
    }

    public String toString(){
        return "" + "+" +
                height.toString().charAt(0) +
                shape.toString().charAt(0) +
                form.toString().charAt(0);
    }


public boolean isSameColor(Figure other){
        return  true;
    }

}
