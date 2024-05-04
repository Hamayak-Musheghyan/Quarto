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
        this.game = new Quarto();
        System.out.println("What is Player1's name?");
        game.setP1(sc.next());
        System.out.println("Choose Player2 Mode: Human or Computer");
        String input = sc.next();

        if (input.equalsIgnoreCase("human")) {
            System.out.println("What is Player2's name?");
            game.setP2(sc.next());
        } else if (input.equalsIgnoreCase("computer")) {
            System.out.println("Choose difficulty: EASY, MEDIUM, HARD");
            String difficulty = sc.next();
            if(difficulty.equalsIgnoreCase("easy"))
                game.setP2("EASY");
            else if (difficulty.equalsIgnoreCase("medium"))
                game.setP2("MEDIUM");
            else if (difficulty.equalsIgnoreCase("hard"))
                game.setP2("HARD");
        }

        printCurrentState();

        while(!game.isGameOver()){
            int index;
            String playerName = null;
            String opponent = null;
            if(game.getTurn() == 0){
                playerName = game.getP1().getName();
                opponent = game.getP2().getName();
            }
            else {
                playerName = game.getP2().getName();
                opponent = game.getP2().getName();
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
            printCurrentState();
        }
    }



    public void printCurrentState (){
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
        System.out.println("Number of moves is " + this.game.getCounter());
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