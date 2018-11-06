import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Mowing {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader("mowing.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));
		StringTokenizer ln1 = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(ln1.nextToken());
		int[][][] field = new int[2001][2001][2];
		int posX = 1000;
		int posY = 1000;
		field[1000][1000][0] = 1;
		int time = 0;
		int x = 1001;
		for (int i = 0; i < n; i++) {
			StringTokenizer str = new StringTokenizer(in.readLine());
			String dir = str.nextToken();
			int steps = Integer.parseInt(str.nextToken());
			switch (dir) {
			case "N":
				for (int a = 0; a < steps; a++) {
					posY++;
					time++;
					if (field[posX][posY][0] == 1) {
						if (field[posX][posY][1] != 0) {
							x = Math.min(x, time - field[posX][posY][1]);
						}
					} else {
						field[posX][posY][0] = 1;
					}
					field[posX][posY][1] = time;
				}
				break;
			case "E":
				for (int a = 0; a < steps; a++) {
					posX++;
					time++;
					if (field[posX][posY][0] == 1) {
						if (field[posX][posY][1] != 0) {
							x = Math.min(x, time - field[posX][posY][1]);
						}
					} else {
						field[posX][posY][0] = 1;
					}
					field[posX][posY][1] = time;
				}
				break;
			case "S":
				for (int a = 0; a < steps; a++) {
					posY--;
					time++;
					if (field[posX][posY][0] == 1) {
						if (field[posX][posY][1] != 0) {
							x = Math.min(x, time - field[posX][posY][1]);
						}
					} else {
						field[posX][posY][0] = 1;
					}
					field[posX][posY][1] = time;
				}
				break;
			case "W":
				for (int a = 0; a < steps; a++) {
					posX--;
					time++;
					if (field[posX][posY][0] == 1) {
						if (field[posX][posY][1] != 0) {
							x = Math.min(x, time - field[posX][posY][1]);
						}
					} else {
						field[posX][posY][0] = 1;
					}
					field[posX][posY][1] = time;
				}
				break;
			}	
		}
		if (x == 1001) {
			x = -1;
		}
		out.println(x);
		out.close();
		in.close();
	}

}

