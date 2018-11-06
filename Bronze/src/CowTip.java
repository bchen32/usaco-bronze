import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CowTip {

	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\eclipse-workspace\\USACO\\PLACEHOLD\\1.in"));
		BufferedReader in = new BufferedReader(new FileReader("cowtip.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(ln.nextToken());
		boolean[][] cows = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String tempLn = in.readLine();
			for (int j = 0; j < n; j++) {
				int temp = Integer.parseInt(Character.toString(tempLn.charAt(j)));
				if (temp == 1) {
					cows[i][j] = true;
				} else {
					cows[i][j] = false;
				}
			}
		}
		out.println(flip(cows, 0, n - 1, n - 1));
		out.close();
		in.close();
	}
	
	public static int flip(boolean[][] arr, int numFlips, int botR, int botC) {
		if (arr[botR][botC]) {
			for (int i = 0; i <= botR; i++) {
				for (int j = 0; j <= botC; j++) {
					arr[i][j] = !arr[i][j];
				}
			}
			numFlips++;
		}
		if (botR == 0) {
			if (botC == 0) {
				return numFlips;
			} else {
				botR = arr.length - 1;
				botC--;
			}
		} else {
			botR--;
		}
		return flip(arr, numFlips, botR, botC);
	}
}
