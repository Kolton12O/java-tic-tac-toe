package tik.tac.toe;

// Sets the display

import java.awt.*;
import javax.swing.*; 

public class TicTacToeView extends JPanel {
    
    private TicTacToeController controller;
    
    private JLabel resultLabel;
    
    public TicTacToeView(TicTacToeController controller) {
        this.controller = controller;
        init();
    }

    public void init() {
        
        JPanel squaresPanel = new JPanel(new GridLayout(3, 3));
        
        for(int i = 0; i < controller.getBoard().length; i++) {
            for(int j = 0; j < controller.getBoard()[i].length; j++) {
                final JButton[][] board = controller.getBoard();
                board[i][j] = new JButton();
                board[i][j].addActionListener(controller);
                board[i][j].setName("Square" + i + j);
                board[i][j].setText("");
                board[i][j].setPreferredSize(new Dimension(64, 64));
                squaresPanel.add(board[i][j]);
            }
        }
        
                
        setLayout(new BorderLayout());
        
        this.add(squaresPanel);
        resultLabel = new JLabel("Welcome to Tic-Tac-Toe", JLabel.CENTER);
        resultLabel.setName("ResultLabel");
        this.add(resultLabel, BorderLayout.SOUTH);
    }
    
    public void setLabel(String m) {
        resultLabel.setText(m);
    }
    
}
