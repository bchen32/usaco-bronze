/*
ID: benchen1
LANG: JAVA
TASK: test
 */
import java.io.*;
import java.util.*;
public class Paint {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// First time 8/10, didn't account for non overlapping cases, redid in less efficient way, 10/10
		BufferedReader br = new BufferedReader(new FileReader("D:\\bench\\eclipse\\eclipse-workspace\\USACO\\Paint\\10.in"));
		int[] fence = new int[101];
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		String input2 = br.readLine();
		StringTokenizer st2 = new StringTokenizer(input2);
		int c = Integer.parseInt(st2.nextToken());
		int d = Integer.parseInt(st2.nextToken());
		for (int i = 0; i < fence.length; i++) {
			if (i > a && i <= b || i > c && i <= d) {
				fence[i] = 1;
			}
		}
		int painted = 0;
		for (int i = 0; i < 101; i++) {
			if (fence[i] == 1) {
				painted++;
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
		out.print(painted);
		System.out.println(painted);
		out.close();
		br.close();
	}

}
