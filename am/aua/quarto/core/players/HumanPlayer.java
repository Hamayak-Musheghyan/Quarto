package am.aua.quarto.core.players;


import am.aua.quarto.core.Position;
import am.aua.quarto.core.Quarto;
import am.aua.quarto.core.figures.ActualFigure;
import am.aua.quarto.core.figures.Figure;


public class HumanPlayer extends Player{

    private int selectedFigure; //TODO: for me or for opponent player????, change the name



    public HumanPlayer(String name){
        super(name);
    }

    public void selectFigure(int selectedFigure){
        this.selectedFigure = selectedFigure;
    }


    public ActualFigure takeFigure(Quarto game){
        ActualFigure f = null;
        if(game.getFigures()[selectedFigure] != null) {
            f = game.getFigures()[selectedFigure].clone();
        }
        game.setFigureToNull(selectedFigure);
        return f;
    }

    public boolean performPut(Quarto game, Figure f) {

        if(game.getCardAt(getPositionToPut()) != null){
            game.getPlayer(game.getTurn()).setPoints(game.getCardAt(getPositionToPut()).getPoint());
        }

        return super.putToBoard(game, f);
    }
}
