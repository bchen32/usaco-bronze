import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Square {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 10/10 Correct
		int x1 = 0;
		int x2 = 0;
		int y1 = 0;
		int y2 = 0;
		
		int x3 = 0;
		int x4 = 0;
		int y3 = 0;
		int y4 = 0;
		
		int minX = 0;
		int maxX = 0;
		int minY = 0;
		int maxY = 0;
		
		BufferedReader br = new BufferedReader(new FileReader("D:\\bench\\eclipse\\eclipse-workspace\\USACO\\Square\\10.in"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		x3 = Integer.parseInt(st2.nextToken());
		y3 = Integer.parseInt(st2.nextToken());
		x4 = Integer.parseInt(st2.nextToken());
		y4 = Integer.parseInt(st2.nextToken());
		
		minX = Math.min(x1, Math.min(x2, Math.min(x3, x4)));
		maxX = Math.max(x1, Math.max(x2, Math.max(x3, x4)));
		minY = Math.min(y1, Math.min(y2, Math.min(y3, y4)));
		maxY = Math.max(y1, Math.max(y2, Math.max(y3, y4)));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
		out.print((int)Math.pow(Math.max(maxX - minX, maxY - minY), 2));
		System.out.println((int)Math.pow(Math.max(maxX - minX, maxY - minY), 2));
		out.close();
		br.close();
	}
}
