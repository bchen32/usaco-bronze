import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Taming {

	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\USACO\\Bronze\\Taming\\6.in"));
		BufferedReader in = new BufferedReader(new FileReader("taming.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer ln = new StringTokenizer(in.readLine());
		int[] counter = new int[n];
		for (int i = 0; i < n; i++) {
			counter[i] = Integer.parseInt(ln.nextToken());
		}
		int[] breakouts = new int[n];
		int lastBreak = 0;
		boolean done = false;
//		0 is uncertain, 1 is breakout, 2 is no breakout
		breakouts[0] = 1;
		int breaks = 1;
		for (int i = 1; i < n; i++) {
			if (counter[i] != -1) {
				int breakDay = i - counter[i];
				if (breakouts[breakDay] == 2) {
					out.println(-1);
					done = true;
					break;
				} else if (breakDay < lastBreak) {
					done = true;
					out.println(-1);
					break;
				} else if (lastBreak == breakDay) {
					for (int j = lastBreak + 1; j < i + 1; j++) {
						breakouts[j] = 2;
					}
				} else {
					breakouts[breakDay] = 1;
					breaks++;
					for (int j = breakDay + 1; j < i + 1; j++) {
						breakouts[j] = 2;
					}
				}
				lastBreak = breakDay;
				if (counter[i] != 0) {
					breakouts[i] = 2;
				}
			}
		}
		if (!done) {
			out.print(breaks + " ");
			for (int i = 0; i < n; i++) {
				if (breakouts[i] == 0) {
					breaks++;
				}
			}
			out.println(breaks);
		}
		out.close();
		in.close();
	}
}
