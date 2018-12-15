import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BackAndForth {
	
	static HashSet<Long> finalVals = new HashSet<Long>();
	static ArrayList<Integer> firstBarn = new ArrayList<Integer>();
	static ArrayList<Integer> secondBarn = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("backforth.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		int numBuckets = 10;
		for (int i = 0; i < numBuckets; i++) {
			firstBarn.add(Integer.parseInt(ln.nextToken()));
		}
		ln = new StringTokenizer(in.readLine());
		for (int i = 0; i < numBuckets; i++) {
			secondBarn.add(Integer.parseInt(ln.nextToken()));
		}
		chooseNextBucket(firstBarn, true, 0, 0);
		out.println(finalVals.size());
		out.close();
		in.close();
	}
	
	static void chooseNextBucket(ArrayList<Integer> buckets, boolean isFirstBarn, int numDays, long totalChange) {
		if (numDays == 4) {
			finalVals.add(totalChange);
			return;
		}
		isFirstBarn = (isFirstBarn) ? false : true;
		for (int i = 0; i < buckets.size(); i++) {
			Collections.sort(buckets);
			int curr = buckets.get(i);
			if (isFirstBarn) {
				firstBarn.add(curr);
				secondBarn.remove(Integer.valueOf(curr));
			} else {
				firstBarn.remove(Integer.valueOf(curr));
				secondBarn.add(curr);
			}
			chooseNextBucket((isFirstBarn) ? firstBarn : secondBarn, isFirstBarn, numDays + 1, (isFirstBarn) ? totalChange + curr : totalChange - curr);
			if (isFirstBarn) {
				firstBarn.remove(Integer.valueOf(curr));
				secondBarn.add(curr);
			} else {
				firstBarn.add(curr);
				secondBarn.remove(Integer.valueOf(curr));
			}
		}
		return;
	}
}