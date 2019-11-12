import java.util.Arrays;

public class PegSolitaire4 {

	
	public static String tryMove(int[][] pegs, int startX, int startY,int jumpX,int jumpY, int endX, int endY) {
		int[][] board;
		//making sure we are in bounds
		if (endX >= board.length || endX < 0 ||
			endY >= board[endX].length || endY < 0) {			
			return null;
		}
		// Then make sure space is empty at the end
		if (board[endX][endY] != 0) {
			//trying to make a move(4 moves maybe? up, down,left right)
			//left
			pegs[endX][endY] = pegs[startX-2][startY];
			return "";
		}
		// Let's try to make the move!
		
		// Finish solving with recursion...
		boolean didSolve = solve(board, endX, endY);
		if (!didSolve) {
			// We hit a dead end!
			// We must clean up our little mess.
			// (If everyone cleans up their own mess,
			// we won't clean up anyone else's mess.)
			// The only shared state that changed
			// was the board on line 24.
			board[endX][endY] = 0;
			return false;
		} else {
			// Hey, we solved it!
			// Leave it as it is. Let everyone see
			// the solution.
			return true;
		}
	}
	/**
	 * Solve the board recursively given that the
	 * knight is at location x, y.
	 * @param board
	 * @param x
	 * @param y
	 */
	public static boolean solve(int[][] pegs) {
		int x,y;// location of the pegs 
		int moves=0;//number of moves one can make
		
		// Wait, is it solved already?
		// Check if all the spaces are filled...
		if (board[x][y] == board.length*board[0].length) {
			// For this problem, this means that
			// board must be filled (all width*height
			// spaces are filled)
			return true;
		}
		// Make a move from x, y to a possible choice
		// Spell out all 8 possibilities
		// x+1,y-2
		// Make sure that the move is in bounds...
		if (tryMove(board, x, y, x+1, y-2)) {
			return true; // Yay!
		}
		// x-1,y-2
		if (tryMove(board, x, y, x-1, y-2)) {
			return true; // Yay!
		}
		// x+1,y-2
		// Make sure that the move is in bounds...
		if (tryMove(board, x, y, x+1, y+2)) {
			return true; // Yay!
		}
		// x-1,y-2
		if (tryMove(board, x, y, x-1, y+2)) {
			return true; // Yay!
		}

		// x+2,y-1
		// Make sure that the move is in bounds...
		if (tryMove(board, x, y, x+2, y-1)) {
			return true; // Yay!
		}
		// x-2,y-1
		if (tryMove(board, x, y, x-2, y-1)) {
			return true; // Yay!
		}
		// x+2,y-1
		// Make sure that the move is in bounds...
		if (tryMove(board, x, y, x+2, y+1)) {
			return true; // Yay!
		}
		// x-2,y-1
		if (tryMove(board, x, y, x-2, y+1)) {
			return true; // Yay!
		}
		// Tried all single moves and failed
		return false;
	}
	
	
	public static void main(String[] args) {
		int width = 5, height = 5;
		// NOTE!!! First axis is X axis for us
		int[][] board = new int[width][height];
		// Full of... zeros.
		// Start the knight in the upper left corner.
		// Keep track of the visited positions in
		// order. 1st position has 1. Second has a 2.
		// Count our way up to width*height.
		// Zero means a space hasn't been visited.
		board[1][2] = 1;
		System.out.println(solve(board, 1, 2));
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}

}
