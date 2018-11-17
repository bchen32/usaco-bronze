import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Photo {
	
	static int numCows;
	static int numUnfriendlyPairs;

	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\bench\\git\\USACO-Bronze\\Bronze\\Photo\\1.in"));
		BufferedReader in = new BufferedReader(new FileReader("photo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		numCows = Integer.parseInt(ln.nextToken());
		numUnfriendlyPairs = Integer.parseInt(ln.nextToken());
		Cow[] unfriendly = new Cow[numUnfriendlyPairs * 2];
		for (int i = 0; i < numUnfriendlyPairs; i++) {
			ln = new StringTokenizer(in.readLine());
			int pos1 = Integer.parseInt(ln.nextToken()) - 1;
			int pos2 = Integer.parseInt(ln.nextToken()) - 1;
			unfriendly[i * 2] = new Cow(pos1);
			unfriendly[i * 2].pairNum = i;
			unfriendly[i * 2+ 1] = new Cow(pos2);
			unfriendly[i * 2 + 1].pairNum = i;
		}
		Arrays.sort(unfriendly);
		int numPics = 1;
		HashSet<Integer> currentPic = new HashSet<Integer>();
		for (int i = 0; i < numUnfriendlyPairs * 2; i++) {
			Cow curr = unfriendly[i];
			if (currentPic.contains(curr.pairNum)) {
				numPics++;
				currentPic = new HashSet<Integer>();
			}
			currentPic.add(curr.pairNum);
		}
		out.println(numPics);
		out.close();
		in.close();
	}
	
	static class Cow implements Comparable<Cow> {
		int pos;
		int pairNum = -1;
		
		public Cow(int a) {
			pos = a;
		}

		@Override
		public int compareTo(Cow other) {
			return Integer.compare(this.pos, other.pos);
		}
	}
}