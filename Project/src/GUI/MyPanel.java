package GUI;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Logic.NumberCrush;
/**
 * 
 * @author Avdo Dzanic
 *
 */
public class MyPanel implements ActionListener {

    NumberCrush gameboard;
    static int numRows;
    static int numCols;
    boolean pieceSelected = false;
    int selectedRow = 0;
    int selectedCol = 0;
    JButton boardButtons[][];
    JLabel statusBar;
   
    JButton resetButton;
    JButton quitButton;
    JPanel buttonBar;
    JPanel boardPanel;
    JFrame jfrm;
    final Color DESELECTED_COLOR = Color.LIGHT_GRAY;
    final Color SELECTED_COLOR = Color.RED;
    int points = 0;
    int moves=6;
   int  mustHavePoints=6;
   MakeBoard mb;
 
static int max;
   
/**
 * construct the game board
 * @param resetButton is for reset board
 * @param quitButton is for exit 
 * @param boardButton is button of board
 * @param statusBar is for points 
 * 
 */
    
    MyPanel(int numRows,int numCols,int max) {
    	mb=new MakeBoard();
    this.numRows=numRows;
    this.numCols=numCols;
    	this.max=max;
        gameboard = new NumberCrush(numRows,numCols,max);
       
        boardButtons = new JButton[numRows][numCols];
      
        buttonBar = new JPanel(new FlowLayout());
        resetButton = new JButton("Reset Board");
        quitButton = new JButton("Exit");
        boardPanel = new JPanel(new GridLayout(numRows,numCols,3,3));
        statusBar = new JLabel("Points: " + String.valueOf(points));
       
        jfrm = new JFrame("NumberCrush");
        
        for(int i=0;i<numRows;i++) {
            for(int j=0;j<numCols;j++) {
            
                boardButtons[i][j] = new JButton(NumberCrush.CELL_LABELS[NumberCrush.CELL_EMPTY]);
                boardButtons[i][j].setFont(new Font("Monospaced",Font.PLAIN,20));
                boardButtons[i][j].setActionCommand(
                    String.valueOf(i) + " " + String.valueOf(j));
                boardButtons[i][j].addActionListener(this);
                boardPanel.add(boardButtons[i][j]);
             
 
                
                boardButtons[i][j].setOpaque(true);
                boardButtons[i][j].setBorderPainted(false);
            }
        }
     

        
        resetButton.addActionListener(this);
        quitButton.addActionListener(this);
        buttonBar.add(resetButton);
        buttonBar.add(quitButton);
        
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.add(statusBar,BorderLayout.SOUTH);
      
        jfrm.add(buttonBar,BorderLayout.NORTH);
        jfrm.add(boardPanel,BorderLayout.CENTER);
        jfrm.setSize(500,500);
        jfrm.setLocation(400,150);
        jfrm.setResizable(false);
        jfrm.setVisible(true);

        reset();
    }

    
    /**
     * reset the board to a random state
     */
    public void reset() {
        gameboard.resetBoard();
        points = 0;
        moves=6;
        setStatus("Points: " + String.valueOf(moves));
        setStatus("Points: " + String.valueOf(points));
        while(gameboard.existsEmptyCell()) {
            gameboard.dropPieces();
            gameboard.eliminateMatches();
        }
        redrawBoard();
    }


    /**
     * 
     * change the status bar text
     */
    public void setStatus(String str) {
        statusBar.setText(str);
    }

    
    /**
     * param handle button presses
     */
    public void actionPerformed(ActionEvent e) {
        setStatus("Points: " + String.valueOf(points));
        switch(e.getActionCommand()) {
            case "Exit":
                System.exit(0);
            case "Reset Board":
                reset();
                break;
            default: /** board piece*/
                String[] cmd = e.getActionCommand().split(" ");
                int cmdrow = Integer.parseInt(cmd[0]);
                int cmdcol = Integer.parseInt(cmd[1]);
                handleClick(cmdrow,cmdcol);
                break;
        }
    }
    

    /**
     * 
     *  handle a click event at (row,col)
     * 
     */
    
    public void handleClick(int row,int col) {
        if(!pieceSelected) {
            pieceSelected = true;
            selectedRow = row;
            selectedCol = col;
            
            return;
        }

        if(pieceSelected && selectedRow==row && selectedCol==col) {
            pieceSelected = false;
            selectedRow = -1;
            selectedCol = -1;
            boardButtons[row][col].setBackground(DESELECTED_COLOR);
            return;
        }

        
        /**
         * if we get here, then a piece is selected and it is not the newly clicked piece
         */
        if(!(gameboard.isValidSwap(row,col,selectedRow,selectedCol))) {
            setStatus("Invalid move");
            
            return;
        }
        points++;
        gameboard.makeSwap(row,col,selectedRow,selectedCol);
        boardButtons[selectedRow][selectedCol].setBackground(DESELECTED_COLOR);
        pieceSelected = false;
        selectedRow = -1;
        selectedCol = -1;
        redrawBoard();
        
        setStatus("Points: " + String.valueOf(points));
        if (points==mustHavePoints) {
        	jfrm.dispose();
        	NextLevelPanel nlp=new NextLevelPanel();
        	
        }
    }

    
    /**
     * re-draw the board from underlying game data
     */
    public void redrawBoard() {
        for(int i=0; i<numRows; i++) {
            for(int j=0; j<numCols; j++) {
            
                boardButtons[i][j].setText(
                   NumberCrush.CELL_LABELS[ gameboard.getValueAt(i,j) ]);
           
                Color colors[] = {Color.green, Color.blue, Color.red, Color.yellow, Color.orange, Color.magenta, Color.pink, Color.white};
                
            	if(boardButtons[i][j].getText().equals("1")) {
            		boardButtons[i][j].setBackground(colors[2]);
            	}
            	if(boardButtons[i][j].getText().equals("2")) {
            		boardButtons[i][j].setBackground(colors[3]);
            	}
            	if(boardButtons[i][j].getText().equals("4")) {
            		boardButtons[i][j].setBackground(colors[4]);
            	}
            	if(boardButtons[i][j].getText().equals("5")) {
            		boardButtons[i][j].setBackground(colors[5]);
            	}
            	if(boardButtons[i][j].getText().equals("3")) {
            		boardButtons[i][j].setBackground(colors[1]);
            	}
            	if(boardButtons[i][j].getText().equals("6")) {
            		boardButtons[i][j].setBackground(colors[6]);
            	}
            	if(boardButtons[i][j].getText().equals("7")) {
            		boardButtons[i][j].setBackground(colors[7]);
            	}
            	if(boardButtons[i][j].getText().equals("8")) {
            		boardButtons[i][j].setBackground(colors[8]);
            	}
        
             
              
            
           
            }
            }
        
    };
    
  
    
   

    
    /**
     * 
     * @param main
     */
    public static void main(String args[])
    {
    	
        new MyPanel( numRows,numCols,max);
       
    }
}
