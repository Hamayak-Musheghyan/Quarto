public enum Figure {
    LTSS("light", "tall", "square", "solid"),
    LTSH("light", "tall", "square", "hollow"),
    LTRS("light", "tall", "round", "solid"),
    LTRH("light", "tall", "round", "hollow"),
    LSSH("light", "short", "square", "hollow"),
    LSSS("light", "short", "square", "solid"),
    LSRH("light", "short", "round", "hollow"),
    LSRS("light", "short", "round", "solid"),
    DTSS("dark", "tall", "square", "solid"),
    DTSH("dark", "tall", "square", "hollow"),
    DTRS("dark", "tall", "round", "solid"),
    DTRH("dark", "tall", "round", "hollow"),
    DSSH("dark", "short", "square", "hollow"),
    DSSS("dark", "short", "square", "solid"),
    DSRH("dark", "short", "round", "hollow"),
    DSRS("dark", "short", "round", "solid");


    final String color;
    final String height;
    final String shape;
    final String form;

    Figure(String color, String height, String shape, String form){
        this.color = color;
        this.height = height;
        this.shape = shape;
        this.form = form;
    }

    public String getColor(){
        return this.color;
    }
    public String getHeight(){
        return this.height;
    }
    public String getShape(){
        return this.shape;
    }
    public String getForm(){
        return this.form;
    }
}
