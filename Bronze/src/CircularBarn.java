import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CircularBarn {

	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\eclipse-workspace\\USACO\\PLACEHOLD\\1.in"));
		BufferedReader in = new BufferedReader(new FileReader("cbarn.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(ln.nextToken());
		int[] order = new int[n];
		int total = 0;
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(in.readLine());
			total += temp;
			order[i] = temp;
		}
		int smallest = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int current = simulate(order, 0, i, i, total);
			if (current < smallest) {
				smallest = current;
			}
		}
		out.println(smallest);
		out.close();
		in.close();
	}
	
	public static int simulate(int[] arr, int distance, int startIndex, int index, int t) {
		if (index == startIndex - 1) {
			return distance;
		} else if (index == arr.length - 1 && startIndex == 0) {
			return distance;
		}
		distance += t - arr[index];
		t -= arr[index];
		if (index == arr.length - 1) {
			index = 0;
		} else {
			index++;
		}
		return simulate(arr, distance, startIndex, index, t);
	}
}
