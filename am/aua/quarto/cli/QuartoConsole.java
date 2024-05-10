package am.aua.quarto.cli;

import am.aua.quarto.core.*;
import am.aua.quarto.core.figures.Figure;
import am.aua.quarto.core.figures.SpecialFigure;
import am.aua.quarto.core.players.HumanPlayer;
import am.aua.quarto.core.players.InvalidMoveException;


import java.util.Scanner;

public class QuartoConsole {
    private Quarto game;

    public void play() {

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("What is Player1's name?");
            String p1 = sc.next();
            System.out.println("Choose Player2 Mode: 1 for Human or 2 for Computer");
            int p2 = sc.nextInt();
            if (p2 == 1) {
                System.out.println("What is Player2's name?");
                this.game = new Quarto(p1, "human", sc.next());
                break;
            } else if (p2 == 2) {
                System.out.println("Choose difficulty: 1 for EASY, 2 for MEDIUM");
                int difficulty = sc.nextInt();
                if (difficulty == 1) {
                    this.game = new Quarto(p1, "computer", "EASY");
                    break;
                }
                else if (difficulty == 2) {
                    this.game = new Quarto(p1, "computer", "MEDIUM");
                    break;
                }
            }
            System.out.println("Wrong input! Initializing the game again...");
        }

        printCurrentState();

        while (!game.isGameOver()) {
            if(game.isDraw()){
                System.out.println("Draw! Nobody Won.");
                break;
            }

            String playerName;
            String opponent;

            playerName = game.getPlayer(game.getTurn()).getName();
            opponent = game.getPlayer(!game.getTurn()).getName();


            if (game.getPlayer(game.getTurn()).getPoints() >= SpecialFigure.PRICE) {
                if(game.getPlayer(game.getTurn()) instanceof HumanPlayer)
                    System.out.println(game.getPlayer(game.getTurn()).getName() + ", your points are: " + game.getPlayer(game.getTurn()).getPoints());
                System.out.println("You have enough points for shopping! Press 1 for shopping. Press any other key for not shopping.");
                String input = sc.next();
                if (input.equals("1")) {

                    Figure figure = this.game.buyFromShop(this.game.getPlayer(game.getTurn()));

                    System.out.println(opponent + ", put the figure " + figure + " on the board, as given by " + playerName);

                    game.getPlayer(!game.getTurn()).setPositionToPut(Position.generatePosition(sc.nextInt(), sc.nextInt()));
                    while(performPut(figure)){
                        game.getPlayer(!game.getTurn()).setPositionToPut(Position.generatePosition(sc.nextInt(), sc.nextInt()));
                    }
                    printCurrentState();
                    continue;
                }
            }



            if(game.getPlayer(game.getTurn()) instanceof HumanPlayer){
                System.out.println(playerName + ", give the index of figure for " + opponent);
                try {
                    ((HumanPlayer) game.getPlayer(game.getTurn())).selectFigure(sc.nextInt() - 1);
                } catch (InvalidMoveException e){
                    System.out.println("Invalid index for the figure. Try again");
                    continue;
                }
            }


            // TODO: check why it doesn't work with computers.
            Figure f = game.getPlayer(game.getTurn()).takeFigure(game);

            if(game.getPlayer(!game.getTurn()) instanceof HumanPlayer){
                System.out.println(opponent + ", put the figure " + f +  " on the board, as given by " + playerName);
                game.getPlayer(!game.getTurn()).setPositionToPut(Position.generatePosition(sc.nextInt(), sc.nextInt()));
            }

            while(performPut(f)){
                game.getPlayer(!game.getTurn()).setPositionToPut(Position.generatePosition(sc.nextInt(), sc.nextInt()));
            }
            printCurrentState();
        }
        if(game.getPlayer(game.getTurn()) instanceof HumanPlayer)
            System.out.println(game.getPlayer(game.getTurn()).getName().toUpperCase() + "!!! YOU WON!!! CONGRATS!!!");
        else System.out.println("COMPUTER WON! HAHAHAHA, YOU ARE A LOSER!");
    }

    public void printCurrentState(){
        System.out.println("Current Board");
        for (int i = 0; i < Quarto.BOARD_LENGTH; i++) {
            for (int j = 0; j < Quarto.BOARD_HEIGHT; j++) {
                if(!this.game.isEmpty(Position.generatePosition(i, j))) {
                    System.out.print(" " + this.game.getBoard()[i][j] + " ");
                }
                else
                    System.out.print(" ---- ");
            }
            System.out.println();
        }
        System.out.println("Figures to use");
        int i = 1;
        for(Figure element: this.game.getFigures()){
            if(element != null){
                System.out.print(i + " " + element + " ");
            }
            else {
                System.out.print(i + " no figure ");
            }
            i++;
        }
        System.out.println();
    }

    private boolean performPut (Figure f){
        boolean success = game.getPlayer(!game.getTurn()).performPut(game, f);
        if (!success) {
            System.out.println("The move is invalid! Try another position.");
            return true;
        }
        System.out.println("The move was successful!");
        return false;
    }

}