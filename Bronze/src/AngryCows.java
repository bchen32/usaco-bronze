import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class AngryCows {

	static boolean[] used;
	static int explosions = 1;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\USACO\\Bronze\\AngryCows\\5.in"));
		BufferedReader in = new BufferedReader(new FileReader("angry.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
		int n = Integer.parseInt(in.readLine());
		int[] haybales = new int[n];
		used = new boolean[n];
		for (int i = 0; i < n; i++) {
			haybales[i] = Integer.parseInt(in.readLine());
		}
		int best = 0;
		Arrays.sort(haybales);
		for (int i = 0; i < n; i++) {
			explode(haybales, i, 1);
			best = Math.max(best, explosions);
			explosions = 1;
			used = new boolean[n];
		}
		out.println(best);
		out.close();
		in.close();
	}
	
	static void explode(int[] bales, int index, int blast) {
		used[index] = true;
		int bottom = bales[index] - blast;
		int top = bales[index] + blast;
		ArrayList<Integer> explodeIndexes = new ArrayList<Integer>();
		for (int i = 0; i < bales.length; i++) {
			if (bales[i] >= bottom && bales[i] <= top && !used[i]) {
				explosions++;
				used[i] = true;
				explodeIndexes.add(i);
			}
			if (bales[i] > top) {
				break;
			}
		}
		for (int i = 0; i < explodeIndexes.size(); i++) {
			explode(bales, explodeIndexes.get(i), blast + 1);
		}
		return;
	}
}
