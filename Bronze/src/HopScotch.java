import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HopScotch {
	static int numRows;
	static int numCols;
	static int numWays = 0;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\USACO\\Bronze\\PLACEHOLD\\1.in"));
		BufferedReader in = new BufferedReader(new FileReader("hopscotch.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hopscotch.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		numRows = Integer.parseInt(ln.nextToken());
		numCols = Integer.parseInt(ln.nextToken());
//		True is red, false is blue
		boolean[][] grid = new boolean[numRows][numCols];
		for (int i = 0; i < numRows; i++) {
			String line = in.readLine();
			for (int j = 0; j < numCols; j++) {
				if (line.substring(j, j + 1).equals("R")) {
					grid[i][j] = true;
				}
			}
		}
		simulate(grid, 0, 0);
		out.println(numWays);
		out.close();
		in.close();
	}
	
	public static boolean canJump (boolean[][] board, int currRow, int currCol, int row, int col) {
		if (board[row][col] != board[currRow][currCol] && row > currRow && col > currCol) {
			return true;
		}
		return false;
	}
	
	public static void simulate (boolean[][] board, int currRow, int currCol) {
		if (currRow == numRows - 1 && currCol == numCols - 1) {
			numWays++;
			return;
		}
		for (int i = currRow + 1; i < numRows; i++) {
			for (int j = currCol + 1; j < numCols; j++) {
				if (canJump(board, currRow, currCol, i, j)) {
					simulate(board, i, j);
				}
			}
		}
	}
}