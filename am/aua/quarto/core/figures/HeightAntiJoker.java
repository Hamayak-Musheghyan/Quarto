package am.aua.quarto.core.figures;

public class HeightAntiJoker extends SpecialFigure {
    public HeightAntiJoker(Color color, Shape shape, Form form){
        super(100);
        this.height = null;
        this.shape = shape;
        this.form = form;
        this.color = color;
    }

    public String toString(){
        return color.toString().charAt(0) +
                "#" +
                shape.toString().charAt(0) +
                form.toString().charAt(0);
    }
    public boolean isSameHeight(Figure other){
        return  false;
    }
}
