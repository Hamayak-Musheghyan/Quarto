package am.aua.quarto.core.players;

import am.aua.quarto.core.Position;
import am.aua.quarto.core.Quarto;
import am.aua.quarto.core.figures.ActualFigure;
import am.aua.quarto.core.figures.Figure;

import java.util.Random;

public class EasyComputerPlayer extends ComputerPlayer{

    public EasyComputerPlayer(){
        super();
    }


    public boolean performPut(Quarto game, Figure f){

        Position current = Position.generatePosition( (int) (Math.random() * Quarto.BOARD_LENGTH), (int) (Math.random() * Quarto.BOARD_HEIGHT));

        while(!game.isEmpty(current)){
            current = Position.generatePosition( (int) (Math.random() * Quarto.BOARD_LENGTH), (int) (Math.random() * Quarto.BOARD_HEIGHT));
        }

        setPositionToPut(current);
        return super.putToBoard(game, f);
    }
}
