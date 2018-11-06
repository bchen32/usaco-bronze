import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class RecordKeeping {

	static int n;

	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\Workspace\\Bronze\\RecordKeeping\\1.in"));
		BufferedReader in = new BufferedReader(new FileReader("records.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("records.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		n = Integer.parseInt(ln.nextToken());
		HashMap<Group, Integer> groups = new HashMap<Group, Integer>();
		int mostOccurrences = 0;
		for (int i = 0; i < n; i++) {
			ln = new StringTokenizer(in.readLine());
			String[] names = new String[3];
			for (int j = 0; j < 3; j++) {
				names[j] = ln.nextToken();
			}
			Arrays.sort(names);
			Group curr = new Group(names[0], names[1], names[2]);
			if (groups.containsKey(curr)) {
				int prev = groups.get(curr);
				groups.put(curr, prev + 1);
			} else {
				groups.put(curr, 1);
			}
			mostOccurrences = Math.max(mostOccurrences, groups.get(curr));
		}
		out.println(mostOccurrences);
		out.close();
		in.close();
	}

	static class Group {
		String name1;
		String name2;
		String name3;

		public Group(String a, String b, String c) {
			name1 = a;
			name2 = b;
			name3 = c;
		}

		@Override
		public boolean equals(Object o) {
			Group other = (Group) o;
			if (this.name1.equals(other.name1) && this.name2.equals(other.name2) && this.name3.equals(other.name3)) {
				return true;
			}
			return false;
		}

		@Override
		public int hashCode() {
			int result = 17;
			result = 31 * result + name1.hashCode();
			result = 31 * result + name2.hashCode();
			result = 31 * result + name3.hashCode();
			return result;
		}
	}
}