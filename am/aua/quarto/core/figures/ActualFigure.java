package am.aua.quarto.core.figures;

public class ActualFigure extends Figure{
    public ActualFigure(Color color, Height height, Shape shape, Form form){
        super(color, height, shape, form);
    }

    public static ActualFigure[] actualFigures = new ActualFigure[]{
        new ActualFigure(Figure.Color.WHITE, Figure.Height.TALL, Figure.Shape.ROUND, Figure.Form.SOLID),
        new ActualFigure(Figure.Color.WHITE, Figure.Height.TALL, Figure.Shape.ROUND, Figure.Form.HOLLOW),
        new ActualFigure(Figure.Color.WHITE, Figure.Height.TALL, Figure.Shape.SQUARE, Figure.Form.SOLID),
        new ActualFigure(Figure.Color.WHITE, Figure.Height.TALL, Figure.Shape.SQUARE, Figure.Form.HOLLOW),
        new ActualFigure(Figure.Color.WHITE, Figure.Height.SHORT, Figure.Shape.ROUND, Figure.Form.SOLID),
        new ActualFigure(Figure.Color.WHITE, Figure.Height.SHORT, Figure.Shape.ROUND, Figure.Form.HOLLOW),
        new ActualFigure(Figure.Color.WHITE, Figure.Height.SHORT, Figure.Shape.SQUARE, Figure.Form.SOLID),
        new ActualFigure(Figure.Color.WHITE, Figure.Height.SHORT, Figure.Shape.SQUARE, Figure.Form.HOLLOW),
        new ActualFigure(Figure.Color.BLACK, Figure.Height.TALL, Figure.Shape.ROUND, Figure.Form.SOLID),
        new ActualFigure(Figure.Color.BLACK, Figure.Height.TALL, Figure.Shape.ROUND, Figure.Form.HOLLOW),
        new ActualFigure(Figure.Color.BLACK, Figure.Height.TALL, Figure.Shape.SQUARE, Figure.Form.SOLID),
        new ActualFigure(Figure.Color.BLACK, Figure.Height.TALL, Figure.Shape.SQUARE, Figure.Form.HOLLOW),
        new ActualFigure(Figure.Color.BLACK, Figure.Height.SHORT, Figure.Shape.ROUND, Figure.Form.SOLID),
        new ActualFigure(Figure.Color.BLACK, Figure.Height.SHORT, Figure.Shape.ROUND, Figure.Form.HOLLOW),
        new ActualFigure(Figure.Color.BLACK, Figure.Height.SHORT, Figure.Shape.SQUARE, Figure.Form.SOLID),
        new ActualFigure(Figure.Color.BLACK, Figure.Height.SHORT, Figure.Shape.SQUARE, Figure.Form.HOLLOW)
    };

    public ActualFigure clone(){
        return (ActualFigure) super.clone();
    }


}