package am.aua.quarto.core.figures;
public class HeightJoker extends SpecialFigure {
    public HeightJoker(Color color, Shape shape, Form form){
        super(100);
        this.height = null;
        this.shape = shape;
        this.form = form;
        this.color = color;
    }


    public String toString(){
        return "" + color.toString().charAt(0) +
                "+" +
                shape.toString().charAt(0) +
                form.toString().charAt(0);
    }

    public boolean isSameHeight(Figure other){
        return  false;
    }
}
