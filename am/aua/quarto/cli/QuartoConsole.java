package am.aua.quarto.cli;

import am.aua.quarto.core.*;
import am.aua.quarto.core.figures.Figure;

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

        if (input.equals("Human")) {
            System.out.println("What is Player2's name?");
            game.setP2(sc.next());
        } else if (input.equals("Computer")) {
            System.out.println("Choose difficulty: EASY, MEDIUM, HARD");
            game.setP2(sc.next());

        }


        printCurrentState();

        while(!game.isGameOver()){
            int index;
            if(game.getTurn() == 0){
                System.out.println(game.getP2().getName() + ", give the index of figure for " + game.getP1().getName());
                index = sc.nextInt();
                System.out.println(game.getP1().getName() + ", put the figure on the board");
            }
            else {
                System.out.println(game.getP1().getName() + ", give the index of figure for " + game.getP2().getName());
                index = sc.nextInt();
                System.out.println(game.getP2().getName() + ", put the figure on the board");
            }

            game.performPut(Position.generatePosition(sc.nextInt(), sc.nextInt()), game.takeFigure(index-1));
            printCurrentState();
        }
    }

    public void printCurrentState (){
        System.out.println("Current Board");
        for (int i = 0; i < Quarto.BOARD_LENGTH; i++) {
            for (int j = 0; j < Quarto.BOARD_HEIGHT; j++) {
                if(!this.game.isEmpty(Position.generatePosition(i, j)))
                    System.out.print(" " + this.game.getBoard()[i][j] + " ");
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
                i++;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuartoConsole q = new QuartoConsole();
        q.play();
    }
}