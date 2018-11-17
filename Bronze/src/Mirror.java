import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Mirror {
	
	static int ROWS;
	static int COLS;

	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\bench\\git\\USACO-Bronze\\Bronze\\Mirror\\1.in"));
		BufferedReader in = new BufferedReader(new FileReader("mirror.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mirror.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		ROWS = Integer.parseInt(ln.nextToken());
		COLS = Integer.parseInt(ln.nextToken());
		
		for (int r = 0; r < ROWS; r++) {
			ln = new StringTokenizer(in.readLine());
			for (int c = 0; c < COLS; c++) {
				
			}
		}
		out.close();
		in.close();
	}
}