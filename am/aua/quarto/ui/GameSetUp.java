package am.aua.quarto.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSetUp extends JFrame {

    public GameSetUp() {
        setTitle("Game Setup");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create buttons for selecting game mode
        JButton humanVsHumanBtn = new JButton("Human vs Human");
        JButton humanVsComputerBtn = new JButton("Human vs Computer");

        // Add action listeners to buttons
        humanVsHumanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create Quarto game with human vs human mode
                QuartoUI quartoUI = new QuartoUI("human", "human", "");
                dispose(); // Close setup window
            }
        });

        humanVsComputerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create buttons for selecting difficulty
                JButton easyBtn = new JButton("Easy");
                JButton mediumBtn = new JButton("Medium");

                // Create panel for difficulty selection
                JPanel difficultyPanel = new JPanel(new FlowLayout());
                difficultyPanel.add(easyBtn);
                difficultyPanel.add(mediumBtn);

                // Add action listeners to difficulty buttons
                easyBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Create Quarto game with human vs computer (easy) mode
                        QuartoUI quartoUI = new QuartoUI("human", "computer", "easy");
                        quartoUI.setVisible(true);
                        dispose(); // Close setup window
                    }
                });

                mediumBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Create Quarto game with human vs computer (medium) mode
                        QuartoUI quartoUI = new QuartoUI("human", "computer", "medium");
                        quartoUI.setVisible(true);
                        dispose(); // Close setup window
                    }
                });

                // Remove existing components and add difficulty selection panel
                getContentPane().removeAll();
                getContentPane().add(difficultyPanel, BorderLayout.CENTER);
                revalidate();
            }
        });

        // Add buttons to main panel
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        mainPanel.add(humanVsHumanBtn);
        mainPanel.add(humanVsComputerBtn);

        add(mainPanel, BorderLayout.CENTER);
    }

}
