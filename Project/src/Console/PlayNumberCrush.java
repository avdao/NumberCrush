package Console;

import java.util.Random;
import java.util.Scanner;

import Logic.NumberCrush;

public class PlayNumberCrush {
	/**
	 * function for check you win or you lose
	 * @param numPoints the number of points you took in the game
	 */
	 public static void endGame(int numPoints) {
			if(numPoints>=8) {
				System.out.println("You win!");
			}
			else {
				System.out.println("You losee !");
			}
	 }
	 /**
      * function for make a board
      * @param numRows number of rows of board
      * @param numCols number of Columns of board
      * @param board is array who make a board
	  */
	 public static void printMap(int numRows,int numCols,int [][]board) {
		for (int i = 0; i < numRows; i++) {
				for (int j = 0; j < numCols; j++) {
					System.out.print(board[i][j]+" ");
					}
				System.out.println();
			}
		 
	 }
	/**
	 * 
	 * main function for play a game
	 *  @param numRows number of rows of board
	 * @param numCols number of Columns of board
	 * @param numMoves number of Moves you want to play
	 * @param bb is array who make a board game
	 * in start we have do while loop for  destroy the fields until you reach a matrix suitable for starting a game
	 * after that we playing a game
	 * @param row1 x coordinates of first number
	 * @param col1 y coordinates of first number
	 *   @param row2 x coordinates of second  number
	 * @param col2 y coordinates of second number
	 */
 public static void main(String[] args) {
		/**
		 * @author Avdo Dzanic
		 * 
		 */
	    Scanner scanner=new Scanner(System.in);
		int numRows, numCols,numMoves;
		int row1, col1, row2,  col2, maxNum;
		 Random rand = new Random();
		
			
			int numPoints=0;
			System.out.println("Enter the number of rows:");
			numRows = scanner.nextInt();
			System.out.println("Enter the number of colums");
			numCols = scanner.nextInt();
			System.out.println("Enter the number in game(1-7):");
			maxNum = scanner.nextInt();

	
			NumberCrush board=new NumberCrush(numRows,numCols,maxNum);
		
			System.out.println("Enter the Number of Moves you want to play:");
			numMoves = scanner.nextInt();
		
		int [][] bb = board.board;
			
			
		    do {
	            board.dropPieces();
	            board.eliminateMatches();
	        } while(board.existsEmptyCell());
		    printMap(numRows, numCols,bb);
		
			while (numMoves>0) {
				System.out.println("Enter the coordinates for the first number (x,y):");
				/**
				 * @param row1 x coordinates of first number
				 * @param col1 y coordinates of first number
				 */
			    	row1 = scanner.nextInt();
				col1 = scanner.nextInt();
				System.out.println("Enter the coordinates for the first number (x,y):");
				/**
				 * @param row2 x coordinates of second  number
				 * @param col2 y coordinates of second number
				 */
				row2 = scanner.nextInt();
				col2 = scanner.nextInt();
				
				/**
				 * @return true if board.isValidSwap=true
				 * 
				 */
		        if(board.isValidSwap(row1, col1, row2, col2)) {
		        	board.makeSwap(row1, col1, row2, col2);
		        	printMap(numRows, numCols, bb);
		      
		        	
		        	numPoints+=2;
		        	System.out.println("You won:"+numPoints+" Points");
		        	
		        	
		        }
		        else {
		        	System.out.println("Invalid move!");
		        }
		      
		    	numMoves-=1;
		       
		    
					
			     
			        
		
			
		
				
			}
			/**
			 * end game you win or you lose
			 */
		endGame(numPoints);

	}
 


}
