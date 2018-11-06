import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Pails {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		// Forgot to account for y = 0, second time 10/10
		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\eclipse-workspace\\USACO\\Pails\\10.in"));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int xProd = 0;
		int yProd = 0;
		int xIndex = 0;
		int yIndex = 0;
		int biggest = 0;
		while (yProd < m) {
			yIndex++;
			yProd = yIndex * y;
		}
		yIndex--;
		yProd = yIndex * y;
		while (yIndex >= 0) {
			yProd = yIndex * y;
			xProd = xIndex * x;
			while (xProd + yProd < m) {
				yProd = yIndex * y;
				xIndex++;
				xProd = xIndex * x;
				if (xProd + yProd > biggest && xProd + yProd <= m) {
					biggest = xProd + yProd;
				}
			}
			yIndex--;
			xIndex = 0;
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
		out.println(biggest);
		System.out.println(biggest);
		in.close();
		out.close();
	}

}
