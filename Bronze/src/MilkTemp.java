import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class MilkTemp {

	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\USACO\\Bronze\\MilkTemp\\2.in"));
		BufferedReader in = new BufferedReader(new FileReader("milktemp.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milktemp.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(ln.nextToken());
		int low = Integer.parseInt(ln.nextToken());
		int best = Integer.parseInt(ln.nextToken());
		int high = Integer.parseInt(ln.nextToken());
		Temp[] temps = new Temp[n * 2];
		for (int i = 0; i < n; i++) {
			ln = new StringTokenizer(in.readLine());
			int l = Integer.parseInt(ln.nextToken());
			int h = Integer.parseInt(ln.nextToken());
			temps[i * 2] = new Temp(i, l, true);
			temps[i * 2 + 1] = new Temp(i, h, false);			
			temps[i * 2].link = temps[i * 2 + 1];
			temps[i * 2 + 1].link = temps[i * 2];
		}
		Arrays.sort(temps);
		HashSet<Temp> lasts = new HashSet<Temp>();
		int firstTemp = temps[0].temp;
		int sum = (n - 1) * low + best;
		int i = 1;
		while (temps[i].temp == firstTemp) {
			sum += best - low;
			i++;
		}
		int bestSum = sum;
		Temp last = temps[0];
		while (i < n * 2) {
			Temp curr = temps[i];
			do {
				int currTemp = curr.temp;
	//			Too hot
				if (!lasts.isEmpty()) {
					Iterator<Temp> iterate = lasts.iterator();
					HashSet<Temp> toRemove = new HashSet<Temp>();
					while (iterate.hasNext()) {
						Temp t = iterate.next();
						if (t.temp < currTemp) {
							sum -= best - high;
							toRemove.add(t);
						}
					}
					iterate = toRemove.iterator();
					while (iterate.hasNext()) {
						Temp t = iterate.next();
						lasts.remove(t);
					}
				}
				if (curr.low) {
					sum += best - low;
				} else {
					lasts.add(curr);
				}
				last = curr;
				i++;
				if (i >= n * 2) {
					break;
				}
				curr = temps[i];
			} while (curr.temp == last.temp && i < n * 2);
			bestSum = Math.max(bestSum, sum);
		}
		out.println(bestSum);
		out.close();
		in.close();
	}
	
	static class Temp implements Comparable<Temp> {
		int cow;
		int temp;
		boolean low;
		Temp link;
		
		public Temp(int a, int b, boolean c) {
			cow = a;
			temp = b;
			low = c;
		}

		@Override
		public int compareTo(Temp other) {
			// TODO Auto-generated method stub
			return Integer.compare(this.temp, other.temp);
		}
		
		public boolean equals(Object other) {
			if (((Temp) other).temp == this.temp && ((Temp) other).cow == this.cow) {
				return true;
			}
			return false;
		}
	}
}
