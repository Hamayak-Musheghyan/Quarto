package am.aua.quarto.cli;

import am.aua.quarto.core.*;
import am.aua.quarto.core.figures.Figure;
import am.aua.quarto.core.figures.SpecialFigure;
import am.aua.quarto.core.players.HumanPlayer;

import java.util.Scanner;

public class QuartoConsole {
    private Quarto game;

    public void play(){

        Scanner sc = new Scanner(System.in);
        System.out.println("What is Player1's name?");
        String p1 = sc.next();
        System.out.println("Choose Player2 Mode: Human or Computer");
        String p2 = sc.next();

        if (p2.equalsIgnoreCase("human")) {
            System.out.println("What is Player2's name?");
            this.game = new Quarto(p1, sc.next());
        } else if (p2.equalsIgnoreCase("computer")) {
            System.out.println("Choose difficulty: EASY, MEDIUM");
            String difficulty = sc.next();
            this.game = new Quarto(p1, difficulty);
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


//                System.out.println("You have enough points for shopping! Choose if you want to: \n1. Play,\n2. Buy a figure.");
//                int input = sc.nextInt();
//                while (input != 1 && input != 2) {
//                    System.out.println("Enter a valid number");
//                    input = sc.nextInt();
//                }
//                if(input == 2){
//                    Figure figure = this.game.buyFromShop(this.game.getPlayer(game.getTurn()));
//                    if (figure == null) {
//                        System.out.println("You don't have enough points to buy a figure, give a figure from the given set.");
//                        continue;
//                    }
//                    else {
//                        System.out.println(opponent + ", put the figure " + figure +  " on the board, as given by " + playerName);
//                        game.getPlayer(!game.getTurn()).setPositionToPut(Position.generatePosition(sc.nextInt(), sc.nextInt()));
//                    }
//                }

            if(game.getPlayer(game.getTurn()) instanceof HumanPlayer){
                System.out.println(playerName + ", give the index of figure for " + opponent);
                ((HumanPlayer) game.getPlayer(game.getTurn())).selectFigure(sc.nextInt()-1);
            }
            Figure f = game.getPlayer(game.getTurn()).takeFigure(game);
            if (f == null) {
                System.out.println("Invalid index, try again.");
                continue;
            }

            if(game.getPlayer(!game.getTurn()) instanceof HumanPlayer){
                System.out.println(opponent + ", put the figure " + f +  " on the board, as given by " + playerName);
                game.getPlayer(!game.getTurn()).setPositionToPut(Position.generatePosition(sc.nextInt(), sc.nextInt()));
            }

            boolean success = game.getPlayer(!game.getTurn()).performPut(game, f);
            while (!success) {
                System.out.println("The move is invalid! Try another position.");
                game.getPlayer(!game.getTurn()).setPositionToPut(Position.generatePosition(sc.nextInt(), sc.nextInt()));
                success = game.getPlayer(!game.getTurn()).performPut(game, f);
            }

            System.out.println("The move was successful!");
            if(game.getPlayer(!game.getTurn()) instanceof HumanPlayer)
                System.out.println(game.getPlayer(!game.getTurn()).getName() + ", your points are: " + game.getPlayer(!game.getTurn()).getPoints());

            printCurrentState();
        }
        System.out.println(game.getPlayer(game.getTurn()).getName().toUpperCase() + "!!! YOU WON!!! CONGRATS!!!");
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


    public static void main(String[] args) {
        QuartoConsole q = new QuartoConsole();
        q.play();
    }
}