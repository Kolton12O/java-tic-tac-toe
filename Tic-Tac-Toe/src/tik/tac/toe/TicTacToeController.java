package tik.tac.toe;

import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;

// Listener

public class TicTacToeController implements ActionListener {
    
    private TicTacToeModel model;
    private TicTacToeView view;
    
    public TicTacToeController() {
        
        this.model = new TicTacToeModel(this);
        this.view = new TicTacToeView(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
                
        Object source = e.getSource();
        
        if (source instanceof JButton) {
            
            JButton button = (JButton)source;
            
            final int row;
            final int col;
            final String name = button.getName();
            
            row = Character.getNumericValue(name.charAt(name.length()-2));
            col = Character.getNumericValue(name.charAt(name.length()-1));
            
            getModel().buttonClicked(row, col);

        }
        
    }
        
    public void setLabel(String m) {
        getView().setLabel(m);
    }
    
    public JButton[][] getBoard() {
        return getModel().getBoard();
    }
    
    public TicTacToeView getView() {
        return view;
    }
    
    public TicTacToeModel getModel() {
        return model;
    }
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {

            TicTacToeController c = new TicTacToeController();
            
            JFrame window = new JFrame("Tic-Tac-Toe");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.getContentPane().add( c.getView() );
            window.pack();
            //window.setSize(500,500);
            window.setVisible(true);
            
        });
        
    }

}