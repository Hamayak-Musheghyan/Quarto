package am.aua.quarto.ui;


import am.aua.quarto.core.Quarto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import am.aua.quarto.core.Position;
import am.aua.quarto.core.figures.Figure;



public class QuartoUI extends JFrame implements ActionListener{

    private Quarto game;
    private BoardSquareUI[][] boardSquares;
    private BoardSquareUI[] figures;
    private boolean isFigureTaken;

    public QuartoUI() {
        setTitle("Quarto Game");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        game = new Quarto("ina", "gor");

        JPanel figurePanel = new JPanel(new FlowLayout());
        figurePanel.setPreferredSize(new Dimension(400, 100));

        figures = new BoardSquareUI[16];
        final Figure[] taken = new Figure[1];
        for (int i = 0; i < game.getFigures().length; i++) {
            Figure figure = game.getFigures()[i];
            figures[i] = new BoardSquareUI();
            figures[i].setPiece(figure.toString());
            int I = i;
            figures[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Action when a figure button is clicked
                    if (!isFigureTaken) {
                        // Remember the selected figure
                        taken[0] = game.takeFigure(I);
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
                            if (game.performPut(Position.generatePosition(I, J), taken[0])) {
                                updatePieces(true);
                                isFigureTaken = false;
                                if (game.isGameOver()) {
                                    JOptionPane.showMessageDialog(QuartoUI.this, "Game Over! You Win!");
                                }

                            }
                        }
                    }
                });
                centerPanel.add(boardSquares[i][j]);
            }
        }

        add(figurePanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);

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

    public void actionPerformed(ActionEvent e) {
        if(game.isGameOver()){
            JLabel label = new JLabel("Game Over.");
            add(label);
        }
    }
}

