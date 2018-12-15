import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MixingMilk {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("mixmilk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
		int[] capacities = new int[3];
		int[] amounts = new int[3];
		for (int i = 0; i < 3; i++) {
			StringTokenizer ln = new StringTokenizer(in.readLine());
			capacities[i] = Integer.parseInt(ln.nextToken());
			amounts[i] = Integer.parseInt(ln.nextToken());
		}
		for (int i = 0; i < 100; i++) {
			switch (i % 3) {
			case 0:
				// Pour 0 into 1
				if (amounts[0] + amounts[1] > capacities[1]) {
					amounts[0] -= capacities[1] - amounts[1];
					amounts[1] = capacities[1];
				} else {
					amounts[1] = amounts[1] + amounts[0];
					amounts[0] = 0;
				}
				break;
			case 1:
				// Pour 1 into 2
				if (amounts[1] + amounts[2] > capacities[2]) {
					amounts[1] -= capacities[2] - amounts[2];
					amounts[2] = capacities[2];
				} else {
					amounts[2] = amounts[2] + amounts[1];
					amounts[1] = 0;
				}
				break;
			case 2:
				// Pour 2 into 0
				if (amounts[2] + amounts[0] > capacities[0]) {
					amounts[2] -= capacities[0] - amounts[0];
					amounts[0] = capacities[0];
				} else {
					amounts[0] = amounts[0] + amounts[2];
					amounts[2] = 0;
				}
				break;
			}
		}
		for (int i = 0; i < 3; i++) {
			out.println(amounts[i]);
		}
		out.close();
		in.close();
	}
}