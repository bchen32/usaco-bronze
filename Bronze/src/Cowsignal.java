import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Cowsignal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\eclipse-workspace\\USACO\\Cowsignal\\4.in"));
		BufferedReader in = new BufferedReader(new FileReader("cowsignal.in"));
		StringTokenizer ln1 = new StringTokenizer(in.readLine());
		ArrayList<String> line = new ArrayList<String>();
		int m = Integer.parseInt(ln1.nextToken());
		int n = Integer.parseInt(ln1.nextToken());
		int k = Integer.parseInt(ln1.nextToken());
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
		for (int i = 0; i < m; i++) {	
				for (int j = 0; j < n; j++) {
					char ch = (char) in.read();
					System.out.print(ch);
					for (int x = 0; x < k; x++) {
						line.add(Character.toString(ch));
						out.print(ch);
						System.out.print(ch);
					}
				}
				for (int a = 0; a < k - 1; a++) {
					System.out.println();
					out.println();
					for (int y = 0; y < line.size(); y++) {
						out.print(line.get(y));
						System.out.print(line.get(y));
					}
				}
				line = new ArrayList<String>();
				out.println();
				System.out.println();
				in.readLine();
		}
		out.close();
		in.close();
	}

}
