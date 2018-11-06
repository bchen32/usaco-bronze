import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Folding {

	static int n;
	static int l;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\Workspace\\Bronze\\Folding\\10.in"));
//		BufferedReader in = new BufferedReader(new FileReader("folding.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("folding.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		n = Integer.parseInt(ln.nextToken());
		l = Integer.parseInt(ln.nextToken()) + 1;
		boolean[] knots = new boolean[l];
		for (int i = 0; i < n; i++) {
			knots[Integer.parseInt(in.readLine())] = true;
		}
		int numWays = 0;
//		No endpoints
		for (double i = 0.5; i < l - 1; i += 0.5) {
			boolean good = false;
			if (i % 1 == 0) {
				for (int j = 0; i + j < l && i - j >= 0; j++) {
					int side1 = (int) (i + j);
					int side2 = (int) (i - j);
					if (knots[side1] == knots[side2]) {
						good = true;
					} else {
						good = false;
						break;
					}
				}
			} else {
				for (double j = 0.5 ; i + j < l && i - j >= 0; j++) {
					int side1 = (int) (i + j);
					int side2 = (int) (i - j);
					if (knots[side1] == knots[side2]) {
						good = true;
					} else {
						good = false;
						break;
					}
				}
			}
			if (good) {
				numWays++;
			}
		}
		System.out.println(numWays);
		out.close();
		in.close();
	}
}