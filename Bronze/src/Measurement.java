import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Measurement {

	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\USACO\\Bronze\\Measurement\\6.in"));
		BufferedReader in = new BufferedReader(new FileReader("measurement.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(ln.nextToken());
		int[] cows = new int[3];
		Arrays.fill(cows, 7);
//		Bessie 0
//		Elsie 1
//		Mildred 2
		Measure[] measurements = new Measure[n];
		for (int i = 0; i < n; i++) {
			ln = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(ln.nextToken());
			String temp = ln.nextToken();
			int b;
			if (temp.equals("Bessie")) {
				b = 0;
			} else if (temp.equals("Elsie")) {
				b = 1;
			} else {
				b = 2;
			}
			int c = Integer.parseInt(ln.nextToken());
			measurements[i] = new Measure(a, b, c);
		}
		Arrays.sort(measurements);
		int changes = 0;
		int best = 7;
		boolean[] board = new boolean[3];
		Arrays.fill(board, true);
		for (int i = 0; i < n; i++) {
			cows[measurements[i].cow] += measurements[i].change;
			best = 0;
			for (int j = 0; j < 3; j++) {
				best = Math.max(best, cows[j]);
			}
			boolean[] temp = new boolean[3];
			boolean changed = false;
			for (int j = 0; j < 3; j++) {
				if (cows[j] == best) {
					temp[j] = true;
				} else {
					temp[j] = false;
				}
				if (temp[j] != board[j]) {
					changed = true;
				}
				board[j] = temp[j];
			}
			if (changed) {
				changes++;
			}
		}
		out.println(changes);
		out.close();
		in.close();
	}
	
	static class Measure implements Comparable<Measure> {
		int day;
		int cow;
		int change;
		
		public Measure(int a, int b, int c) {
			day = a;
			cow = b;
			change = c;
		}

		public int compareTo(Measure other) {
			// TODO Auto-generated method stub
			return Integer.compare(this.day, other.day);
		}
	}
}
