import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BucketList {
	
	static int numCows;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("blist.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		numCows = Integer.parseInt(ln.nextToken());
		int biggestTime = 0;
		Cow[] cows = new Cow[numCows];
		for (int i = 0; i < numCows; i++) {
			ln = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(ln.nextToken());
			int end = Integer.parseInt(ln.nextToken());
			int buckets = Integer.parseInt(ln.nextToken());
			cows[i] = new Cow(start, end, buckets);
			biggestTime = Math.max(biggestTime, end);
		}
		int[] bucketsAtTime = new int[biggestTime + 1];
		int mostBuckets = 0;
		for (int i = 0; i < numCows; i++) {
			Cow curr = cows[i];
			for (int j = curr.start; j <= curr.end; j++) {
				bucketsAtTime[j] += curr.buckets;
			}
		}
		for (int i = 0; i <= biggestTime; i++) {
			mostBuckets = Math.max(mostBuckets, bucketsAtTime[i]);
		}
		out.println(mostBuckets);
		out.close();
		in.close();
	}
	
	static class Cow {
		int start, end, buckets;
		
		public Cow(int a, int b, int c) {
			start = a;
			end = b;
			buckets = c;
		}
	}
}