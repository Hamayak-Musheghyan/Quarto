package am.aua.quarto.core.player;

public class ComputerPlayer extends Player{

    private Difficulty difficulty;
    public enum Difficulty {EASY, MEDIUM, HARD}

    public ComputerPlayer(){
        this("EASY");
    }

    public ComputerPlayer(String difficulty){
        super("Computer");
        this.difficulty = Difficulty.valueOf(difficulty);
    }
}
