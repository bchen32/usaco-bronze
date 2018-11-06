import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Speeding {

	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\USACO\\Bronze\\PLACEHOLD\\1.in"));
		BufferedReader in = new BufferedReader(new FileReader("speeding.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(ln.nextToken());
		int m = Integer.parseInt(ln.nextToken());
		int[] roads = new int[100];
		int[] speeds = new int[100];
		int pos = 0;
		for (int i = 0; i < n; i++) {
			ln = new StringTokenizer(in.readLine());
			int length = Integer.parseInt(ln.nextToken());
			int limit = Integer.parseInt(ln.nextToken());
			for (int j = 0; j < length; j++) {
				roads[pos] = limit;
				pos++;
			}
		}
		pos = 0;
		for (int i = 0; i < m; i++) {
			ln = new StringTokenizer(in.readLine());
			int length = Integer.parseInt(ln.nextToken());
			int speed = Integer.parseInt(ln.nextToken());
			for (int j = 0; j < length; j++) {
				speeds[pos] = speed;
				pos++;
			}
		}
		int worst = 0;
		for (int i = 0; i < 100; i++) {
			if (speeds[i] > roads[i]) {
				worst = Math.max(worst, speeds[i] - roads[i]);
			}
		}
		out.println(worst);
		out.close();
		in.close();
	}
}
