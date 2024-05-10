package am.aua.quarto.core.players;

import am.aua.quarto.core.Position;
import am.aua.quarto.core.Quarto;
import am.aua.quarto.core.figures.Figure;


public class MediumComputerPlayer extends ComputerPlayer{

    public MediumComputerPlayer(){
        super("MEDIUM");
    }


    public boolean performPut (Quarto game, Figure f){

        Position current = null;
        Quarto copyGame = new Quarto(game);

        outer:
        for (int i = 0; i < Quarto.BOARD_LENGTH; i++) {
            for (int j = 0; j < Quarto.BOARD_HEIGHT; j++) {
                current = Position.generatePosition(i, j);
                if (copyGame.isEmpty(current)) {
                    copyGame.setBoard(current, f);
                    if (copyGame.isGameOver()) {
                        break outer;
                    } else {
                        copyGame = new Quarto(game);
                        current = null;
                    }
                }
            }
        }

        if(current != null) {
            setPositionToPut(current);
        } else
            setPositionToPut(Position.generatePosition( (int) (Math.random() * Quarto.BOARD_LENGTH), (int) (Math.random() * Quarto.BOARD_HEIGHT)));

        return super.putToBoard(game, f);

    }

}





