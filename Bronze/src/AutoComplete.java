import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AutoComplete {

	public static void main(String[] args) throws IOException {
		// BufferedReader in = new BufferedReader(new
		// FileReader("D:\\bench\\eclipse\\USACO\\Bronze\\AutoComplete\\3.in"));
		BufferedReader in = new BufferedReader(new FileReader("auto.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("auto.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		int numWords = Integer.parseInt(ln.nextToken());
		int numPartials = Integer.parseInt(ln.nextToken());
		DictionaryEntry[] dictionary = new DictionaryEntry[numWords];
		Request[] requests = new Request[numPartials];
		for (int i = 0; i < numWords; i++) {
			dictionary[i] = new DictionaryEntry(in.readLine(), i + 1);
		}
		Arrays.sort(dictionary);
		for (int i = 0; i < numPartials; i++) {
			ln = new StringTokenizer(in.readLine());
			int b = Integer.parseInt(ln.nextToken());
			String a = ln.nextToken();
			requests[i] = new Request(a, b);
		}
		for (int i = 0; i < numPartials; i++) {
			Request currRequest = requests[i];
			String partial = currRequest.partial;
			int partialLength = partial.length();
			int indexMatching = bsearch(0, numWords - 1, partial, dictionary);
			while (indexMatching > 0 && dictionary[indexMatching - 1].word.length() >= partialLength
					&& dictionary[indexMatching - 1].word.substring(0, partialLength).equals(partial)) {
				indexMatching--;
			}
			int requestIndex = indexMatching + currRequest.completionNum - 1;
			if (requestIndex >= 0 && requestIndex < numWords) {
				String word = dictionary[requestIndex].word;
				int wordLength = word.length();
				if (partialLength <= wordLength && word.substring(0, partialLength).equals(partial)) {
					out.println(dictionary[requestIndex].originalLine);
				} else {
					out.println(-1);
				}
			} else {
				out.println(-1);
			}
		}
		out.close();
		in.close();
	}

	static class DictionaryEntry implements Comparable<DictionaryEntry> {
		String word;
		int originalLine;

		public DictionaryEntry(String a, int b) {
			word = a;
			originalLine = b;
		}

		@Override
		public int compareTo(DictionaryEntry other) {
			// TODO Auto-generated method stub
			return this.word.compareTo(other.word);
		}
	}

	static class Request {
		String partial;
		int completionNum;

		public Request(String a, int b) {
			partial = a;
			completionNum = b;
		}
	}

	public static int bsearch(int l, int h, String val, DictionaryEntry[] list) {
		if (l <= h) {
			int mid = (h + l) / 2;
			String midVal = list[mid].word;
			if (midVal.length() >= val.length() && midVal.substring(0, val.length()).equals(val)) {
				return mid;
			}
			if (val.compareTo(midVal) < 0) {
				return bsearch(l, mid - 1, val, list);
			} else {
				return bsearch(mid + 1, h, val, list);
			}
		}
		return -1;
	}
}
