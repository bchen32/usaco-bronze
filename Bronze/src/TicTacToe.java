import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TicTacToe {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 10/10 Correct
		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\eclipse-workspace\\USACO\\TicTacToe\\10.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));
		String ln1 = in.readLine();
		String ln2 = in.readLine();
		String ln3 = in.readLine();
		String[] lines = {ln1, ln2, ln3};
		int singleWins = 0;
		ArrayList<Integer> prevSingles = new ArrayList<>();
		ArrayList<String> prevPairs = new ArrayList<>();
		int pairWins = 0;
		int[][] board = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = lines[i].substring(j, j+ 1).charAt(0) - 'A' + 1;
			}
		}
		for (int a = 0; a < 3; a++) {
			if (board[a][0] == board[a][1] && board[a][2] == board[a][0] && prevSingles.indexOf(board[a][0]) == -1) {
				prevSingles.add(board[a][0]);
				singleWins++;
			}
		}
		for (int a = 0; a < 3; a++) {
			if (board[0][a] == board[1][a] && board[2][a] == board[0][a] && prevSingles.indexOf(board[0][a]) == -1) {
				prevSingles.add(board[0][a]);
				singleWins++;
			}
		}
		if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && prevSingles.indexOf(board[0][0]) == -1) {
			prevSingles.add(board[0][0]);
			singleWins++;
		}
		if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && prevSingles.indexOf(board[2][0]) == -1) {
			prevSingles.add(board[2][0]);
			singleWins++;
		}
		for (int i = 1; i < 26; i++) {
			for (int j = i + 1; j < 27; j++) {
				for (int a = 0; a < 3; a++) {
					if (board[a][0] == i || board[a][0] == j) {
						if (board[a][1] == i || board[a][1] == j) {
							if (board[a][2] == i || board[a][2] == j) {
								if (prevPairs.indexOf(i + "" + j) == -1 && !(board[a][0] == board[a][1] && board[a][1] == board[a][2])) {
									pairWins++;
									prevPairs.add(i + "" + j);
								}
							}
						}
					}
				}
				for (int a = 0; a < 3; a++) {
					if (board[0][a] == i || board[0][a] == j) {
						if (board[1][a]  == i || board[1][a]  == j) {
							if (board[2][a] == i || board[2][a] == j) {
								if (prevPairs.indexOf(i + "" + j) == -1 && !(board[0][a] == board[1][a] && board[0][a] == board[2][a])) {
									pairWins++;
									prevPairs.add(i + "" + j);
								}
							}
						}
					}
				}
				if ((board[0][0] == i || board[0][0] == j) && (board[1][1] == i || board[1][1] == j) && (board[2][2] == i || board[2][2] == j)) {
					if (prevPairs.indexOf(i + "" + j) == -1 && !(board[0][0] == board[1][1] && board[0][0] == board[2][2])) {
						pairWins++;
						prevPairs.add(i + "" + j);
					}
				}
				if ((board[0][2] == i || board[0][2] == j) && (board[1][1] == i || board[1][1] == j) && (board[2][0] == i || board[2][0] == j)) {
					if (prevPairs.indexOf(i + "" + j) == -1 && !(board[0][2] == board[1][1] && board[0][2] == board[2][0])) {
						pairWins++;
						prevPairs.add(i + "" + j);
					}
				}
			}
		}
		System.out.println(singleWins);
		System.out.println(pairWins);
		out.println(singleWins);
		out.println(pairWins);
		out.close();
		in.close();
	}

}