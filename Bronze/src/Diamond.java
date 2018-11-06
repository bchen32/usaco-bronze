import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Diamond {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		// First time 3/10, second time 10/10
		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\eclipse-workspace\\USACO\\Diamond\\10.in"));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int diamonds = Integer.parseInt(st.nextToken());
		int distance = Integer.parseInt(st.nextToken());
		int[] data = new int[diamonds];
		int biggestCase = 0;
		for (int i = 0; i < diamonds; i++) {
			data[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(data);
		for (int i = 0; i < diamonds; i++) {
			int currentCase = 0;
			for (int j = i; j < diamonds; j++) {
				if (data[i] + distance >= data[j]) {
					currentCase++;
				}
			}
			if (currentCase > biggestCase) {
				biggestCase = currentCase;
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
		out.print(biggestCase);
		System.out.println(biggestCase);
		in.close();
		out.close();
	}

}
