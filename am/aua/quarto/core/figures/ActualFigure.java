package am.aua.quarto.core.figures;

public class ActualFigure extends Figure{
    // there is no need to make this class,
    // we consider that in the future we will make functionalities that will be only for ActualFigureActualFigures
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