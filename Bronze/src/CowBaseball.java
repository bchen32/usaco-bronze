import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CowBaseball {
	
	static int n;
	static int numCombs = 0;

	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\Workspace\\Bronze\\CowBaseball\\10.in"));
		BufferedReader in = new BufferedReader(new FileReader("baseball.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("baseball.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		n = Integer.parseInt(ln.nextToken());
		int[] cowPositions = new int[n];
		for (int i = 0; i < n; i++) {
			cowPositions[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(cowPositions);
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					int[] triplets = {cowPositions[i], cowPositions[j], cowPositions[k]};
					if (isValid(triplets) == 0) {
						numCombs++;
					} else if (isValid(triplets) == 1) {
						break;
					}
				}
			}
		}
		out.println(numCombs);
		out.close();
		in.close();
	}
	
	static int isValid(int[] triplet) {
//		0 means that it is ok, 1 means that yz is too big, 2 means yz is too small
		int yz = triplet[2] - triplet[1];
		int xy = triplet[1] - triplet[0];
		if (yz < xy) {
			return 2;
		} else if (yz > 2 * xy) {
			return 1;
		} else {
			return 0;
		}
	}
}