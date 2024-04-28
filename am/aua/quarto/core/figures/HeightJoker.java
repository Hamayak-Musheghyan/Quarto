package am.aua.quarto.core.figures;
public class HeightJoker extends SpecialFigure {
    public HeightJoker(Color color, Shape shape, Form form){
        this.height = null;
        this.shape = shape;
        this.form = form;
        this.color = color;
    }


    public boolean isSameHeight(Figure other){
        return  true;
    }
}
