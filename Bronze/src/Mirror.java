import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Mirror {

	static final int UP = 0;
	static final int DOWN = 1;
	static final int LEFT = 2;
	static final int RIGHT = 3;

	static int ROWS;
	static int COLS;

	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\bench\\git\\USACO-Bronze\\Bronze\\Mirror\\10.in"));
		BufferedReader in = new BufferedReader(new FileReader("mirror.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mirror.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		ROWS = Integer.parseInt(ln.nextToken());
		COLS = Integer.parseInt(ln.nextToken());
		int[][] grid = new int[ROWS][COLS];
		// 0 is \ and 1 is /
		for (int r = 0; r < ROWS; r++) {
			String line = in.readLine();
			for (int c = 0; c < COLS; c++) {
				String str = line.substring(c, c + 1);
				if (str.equals("/")) {
					grid[r][c] = 1;
				}
			}
		}
		boolean infiniteLoop = false;
		int mostTimes = 0;
		for (int r = 0; r < ROWS && !infiniteLoop; r++) {
			int a = simulate(grid, r, 0, RIGHT);
			int b = simulate(grid, r, COLS - 1, LEFT);
			if (a == -1 || b == -1) {
				infiniteLoop = true;
			}
			mostTimes = Math.max(mostTimes, Math.max(a, b));
		}
		for (int c = 0; c < COLS && !infiniteLoop; c++) {
			int a = simulate(grid, 0, c, DOWN);
			int b = simulate(grid, ROWS - 1, c, UP);
			if (a == -1 || b == -1) {
				infiniteLoop = true;
			}
			mostTimes = Math.max(mostTimes, Math.max(a, b));
		}
		out.println(mostTimes);
		out.close();
		in.close();
	}

	static int simulate(int[][] grid, int r, int c, int dir) {
		int times = 0;
		while (true) {
			if (!inBounds(r, c)) {
				return times;
			}
			if (times > ROWS * COLS) {
				// If you've taken more steps than mirrors, it's infinite
				return -1;
			}
			times++;
			if (dir == UP) {
				if (grid[r][c] == 1) {
					// Mirror 1 would send it right
					r += 0;
					c += 1;
					dir = RIGHT;
				} else {
					// Mirror 0 would send it left
					r += 0;
					c += -1;
					dir = LEFT;
				}
			} else if (dir == DOWN) {
				if (grid[r][c] == 1) {
					// Mirror 1 would send it left
					r += 0;
					c += -1;
					dir = LEFT;
				} else {
					// Mirror 0 would send it right
					r += 0;
					c += 1;
					dir = RIGHT;
				}
			} else if (dir == LEFT) {
				if (grid[r][c] == 1) {
					// Mirror 1 would send it down
					r += 1;
					c += 0;
					dir = DOWN;
				} else {
					// Mirror 0 would send it up
					r += -1;
					c += 0;
					dir = UP;
				}
			} else if (dir == RIGHT) {
				if (grid[r][c] == 1) {
					// Mirror 1 would send it up
					r += -1;
					c += 0;
					dir = UP;
				} else {
					// Mirror 0 would send it down
					r += 1;
					c += 0;
					dir = DOWN;
				}
			}
		}
	}

	static boolean inBounds(int r, int c) {
		if (r < ROWS && r >= 0 && c < COLS && c >= 0) {
			return true;
		}
		return false;
	}
}