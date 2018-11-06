import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

public class CircleCross {

	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\USACO\\Bronze\\PLACEHOLD\\1.in"));
		BufferedReader in = new BufferedReader(new FileReader("circlecross.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));
		String input = in.readLine();
		char[] a = input.toCharArray();
		int[] points = new int[52];
		for (int i = 0; i < 52; i++) {
			points[i] = (int) a[i] - 'A';
		}
		int overlaps = 0;
		HashSet<Integer> alreadyCalc = new HashSet<Integer>();
		for (int i = 0; i < 52; i++) {
//			Start is the starting value
			int val = points[i];
			if (alreadyCalc.contains(val)) {
				continue;
			}
			alreadyCalc.add(val);
			int k = i + 1;
			int end = 0;
			boolean clockwise = false;
			while (true) {
				if (points[k % 52] == val) {
					end = k;
					if (k < i + 26) {
						clockwise = true;
					}
					break;
				}
				k++;
			}
			HashSet<Integer> temps = new HashSet<Integer>();
			if (clockwise) {
				for (int j = i + 1; j < end; j++) {
					int curr = points[j % 52];
					if (temps.contains(curr)) {
//						Same cow enters and exits without crossing
						overlaps--;
					} else {
						overlaps++;
						temps.add(curr);
					}
				}
			} else {
				int j = i - 1;
				if (j < 1) {
					j = 52 + j;
				}
				while (j != end) {
					if (j == 0) {
						j = 52;
					}
					int curr = points[j % 52];
					if (temps.contains(curr)) {
//						Same cow enters and exits without crossing
						overlaps--;
					} else {
						temps.add(curr);
						overlaps++;
					}
					j--;
				}
			}
		}
		out.println(overlaps / 2);
		out.close();
		in.close();
	}
}
