import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Balancing {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		// 10/10 Correct
		BufferedReader in = new BufferedReader(new FileReader("balancing.in"));
		StringTokenizer ln1 = new StringTokenizer(in.readLine());
		int numCows = Integer.parseInt(ln1.nextToken());
		Cow[] cows = new Cow[numCows];
		int best = numCows;
		for (int i = 0; i < numCows; i++) {
			StringTokenizer str = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(str.nextToken());
			int d = Integer.parseInt(str.nextToken());
			Cow temp = new Cow(s, d);
			cows[i] = temp;
		}
		for (int i = 0; i < numCows; i++) {
			for (int j = 0; j < numCows; j++) {
				int vert = cows[i].x + 1;
				int horizontal = cows[j].y + 1;
				int q1 = 0;
				int q2 = 0;
				int q3 = 0;
				int q4 = 0;
				for (int a = 0; a < numCows; a++) {
					if (cows[a].x < vert && cows[a].y < horizontal) {
						q4++;
					} else if (cows[a].x < vert && cows[a].y > horizontal) {
						q1++;
					} else if (cows[a].x > vert && cows[a].y < horizontal) {
						q3++;
					} else if (cows[a].x > vert && cows[a].y > horizontal) {
						q2++;
					}
				}
				if (Math.max(q1, Math.max(q2, Math.max(q3, q4))) < best) {
					best = Math.max(q1, Math.max(q2, Math.max(q3, q4)));
				}
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
		out.print(best);
		System.out.println(best);
		in.close();
		out.close();
	}
	
	static class Cow implements Comparable<Cow> {
		int x;
		int y;
		public Cow(int s, int d) {
			this.x = s;
			this.y = d;
		}
		public int compareTo(Cow other) {
			return x - other.x + y - other.y;
		}
		public String toString() {
			return this.x + "_" + this.y;
		}
	}

}
