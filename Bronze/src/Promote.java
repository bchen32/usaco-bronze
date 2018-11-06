import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Promote {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 10/10 Correct
		int[] data = new int[8];
		int silver = 0;
		int gold = 0;
		int platinum = 0;
		
		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\eclipse-workspace\\USACO\\Promotion\\6.in"));
		
		StringTokenizer ln1 = new StringTokenizer(in.readLine());
		data[0] = Integer.parseInt(ln1.nextToken());
		data[1] = Integer.parseInt(ln1.nextToken());
		
		StringTokenizer ln2 = new StringTokenizer(in.readLine());
		data[2] = Integer.parseInt(ln2.nextToken());
		data[3] = Integer.parseInt(ln2.nextToken());
		
		StringTokenizer ln3 = new StringTokenizer(in.readLine());
		data[4] = Integer.parseInt(ln3.nextToken());
		data[5] = Integer.parseInt(ln3.nextToken());
		
		StringTokenizer ln4 = new StringTokenizer(in.readLine());
		data[6] = Integer.parseInt(ln4.nextToken());
		data[7] = Integer.parseInt(ln4.nextToken());
		
		platinum = data[7] - data[6];
		gold = data[5] - data[4] + data[7] - data[6];
		silver = data[3] - data[2] + data[5] - data[4] + data[7] - data[6];
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));
		out.println(silver);
		out.println(gold);
		out.println(platinum);
		System.out.println(silver);
		System.out.println(gold);
		System.out.println(platinum);
		out.close();
		in.close();
	}

}
