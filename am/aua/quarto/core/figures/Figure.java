package am.aua.quarto.core.figures;

public class Figure implements Puttable, Cloneable{

    Color color;
    Height height;
    Shape shape;
    Form form;

    public enum Color{WHITE, BLACK};
    public enum Height{TALL, SHORT};
    public enum Shape{ROUND, SQUARE};
    public enum Form{SOLID, HOLLOW};

    public Figure(){
        this(Color.WHITE, Height.TALL, Shape.ROUND, Form.SOLID);
    }

    public Figure(Color color, Height height, Shape shape, Form form){
        this.color = color;
        this.height = height;
        this.shape = shape;
        this.form = form;
    }

    public Color getColor(){
        return this.color;
    }
    public Height getHeight(){
        return this.height;
    }
    public Shape getShape(){
        return this.shape;
    }
    public Form getForm(){
        return this.form;
    }

    public void setColor(Color color){
        this.color = color;
    }
    public void setHeight(Height height){
        this.height = height;
    }
    public void setShape(Shape shape){
        this.shape = shape;
    }
    public void setForm(Form form){
        this.form = form;
    }

    public Figure clone(){
        try {
            return (Figure) super.clone();
        }
        catch (CloneNotSupportedException e){
            return null;
        }
    }

    public String toString(){
        return "" + color.toString().charAt(0) +
                height.toString().charAt(0) +
                shape.toString().charAt(0) +
                form.toString().charAt(0);
    }

    public boolean isSame(Figure other){
        return isSameColor(other) && isSameHeight(other) && isSameShape(other) && isSameForm(other);
    }
    public boolean isSameByCharacteristic(int i, Figure other){
        if(other == null)
            return false;
        switch(i){
            case 0:
                return isSameColor(other);
            case 1:
                return isSameHeight(other);
            case 2:
                return isSameShape(other);
            case 3:
                return isSameForm(other);
        }
        return false;
    }
    public boolean isSameColor(Figure other){
        return  this.color == other.color;
    }
    public boolean isSameHeight(Figure other){
        return this.height == other.height;
    }
    public boolean isSameShape(Figure other){
        return this.shape == other.shape;
    }
    public boolean isSameForm(Figure other){
        return  this.form == other.form;
    }
}