package am.aua.quarto.ui;


import am.aua.quarto.core.Quarto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import am.aua.quarto.core.Position;
import am.aua.quarto.core.figures.Figure;
import am.aua.quarto.core.figures.SpecialFigure;
import am.aua.quarto.core.players.HumanPlayer;
import am.aua.quarto.core.players.InvalidMoveException;


public class QuartoUI extends JFrame{

    private Quarto game;
    private BoardSquareUI[][] boardSquares;
    private BoardSquareUI[] figures;
    private boolean isFigureTaken;
    private BoardSquareUI selectedFigureSquare;

    public QuartoUI() {
        setTitle("Quarto Game");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());



        game = new Quarto("ina", "human", "gor");

        JPanel figurePanel = new JPanel(new FlowLayout());
        figurePanel.setPreferredSize(new Dimension(400, 100));

        figures = new BoardSquareUI[16];
        final Figure[] taken = new Figure[1];
        for (int i = 0; i < game.getFigures().length; i++) {
            Figure figure = game.getFigures()[i];
            figures[i] = new BoardSquareUI();
            figures[i].setPiece(figure.toString());
            figures[i].setSize(50, 50);
            int I = i;
            figures[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!isFigureTaken) {
                        if (game.getPlayer(game.getTurn()) instanceof HumanPlayer) {
                            try {
                                ((HumanPlayer) game.getPlayer(game.getTurn())).selectFigure(I);
                            } catch (InvalidMoveException ive){

                            }
                        }
                        taken[0] = game.getPlayer(game.getTurn()).takeFigure(game);
                        updatePieces(false);
                        isFigureTaken = true;
                    }
                }
            });
            figurePanel.add(figures[i]);
        }

        JPanel centerPanel = new JPanel(new GridLayout(Quarto.BOARD_LENGTH, Quarto.BOARD_HEIGHT));
        centerPanel.setPreferredSize(new Dimension(400, 400));

        boardSquares = new BoardSquareUI[Quarto.BOARD_LENGTH][Quarto.BOARD_HEIGHT];
        for (int i = 0; i < Quarto.BOARD_LENGTH; i++) {
            for (int j = 0; j < Quarto.BOARD_HEIGHT; j++) {
                int I = i, J = j;
                boardSquares[i][j] = new BoardSquareUI(i, j, ((i + j) % 2 == 0));

                boardSquares[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (isFigureTaken && taken[0] != null) {
                            if (game.getPlayer(!game.getTurn()) instanceof HumanPlayer) {
                                game.getPlayer(!game.getTurn()).setPositionToPut(Position.generatePosition(I, J));
                            }
                            if (game.getPlayer(!game.getTurn()).performPut(game, taken[0])) {
                                updatePieces(true);
                                isFigureTaken = false;
                                if (game.isGameOver()) {
                                    JOptionPane.showMessageDialog(QuartoUI.this, "Game Over! You Win!");
                                    System.exit(0);
                                }

                            }
                        }
                    }
                });
                centerPanel.add(boardSquares[i][j]);
            }
        }

        JPanel selectedFigurePanel = new JPanel(new FlowLayout());
        selectedFigurePanel.setPreferredSize(new Dimension(400, 50));

        JLabel selectedFigureLabel = new JLabel("Selected Figure:");
        selectedFigurePanel.add(selectedFigureLabel);

        selectedFigureSquare = new BoardSquareUI();
        selectedFigurePanel.add(selectedFigureSquare);


        JButton shop = new JButton();
        shop.setBackground(Color.GREEN);
        shop.add(new JLabel("Buy from shop"));
        shop.setSize(50, 100);
        shop.addActionListener(new ActionListener() {
                                   @Override
                                   public void actionPerformed(ActionEvent e) {
                                       if(game.getPlayer(game.getTurn()).getPoints() >= SpecialFigure.PRICE){
                                           taken[0] = game.buyFromShop(game.getPlayer(game.getTurn()));
                                       }

                                       else{
                                           JOptionPane.showMessageDialog(QuartoUI.this, "You can't buy from shop. choose from the given figures.");
                                       }
                                   }
                               }

        );

        JPanel shopPanel = new JPanel();
        shopPanel.add(shop);

        add(figurePanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        add(shopPanel, BorderLayout.SOUTH);


        setVisible(true);
    }

    private void updatePieces(boolean isBoard) {
        if (isBoard) {
            for (int i = 0; i < Quarto.BOARD_LENGTH; i++) {
                for (int j = 0; j < Quarto.BOARD_HEIGHT; j++) {
                    if (game.getFigureAt(Position.generatePosition(i, j)) == null) {
                        boardSquares[i][j].setPiece();
                    } else {
                        boardSquares[i][j].setPiece(game.getFigureAt(Position.generatePosition(i, j)).toString());
                    }
                }
            }
        } else {
            for (int i = 0; i < figures.length; i++) {
                if (game.getFigures()[i] == null) {
                    figures[i].setPiece();
                } else {
                    figures[i].setPiece(game.getFigures()[i].toString());
                }
            }
        }
    }


}