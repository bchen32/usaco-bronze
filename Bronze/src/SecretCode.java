import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SecretCode {

	static int numWays = 0;

	public static void main(String[] args) throws IOException {
		// BufferedReader in = new BufferedReader(new
		// FileReader("C:\\Users\\bench\\git\\USACO-Bronze\\Bronze\\SecretCode\\1.in"));
		BufferedReader in = new BufferedReader(new FileReader("scode.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("scode.out")));
		String origString = in.readLine();
		split(origString);
		out.println(numWays - 1);
		out.close();
		in.close();
	}

	static void split(String str) {
		numWays++;
		if (str.length() % 2 == 0 || str.length() == 1) {
			return;
		}
		int med = str.length() / 2;
		for (int i = 0; i < 2; i++) {
			String s1 = str.substring(0, med + i);
			String s2 = str.substring(med + i, str.length());
			if (i == 1) {
				// S1 is bigger

				// ABC + BC
				if (s1.substring(1, s1.length()).equals(s2)) {
					split(s1);
				}
				// ABC + AB
				if (s1.substring(0, s1.length() - 1).equals(s2)) {
					split(s1);
				}
			} else {
				// S1 is smaller

				// BC + ABC
				if (s2.substring(1, s2.length()).equals(s1)) {
					split(s2);
				}
				// AB + ABC
				if (s2.substring(0, s2.length() - 1).equals(s1)) {
					split(s2);
				}
			}
		}
	}
}