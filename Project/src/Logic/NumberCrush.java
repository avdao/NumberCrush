package Logic;

import java.util.Random;


/**
 * @author Avdo Dzanic
 * 
 */
public class NumberCrush {
	 public static final int CELL_EMPTY = 0;   /** @param CELL_EMPTY is for empty cell */
	  static int max;
	     public static final int CELL_ONE = 1;       /** @param CELL_ONE is for "1" */
	    public static final int CELL_TWO = 2;    /** @param CELL_TWO is for "2" */
	    public static final int CELL_THREE = 3;       /** @param CELL_THREE is for "3" */
	    public static final int CELL_FOUR = 4; /** @param CELL_FOUR is for "4" */
	    public static final int CELL_FIVE = 5;     /** @param CELL_FIVE is for "5" */
	    public static final int CELL_SIX = 6;     /** @param CELL_SIX is for "6" */
	    public static final int CELL_SEVEN = 7;     /** @param CELL_SEVEN is for "7" */
	    public static final int CELL_EIGHT = 8;     /** @param CELL_EIGHT is for "8" */
	    public static  String[] CELL_LABELS = {" ","1","2","3","4","5","6","7","8"};
	    static final int CELL_MIN = CELL_ONE;
	    static final int CELL_MAX = max;
	    int numRows,numCols;
	     public int[][] board;
		
	
	    public Random rand=new Random();
	 /**
	  * Constructor for make a board
	  * @param NumberCrush 
	  * @param numRows return number of rows on board
	  * @param numCols return number of columns on board
	  * @param max is return how much numbers we want in game
	  * 
	  */
	    
	    public NumberCrush(int numRows, int numCols,int max)
	    {
	        this.numRows = numRows;
	        this.numCols = numCols;
	        this.max=max;
	        board = new int[numRows][numCols];
	        for(int i=0;i < numRows; i++) {
	            for(int j=0;j < numCols; j++) {
	            	board[i][j] = rand.nextInt(max);
	            
	            
	             
	            }
	  
	        }
	    }

	    /**
	     * Construct a copy of an existing board
	     * @param oldBoard get a info of firstBoard
	     * @param numRows get numRows of firstboard
	     * @param numCols  get numCols of firstboard
	     * 
	     */
	     
	    public NumberCrush(NumberCrush oldBoard) {
	        numRows = oldBoard.getNumRows();
	        numCols = oldBoard.getNumCols();
	        board = new int[numRows][numCols];
	        for(int i=0;i < numRows; i++) {
	            for(int j=0;j < numCols; j++) {
	                board[i][j] = oldBoard.board[i][j];
	            }
	        }
	    }

	    /**
	     * 
	     * @return numRows
	     */
	    public int getNumRows() {
	        return numRows;
	    }
	    /**
	     * 
	     * @return numCols
	     */
	    public int getNumCols() {
	        return numCols;
	    }
	    


	    /**
	     *set the entire board to empty cells
	     */
	    
	    public void resetBoard() {
	        for(int i=0;i < numRows; i++) {
	            for(int j=0;j < numCols; j++) {
	                board[i][j] = CELL_EMPTY;
	            }
	        }
	    }

	    /**
	     * 
	    
	     * @return value et Board when we make emptyBoard;
	     */
	    public int getValueAt(int row, int col) {
	        return board[row][col];
	    }

	    /**
	     * let all pieces fall to the bottom under gravity, then let in new ones from the top drawn randomly
	     */
	     
	    public void dropPieces() {
	        // work column by column
	        for(int j=0; j<numCols; j++) {
	            int[] thisCol = new int[numRows];
	            for(int i=0;i<numRows;i++) {
	                thisCol[i] = CELL_EMPTY;
	            }
	            
	            int targetIndex = numRows - 1;
	            for(int i=numRows-1; i>=0; i--) {
	                if(board[i][j] != CELL_EMPTY) {
	                    thisCol[targetIndex] = board[i][j];
	                    targetIndex--;
	                }
	            }

	            while(targetIndex >= 0) {
	                thisCol[targetIndex] = new Random().nextInt(max)+1;
	                targetIndex--;
	            }

	            for(int i=0;i<numRows;i++) {
	                board[i][j] = thisCol[i];
	            }
	        }
	    }
	    
	  

	  /**
	   *    
	   * @return check if there exists an empty cell
	   */
	    public boolean existsEmptyCell() {
	        boolean emptyCellFound = false;

	        for(int i=0;i < numRows; i++) {
	            for(int j=0;j < numCols; j++) {
	                if(board[i][j] == CELL_EMPTY) {
	                    emptyCellFound = true;
	                }
	            }
	        }
	        
	        return emptyCellFound;
	    }

	    /**
	     * eliminate any 3 consecutive matching pieces
	     */
	    
	    public void eliminateMatches() {
	        for(int i=0;i<numRows;i++) {
	            for(int j=0;j<numCols;j++) {
	            	/**
	            	 * 3 in a row
	            	 */
	                
	                if(0<j && j<numCols-1) {
	                    if(board[i][j-1] == board[i][j] &&
	                                board[i][j+1] == board[i][j]) {
	                        board[i][j] = CELL_EMPTY;
	                        board[i][j-1] = CELL_EMPTY;
	                        board[i][j+1] = CELL_EMPTY;
	                        System.out.println("We have a cross section: "+"("+i+","+j+"),("+i+","+(j-1)+"),("+i+","+(j+1)+")");
	                    }
	                }

	                /**
	                 * 3 in col
	                 */
	                if(0<i && i<numRows-1) {
	                    if(board[i-1][j] == board[i][j] &&
	                                board[i+1][j] == board[i][j]) {
	                        board[i][j] = CELL_EMPTY;
	                        board[i-1][j] = CELL_EMPTY;
	                        board[i+1][j] = CELL_EMPTY;
	                        System.out.println("We have a cros section: "+"("+i+","+j+"),("+i+","+(j-1)+"),("+i+","+(j+1)+")");
	                    }
	                }
	            }
	        }
	    }

	    /**
	     * 
	     *  check whether the given swap is valid.
	     *  return true if swap is valid
	     * returns False if swap is invalid Move 
	     * 
	     * @param toyBoard constructor in which the role is not visible becuase it is activated when cross section occrus,
	     * @param toyBoard the elements fall in such a way that the cross section can be repeated  ,the toyBoard eliminates them
	     * @param row1 and col1 is coordinates for first Number
	     * @param row2 and col2 is coordinates for second Number
	     */

	   
	    public boolean isValidSwap(int row1,int col1,int row2,int col2) {
	        if(row1==row2 && Math.abs(col1-col2)==1) {
	            // ok
	        	System.out.println("Odlican Potez nastavi dalje....");
	        	  NumberCrush toyBoard = new NumberCrush(this);
	  	        
	  	        toyBoard.eliminateMatches();
	  	 

	  	        int tmp = toyBoard.board[row1][col1];
	  	        toyBoard.board[row1][col1] = toyBoard.board[row2][col2];
	  	        toyBoard.board[row2][col2] = tmp;
	  	        toyBoard.eliminateMatches();
	  	        if(toyBoard.existsEmptyCell()) {
	  	            return true;
	  	        } else {
	  	            return false;
	  	        }
	        
	        } else if (col1==col2 && Math.abs(row1-row2)==1) {
	            // ok
	        	  NumberCrush toyBoard = new NumberCrush(this);
	  	        
	  	        toyBoard.eliminateMatches();
	  	    

	  	        int tmp = toyBoard.board[row1][col1];
	  	        toyBoard.board[row1][col1] = toyBoard.board[row2][col2];
	  	        toyBoard.board[row2][col2] = tmp;
	  	        toyBoard.eliminateMatches();
	  	        if(toyBoard.existsEmptyCell()) {
	  	            return true;
	  	        } else {
	  	            return false;
	  	        }
	        } else {
	        	
	        	return false;
	      
	        	 }
	       
	        

	      
	    }
/**
 * swap the given pieces, then call eliminateMatches() and then dropPieces()
	    until no matches exist
 * @param tmp an auxilary variable when making a swap
 * 
 */

	    public void makeSwap(int row1,int col1,int row2,int col2) {
	        int tmp = board[row1][col1];
	        board[row1][col1] = board[row2][col2];
	        board[row2][col2] = tmp;
	        do {
	            dropPieces();
	            eliminateMatches();
	        } while(existsEmptyCell());
	    }

}
