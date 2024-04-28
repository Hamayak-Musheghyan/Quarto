package am.aua.quarto.core.player;

public class Player {
    private String name;

    public Player(){
        this("Anonymous Player");
    }

    public Player(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
}
