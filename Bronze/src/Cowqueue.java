import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Cowqueue {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		// 10/10 Correct
//		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\eclipse-workspace\\USACO\\Cowqueue\\10.in"));
		BufferedReader in = new BufferedReader(new FileReader("cowqueue.in"));
		int numCows = Integer.parseInt(in.readLine());
		Cow[] cows = new Cow[numCows];
		
		for (int i = 0; i < numCows; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int duration = Integer.parseInt(st.nextToken());
			Cow temp = new Cow(start, duration);
			cows[i] = temp;
		}
		Arrays.sort(cows);
		
		int time = 0;
		
		for (int i = 0; i < numCows; i++) {
			if (cows[i].s > time) {
				time = cows[i].s + cows[i].d;
			} else {
				time += cows[i].d;
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));
		out.print(time);
		System.out.println(time);
		in.close();
		out.close();
	}
	
	static class Cow implements Comparable<Cow> {
		int s;
		int d;
		public Cow(int s, int d) {
			this.s = s;
			this.d = d;
		}
		public int compareTo(Cow other) {
			return s - other.s;
		}
		public String toString() {
			return this.s + "_" + this.d;
		}
	}
}
