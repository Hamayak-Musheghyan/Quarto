package am.aua.quarto.cli;

import am.aua.quarto.core.*;
import am.aua.quarto.core.figures.Figure;
import am.aua.quarto.core.player.ComputerPlayer;
import am.aua.quarto.core.player.Player;
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
            System.out.println("Choose difficulty: EASY, MEDIUM, HARD");
            String difficulty = sc.next();
            if(difficulty.equalsIgnoreCase("easy"))
                this.game = new Quarto(p1, difficulty);
            else if (difficulty.equalsIgnoreCase("medium"))
                this.game = new Quarto(p1, difficulty);
            else if (difficulty.equalsIgnoreCase("hard"))
                this.game = new Quarto(p1, difficulty);
        }

        printCurrentState();

        while(!game.isGameOver()){
            if(this.game.getCounter() >= 16) {
                System.out.println("Draw! None of you won.");
                System.exit(0);
            }
            int index;
            String playerName = null;
            String opponent = null;
            if(game.getTurn()){
                playerName = game.getPlayer(game.getTurn()).getName();
                opponent = game.getPlayer(!game.getTurn()).getName();
            }
            else {
                playerName = game.getPlayer(game.getTurn()).getName();
                opponent = game.getPlayer(!game.getTurn()).getName();
            }
            System.out.println("Choose if you want to: \n1. Play;\n2. Buy a figure.");
            if(sc.nextInt()==1) {
                System.out.println(playerName + ", give the index of figure for the opponent");
                index = sc.nextInt();
                System.out.println(opponent + ", put the figure on the board");

                Figure f = game.takeFigure(index - 1);
                if (f == null) {
                    System.out.println("Invalid index, try again.");
                    continue;
                }
                boolean success = game.performPut(Position.generatePosition(sc.nextInt(), sc.nextInt()), f);
                while (!success) {
                    System.out.println("The move is invalid! Try another position.");
                    success = game.performPut(Position.generatePosition(sc.nextInt(), sc.nextInt()), f);
                }
                System.out.println("The move was successful!");
            }
            /*
            else{
                Figure f = this.game.buyFromShop(this.game.getPlayer(game.getTurn()));
                if(f==null){
                    System.out.println("You don't have enough money to buy a figure, give a figure from the given set.");
                    continue;
                }
                else{
                    System.out.println(opponent + ", put the figure "+f.toString()+" on the board");
                    boolean success = game.performPut(Position.generatePosition(sc.nextInt(), sc.nextInt()), f);
                    while (!success) {
                        System.out.println("The move is invalid! Try another position.");
                        success = game.performPut(Position.generatePosition(sc.nextInt(), sc.nextInt()), f);
                    }
                    System.out.println("The move was successful!");
                }
            }
             */
            printCurrentState();
        }
        System.out.println("you won>>??????");
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