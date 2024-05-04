package am.aua.quarto.core.cards;

import am.aua.quarto.core.Quarto;

public class DoubleMoveCard extends Card{

    public DoubleMoveCard(){
        super("You got a double move card!!!", 100);
    }
    public void act(Quarto game){
        game.setCounter(game.getCounter()-1);
    }
}
