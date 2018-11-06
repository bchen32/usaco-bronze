import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Hoofball {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 10/10 Correct
//		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\eclipse-workspace\\USACO\\hoofball\\2.in"));
		BufferedReader in = new BufferedReader(new FileReader("hoofball.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
		StringTokenizer ln1 = new StringTokenizer(in.readLine());
		StringTokenizer ln2 = new StringTokenizer(in.readLine());
		int numCows = Integer.parseInt(ln1.nextToken());
		int[] distances = new int[numCows];
		for (int i = 0; i < numCows; i++) {
			distances[i] = Integer.parseInt(ln2.nextToken());
		}
		Arrays.sort(distances);
		out.print(calc(distances));
		out.close();
		in.close();
	}
	
	public static int calc(int[] arr) {
		// TRUE = RIGHT
		// FALSE = LEFT
		int cows = arr.length;
		boolean[] dir = new boolean[cows];
		dir[0] = true;
		dir[cows - 1] = false;
		for (int i = 1; i < cows - 1; i++) {
			if ((arr[i] - arr[i - 1]) > (arr[i + 1] - arr[i])) {
				dir[i] = true;
			} else {
				dir[i] = false;
			}
		}
		int res = 0, i = 0;
		// Sweep through the data.
		while (i < cows) {
			// Rights.
			int rCnt = 0;
			while (dir[i]) {
				i++;
				rCnt++;
			}
			// Lefts
			int lCnt = 0;
			while (i < cows && !dir[i]) {
				i++;
				lCnt++;
			}
			// We must come from both sides.
			if (rCnt > 1 && lCnt > 1)
				res += 2;
			// Good enough to come from one side.
			else
				res++;
		}
		return res;
	}
}
