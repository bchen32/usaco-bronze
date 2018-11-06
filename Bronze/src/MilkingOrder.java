import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MilkingOrder {
	static int n;
	static int m;
	static int k;
	static boolean[] usedCows;
	static boolean[] usedPos;
	static Cow[] fixed;
	static int[] pos;

	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\USACO\\Bronze\\MilkOrder\\4.in"));
		BufferedReader in = new BufferedReader(new FileReader("milkorder.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkorder.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		n = Integer.parseInt(ln.nextToken());
		m = Integer.parseInt(ln.nextToken());
		k = Integer.parseInt(ln.nextToken());
		usedCows = new boolean[n];
		usedPos = new boolean[n];
		fixed = new Cow[n];
		pos = new int[n];
		int[] socialOrder = new int[m];
		ln = new StringTokenizer(in.readLine());
		for (int i = 0; i < m; i++) {
			socialOrder[i] = Integer.parseInt(ln.nextToken()) - 1;
		}
		for (int i = 0; i < k; i++) {
			ln = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(ln.nextToken());
			int b = Integer.parseInt(ln.nextToken());
			fixed[i] = new Cow(a - 1, b - 1);
		}
		k++;
		for (int i = 0; i < n; i++) {
			fixed[k - 1] = new Cow(0, i);
			if(check(socialOrder)) {
				out.println(i + 1);
				break;
			}
		}
		out.close();
		in.close();
	}
	
	static boolean check(int[] social) {
		usedCows = new boolean[n];
		usedPos = new boolean[n];
		for (int i = 0; i < k; i++) {
			if (usedCows[fixed[i].cow] && (pos[fixed[i].cow] == fixed[i].pos)) {
				continue;
			}
			if (usedCows[fixed[i].cow]) {
				return false;
			}
			if (usedPos[fixed[i].pos]) {
				return false;
			}
			usedCows[fixed[i].cow] = true;
			usedPos[fixed[i].pos] = true;
			pos[fixed[i].cow] = fixed[i].pos;
		}
		int j = 0;
		for (int i = 0; i < m; i++) {
			int cow = social[i];
			if (usedCows[cow]) {
				if (j > pos[cow]) {
					return false;
				}
				j = pos[cow];
				continue;
			}
			while (usedPos[j]) {
				j++;
				if (j == n) {
					return false;
				}
			}
			usedPos[j] = true;
			pos[cow] = j;
		}
		return true;
	}
	
	static class Cow {
		int cow;
		int pos;
		
		public Cow(int a, int b) {
			cow = a;
			pos = b;
		}
	}
}
