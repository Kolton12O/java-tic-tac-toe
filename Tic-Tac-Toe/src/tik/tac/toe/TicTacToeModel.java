package tik.tac.toe;

// Backend

import java.awt.Color;
import javax.swing.JButton;


public class TicTacToeModel {
    
    private JButton[][] squares = new JButton[3][3];
        
    private TicTacToeController controller;
    
    private String currentPlayer = Math.random() > 0.5 ? "X" : "O";
    
    public TicTacToeModel(TicTacToeController controller) {
        
        this.controller = controller;
        
    }
    
    public void buttonClicked(int row, int col) {
        if(isOpenSpace(row, col) && checkForWinner() == "None") {
            makeMove(row, col);
            final String winner = checkForWinner();
            if(winner != "None") {
                if(winner == "TIE") {
                    getController().getView().setLabel("It's a TIE!");
                } else {
                    getController().getView().setLabel(winner + " wins!");
                }
            }
        }
    }
    
    public boolean isOpenSpace(int row, int col) {
        final JButton[][] squares = getBoard();
        return squares[row][col].getText() == "";
    }
    
        
    public void makeMove(int row, int col) {
        String currentPlayer = getCurrentPlayer();
        JButton[][] squares = getBoard();
        JButton square = squares[row][col];
        square.setText(currentPlayer);
        swapPlayers();
    }
    
    public void highLight(Integer[][] arr, Color c) {
        JButton[][] squares = getBoard();
        
        for(Integer[] n : arr) {
            final int row = n[0];
            final int col = n[1];
            
            squares[row][col].setBackground(c);
        }
    }
    
    public String checkForWinner() {
        boolean hasWinner = false;
        
        JButton[][] squares = getBoard();
        
        if(squares[0][0].getText() == squares[0][1].getText() && squares[0][1].getText() == squares[0][2].getText() && squares[0][0].getText() != "") {
            hasWinner = true;
            final Integer[][] arr = {{0,0},{0,1},{0,2}};
            highLight(arr, new Color(102, 255, 102));
            squares[0][0].getText();
        }
        if(squares[1][0].getText() == squares[1][1].getText() && squares[1][1].getText() == squares[1][2].getText() && squares[1][0].getText() != "") {
            hasWinner = true;
            final Integer[][] arr = {{1,0},{1,1},{1,2}};
            highLight(arr, new Color(102, 255, 102));
            squares[1][0].getText();
        }
        if(squares[2][0].getText() == squares[2][1].getText() && squares[2][1].getText() == squares[2][2].getText() && squares[2][0].getText() != "") {
            hasWinner = true;
            final Integer[][] arr = {{2,0},{2,1},{2,2}};
            highLight(arr, new Color(102, 255, 102));
            squares[2][0].getText();
        }

        if(squares[0][0].getText() == squares[1][0].getText() && squares[1][0].getText() == squares[2][0].getText() && squares[0][0].getText() != "") {
            hasWinner = true;
            final Integer[][] arr = {{0,0},{1,0},{2,0}};
            highLight(arr, new Color(102, 255, 102));
            squares[0][0].getText();
        }
        if(squares[0][1].getText() == squares[1][1].getText() && squares[1][1].getText() == squares[2][1].getText() && squares[0][1].getText() != "") {
            hasWinner = true;
            final Integer[][] arr = {{0,1},{1,1},{2,1}};
            highLight(arr, new Color(102, 255, 102));
            squares[0][1].getText();
        }
        if(squares[0][2].getText() == squares[1][2].getText() && squares[1][2].getText() == squares[2][2].getText() && squares[0][2].getText() != "") {
            hasWinner = true;
            final Integer[][] arr = {{0,2},{1,2},{2,2}};
            highLight(arr, new Color(102, 255, 102));
            squares[0][2].getText();
        }
        
        if(squares[0][0].getText() == squares[1][1].getText() && squares[1][1].getText() == squares[2][2].getText() && squares[0][0].getText() != "") {
            hasWinner = true;
            final Integer[][] arr = {{0,0},{1,1},{2,2}};
            highLight(arr, new Color(102, 255, 102));
            squares[0][0].getText();
        }
        if(squares[0][2].getText() == squares[1][1].getText() && squares[1][1].getText() == squares[2][0].getText() && squares[0][2].getText() != "") {
            hasWinner = true;
            final Integer[][] arr = {{0,2},{1,1},{2,0}};
            highLight(arr, new Color(102, 255, 102));
            squares[0][2].getText();
        }

        if(isFull() && !hasWinner) {
            final Integer[][] arr = {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
            highLight(arr, new Color(255, 255, 0));
            return "TIE";
        }

     
        return "None";
    }
    
    public boolean isFull() {
        JButton[][] squares = getBoard();
        
        for(int i = 0; i < squares.length; i++) {
            for(int j = 0; j < squares[i].length; j++) {
                  if(squares[i][j].getText() == "") return false;  
            }
        }
        return true;
    }
    
    public JButton[][] getBoard() {
        return squares;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }
    
    public TicTacToeController getController() {
        return controller;
    }
    
    public void setPlayer(String p) {
        currentPlayer = p;
        getController().setLabel("It's " + p + "'s turn!");
    }
    
    public void swapPlayers() {
        if(currentPlayer == "X") { 
            setPlayer("O");
        } else {
            setPlayer("X");
        }
    }
}
