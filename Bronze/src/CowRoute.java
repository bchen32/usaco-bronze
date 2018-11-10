import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CowRoute {
	
	static int numPlanes;

	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\bench\\git\\USACO-Bronze\\Bronze\\CowRoute\\1.in"));
		BufferedReader in = new BufferedReader(new FileReader("cowroute.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowroute.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		int start = Integer.parseInt(ln.nextToken());
		int dest = Integer.parseInt(ln.nextToken());
		numPlanes = Integer.parseInt(ln.nextToken());
		int cheapestWay = Integer.MAX_VALUE;
		for (int i = 0; i < numPlanes; i++) {
			ln = new StringTokenizer(in.readLine());
			int cost = Integer.parseInt(ln.nextToken());
			int numStops = Integer.parseInt(ln.nextToken());
			ln = new StringTokenizer(in.readLine());
			boolean hasStart = false;
			for (int j = 0; j < numStops; j++) {
				int currStop = Integer.parseInt(ln.nextToken());
				if (currStop == start) {
					hasStart = true;
				}
				if (currStop == dest && hasStart) {
					cheapestWay = Math.min(cheapestWay, cost);
				}
			}
		}
		if (cheapestWay == Integer.MAX_VALUE) {
			out.println(-1);
		} else {
			out.println(cheapestWay);
		}
		out.close();
		in.close();
	}
}