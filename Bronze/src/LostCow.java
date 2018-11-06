import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LostCow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 10/10 Correct 42 minutes used
		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\eclipse-workspace\\USACO\\LostCow\\10.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));
		StringTokenizer ln1 = new StringTokenizer(in.readLine());
		int farmerPos = Integer.parseInt(ln1.nextToken());
		int cowPos = Integer.parseInt(ln1.nextToken());
		int distance = calc(farmerPos, cowPos, 1);
		System.out.println(distance);
		out.print(distance);
		out.close();
		in.close();
	}
	
	static int calc(int f, int c, int i) {
		if ((c > f && (f + i) >= c) || (c < f && (f + i) <= c)) {
			return Math.abs(f - c);
		} else {
			return (2 * Math.abs(i)) + calc(f, c, i * -2);
		}
	}

}
