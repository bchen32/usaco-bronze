import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Billboard {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 10/10 correct
		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\eclipse-workspace\\USACO\\Billboard\\10.in"));
		int[] billboard1 = new int[4];
		int[] billboard2 = new int[4];
		int[] truck = new int[4];
		int cover1 = 0;
		int cover2 = 0;
		int area1 = 0;
		int area2 = 0;
		
		StringTokenizer ln1 = new StringTokenizer(in.readLine());
		billboard1[0] = Integer.parseInt(ln1.nextToken());
		billboard1[2] = Integer.parseInt(ln1.nextToken());
		billboard1[1] = Integer.parseInt(ln1.nextToken());
		billboard1[3] = Integer.parseInt(ln1.nextToken());
		StringTokenizer ln2 = new StringTokenizer(in.readLine());
		billboard2[0] = Integer.parseInt(ln2.nextToken());
		billboard2[2] = Integer.parseInt(ln2.nextToken());
		billboard2[1] = Integer.parseInt(ln2.nextToken());
		billboard2[3] = Integer.parseInt(ln2.nextToken());
		StringTokenizer ln3 = new StringTokenizer(in.readLine());
		truck[0] = Integer.parseInt(ln3.nextToken());
		truck[2] = Integer.parseInt(ln3.nextToken());
		truck[1] = Integer.parseInt(ln3.nextToken());
		truck[3] = Integer.parseInt(ln3.nextToken());
		
		if (truck[0] < billboard1[1] && truck[3] > billboard1[2]) {
			int x1 = 0;
			int y1 = 0;
			if (truck[0] < billboard1[0]) {
				if (truck[1] < billboard1[1]) {
					x1 = billboard1[0] - truck[1];
				} else {
					x1 = billboard1[1] - billboard1[0];
				}
			} else {
				if (truck[1] < billboard1[1]) {
					x1 = truck[1] - truck[0];
				} else {
					x1 = billboard1[1] - truck[0];
				}
			}
			if (truck[3] > billboard1[3]) {
				if (truck[2] > billboard1[2]) {
					y1 = billboard1[3] - truck[2];
				} else {
					y1 = billboard1[3] - billboard1[2];
				}
			} else {
				if (truck[2] > billboard1[2]) {
					y1 = truck[3] - truck[2];
				} else {
					y1 = truck[3] - billboard1[2];
				}
			}
			cover1 = x1 * y1;
		}
		if (truck[1] > billboard2[0] && truck[2] < billboard2[3]) {
			int x2 = 0;
			int y2 = 0;
			if (truck[1] > billboard2[1]) {
				if (truck[0] > billboard2[0]) {
					x2 = billboard2[1] - truck[0];
				} else {
					x2 = billboard2[1] - billboard2[0];
				}
			} else {
				if (truck[0] > billboard2[0]) {
					x2 = truck[1] - truck[0];
				} else {
					x2 = truck[1] - billboard2[0];				
				}	
			}
			if (truck[3] > billboard2[3]) {
				if (truck[2] > billboard2[2]) {
					y2 = billboard2[3] - truck[2];
				} else {
					y2 = billboard2[3] - billboard2[2];
				}
			} else {
				if (truck[2] > billboard2[2]) {
					y2 = truck[3] - truck[2];
				} else {
					y2 = truck[3] - billboard2[2];
				}
			}
			cover2 = x2 * y2;
		}
		area1 = (billboard1[1] - billboard1[0]) * (billboard1[3] - billboard1[2]) - cover1;
		area2 = (billboard2[1] - billboard2[0]) * (billboard2[3] - billboard2[2]) - cover2;
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		out.print(area1 + area2);
		//System.out.println(area1 + area2);
		out.close();
		in.close();
	}

}
