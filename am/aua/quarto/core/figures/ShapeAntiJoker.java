package am.aua.quarto.core.figures;

public class ShapeAntiJoker extends SpecialFigure {
    public ShapeAntiJoker(Color color, Height height, Form form){
        super(100);
        this.height = height;
        this.shape = null;
        this.form = form;
        this.color = color;
    }

    public String toString(){
        return "" + color.toString().charAt(0) +
                height.toString().charAt(0) +
                "#" +
                form.toString().charAt(0);
    }
    public boolean isSameShape(Figure other){
        return  false;
    }
}
