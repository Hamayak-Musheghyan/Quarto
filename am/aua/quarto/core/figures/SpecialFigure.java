package am.aua.quarto.core.figures;

public abstract class SpecialFigure extends Figure{

    public static final int PRICE = 100;

    public static SpecialFigure[] specialFigures = {
            new SuperJoker(),
            new ColorJoker(randomHeight(), randomShape(), randomForm()),
            new HeightJoker(randomColor(), randomShape(), randomForm()),
            new ShapeJoker(randomColor(), randomHeight(), randomForm()),
            new FormJoker(randomColor(), randomHeight(), randomShape()),
            new ColorAntiJoker(randomHeight(), randomShape(), randomForm()),
            new HeightAntiJoker(randomColor(), randomShape(), randomForm()),
            new ShapeAntiJoker(randomColor(), randomHeight(), randomForm()),
            new FormAntiJoker(randomColor(), randomHeight(), randomShape()),
            new SuperAntiJoker()
    };

    public SpecialFigure(int price){
    }

    public abstract String toString();

    public int getPrice(){
        return PRICE;
    }


    private static Color randomColor(){ return Figure.Color.values()[(int) (Math.random()*2)];}
    private static Height randomHeight(){ return Figure.Height.values()[(int) (Math.random()*2)];}
    private static Shape randomShape(){ return Figure.Shape.values()[(int) (Math.random()*2)];}
    private static Form randomForm(){ return Figure.Form.values()[(int) (Math.random()*2)];}

}