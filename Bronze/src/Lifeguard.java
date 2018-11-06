import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Lifeguard {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		// 10/10 Correct
		BufferedReader in = new BufferedReader(new FileReader("lifeguards.in"));
		StringTokenizer ln1 = new StringTokenizer(in.readLine());
		int lifeguards = Integer.parseInt(ln1.nextToken());
		Cow[] cows = new Cow[lifeguards];
		int[] time = new int[1001];
		int best = 1001;
		for (int i = 0; i < lifeguards; i++) {
			StringTokenizer str = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(str.nextToken());
			int e = Integer.parseInt(str.nextToken());
			Cow temp = new Cow(s, e);
			cows[i] = temp;	
		}
		for (int i = 0; i < lifeguards; i++) {
			for (int j = 0; j < lifeguards; j++) {
				if (j != i) {
					for (int x = cows[j].start; x < cows[j].end; x++) {
						time[x] = 1;
					}
				}
			}
			int current = 0;
			for (int a = 0; a < 1001; a++) {
				if (time[a] != 1) {
					current++;
				}
				time[a] = 0;
			}
			if (current < best) {
				best = current;
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		out.print(1001 - best);
		in.close();
		out.close();
	}
	static class Cow{
		int start, end;
		public Cow(int s, int e) {
			this.start = s;
			this.end = e;
		}
	}
}
