# tic-tac-toe in Java
There are many methods that I had to take into account when I was making this program. For instance, the only input the users will be sent to the program for this game will be whenever they click on a tile. For that reason, all the tiles had to be assigned an action listener whenever they were first declared using: *board[i][j].addActionListener(controller);*
\nAnother thing I had to consider was the outputs to the user that the program would be sending. There are three types of outputs that the program can send to the user. These outputs include text displayed on the lower portion of the window with the use of a JLabel to show the user whose turn it is and who is the winner. Another example is the use of text displayed on the tiles to show what the player has claimed on that tile. The last output that this program uses is color. Whenever a player wins, or there is a tie, the board is colored the appropriate color using *.setBackground(c)* on the proper tiles.
