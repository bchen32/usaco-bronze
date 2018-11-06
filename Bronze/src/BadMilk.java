import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BadMilk {

	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\USACO\\Bronze\\BadMilk\\6.in"));
		BufferedReader in = new BufferedReader(new FileReader("badmilk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		Integer.parseInt(ln.nextToken());
//		Types of milk
		int m = Integer.parseInt(ln.nextToken());
//		Number of events
		int d = Integer.parseInt(ln.nextToken());
//		Number of sick people
		int s = Integer.parseInt(ln.nextToken());
		Event[] events = new Event[d];
		Sick[] sickLog = new Sick[s];
		for (int i = 0; i < d; i++) {
			ln = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(ln.nextToken());
			int b = Integer.parseInt(ln.nextToken());
			int c = Integer.parseInt(ln.nextToken());
			events[i] = new Event(a, b, c);
		}
		Arrays.sort(events);
		for (int i = 0; i < s; i++) {
			ln = new StringTokenizer(in.readLine());
			int p = Integer.parseInt(ln.nextToken());
			int t = Integer.parseInt(ln.nextToken());
			sickLog[i] = new Sick(p, t);
		}
		int worstCase = 0;
		for (int i = 1; i < m + 1; i++) {
//			Loop through each possible milk
			int currWorst = 0;
			boolean drankCurrMilk = true;
			for (int j = 0; j < s; j++) {
				int person = sickLog[j].person;
				int time = sickLog[j].time;
				boolean drank = false;
				for (int k = 0; k < d && events[k].time < time; k++) {
					if (events[k].person == person && events[k].milk == i) {
						drank = true;
						break;
					}
				}
				if (!drank) {
					drankCurrMilk = false;
				}
			}
			ArrayList<Integer> people = new ArrayList<Integer>();
			if (drankCurrMilk) {
				for (int j = 0; j < d; j++) {
					if (events[j].milk == i && !people.contains(events[j].person)) {
						people.add(events[j].person);
						currWorst++;
					}
				}
			}
			worstCase = Math.max(worstCase, currWorst);
		}
		out.println(worstCase);
		out.close();
		in.close();
	}
	
	static class Event implements Comparable<Event>{
		int person;
		int milk;
		int time;
		
		public Event(int a, int b, int c) {
			person = a;
			milk = b;
			time = c;
		}

		public int compareTo(Event other) {
			return Integer.compare(this.time, other.time);
		}
	}
	
	static class Sick {
		int person;
		int time;
		
		public Sick(int a, int b) {
			person = a;
			time = b;
		}
	}
}
