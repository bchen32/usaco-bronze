import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BreedProximity {

	public static void main(String[] args) throws IOException{
		// 38 minutes
		BufferedReader in = new BufferedReader(new FileReader("proximity.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("proximity.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(ln.nextToken());
		int k = Integer.parseInt(ln.nextToken());
		int[] order = new int[n];
		for (int i = 0; i < n; i++) {
			order[i] = Integer.parseInt(in.readLine());
		}
		int biggest = 0;
		for (int i = 0; i < n; i++) {
			if (order[i] > biggest) { 
				int j = i + 1;
				while (j <= i + k && j < n) {
					if (order[i] == order[j] && order[i] > biggest) {
						biggest = order[i];
					}
					j++;
				}
			}
		}
		out.println(biggest);
		in.close();
		out.close();		
	}
}
