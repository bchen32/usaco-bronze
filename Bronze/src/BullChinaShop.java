import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BullChinaShop {

	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\USACO\\Bronze\\PLACEHOLD\\1.in"));
		BufferedReader in = new BufferedReader(new FileReader("bcs.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcs.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(ln.nextToken());
		int k = Integer.parseInt(ln.nextToken());
		boolean[][][] original = new boolean[2][n][n];
		boolean[][][] broken = new boolean[k][n][n];
		int supposed = 0;
		for (int i = 0; i < n; i++) {
			String temp = in.readLine();
			for (int j = 0; j < n; j++) {
				String piece = temp.substring(j, j + 1);
				if (piece.equals(".")) {
					original[0][i][j] = false;
				} else {
					original[0][i][j] = true;
					supposed++;
				}
			}
		}
		for (int p = 0; p < k; p++) {
			for (int i = 0; i < n; i++) {
				String temp = in.readLine();
				for (int j = 0; j < n; j++) {
					String piece = temp.substring(j, j + 1);
					if (piece.equals(".")) {
						broken[p][i][j] = false;
					} else {
						broken[p][i][j] = true;
					}
				}
			}
		}
//		Iterate through every pair
		for (int a = 0; a < k; a++) {
			for (int b = a + 1; b < k; b++) {
//				Iterate through every possible shift
				for (int aXT = -n + 1; aXT < n; aXT++) {
					for (int aYT = -n + 1; aYT < n; aYT++) {
						for (int bXT = -n + 1; bXT < n; bXT++) {
							for (int bYT = -n + 1; bYT < n; bYT++) {
								boolean check = true;
								int covered = 0;
								for (int x = 0; x < n && check; x++) {
									for (int y = 0; y < n && check; y++) {
										int aXS = aXT + x;
										int aYS = aYT + y;
										int bXS = bXT + x;
										int bYS = bYT + y;
										boolean isPieceA = broken[a][x][y];
										boolean inRangeA = aXS > - 1 && aXS < n && aYS > -1 && aYS < n;
										boolean isPieceB = broken[b][x][y];
										boolean inRangeB = bXS > - 1 && bXS < n && bYS > -1 && bYS < n;
										if ((!inRangeA && isPieceA) || (!inRangeB && isPieceB)) {
											check = false;
										}
										if (inRangeA && isPieceA) {
											if (original[0][aXS][aYS]) {
												if (original[1][aXS][aYS]) {
													check = false;
												} else {
													covered++;
													original[1][aXS][aYS] = true;
												}
											} else {
												check = false;
											}
										}
										if (inRangeB && isPieceB) {
											if (original[0][bXS][bYS]) {
												if (original[1][bXS][bYS]) {
													check = false;
												} else {
													covered++;
													original[1][bXS][bYS] = true;
												}
											} else {
												check = false;
											}
										}
									}
								}
								for (int i = 0; i < n; i++) {
									original[1][i] = new boolean[n];
								}
								if (covered == supposed && check) {
									out.println((a + 1) + " " + (b + 1));
								}
							}
						}
					}
				}
			}
		}
		out.close();
		in.close();
	}
}
