package am.aua.quarto.core.players;

import am.aua.quarto.core.Quarto;
import am.aua.quarto.core.figures.ActualFigure;
import am.aua.quarto.core.figures.Figure;

import java.util.Random;

public abstract class  ComputerPlayer extends Player{
    // enum for Difficulty
    public enum Difficulty {EASY, MEDIUM}

    // instance variables
    private Difficulty difficulty;


    public ComputerPlayer(){
        this("EASY");
    }

    public ComputerPlayer(String difficulty){
        super("Computer");
        this.difficulty = Difficulty.valueOf(difficulty);
    }

    public ActualFigure takeFigure(Quarto game) {
        Random random = new Random();
        int index;
        do {
            index = random.nextInt(Player.availableFigureIndexes.size());
        } while (game.getFigures()[Player.availableFigureIndexes.get(index)] == null);
        Player.availableFigureIndexes.set(index, null);
         Player.availableFigureIndexes.remove(index);
        ActualFigure selectedFigure = game.getFigures()[index];
        game.setFigureToNull(index);
        return selectedFigure;
    }

    public abstract boolean performPut(Quarto game, Figure f);

}