import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Crossroad {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		// First time 3/10 didn't update previousRoad correctly, second time 10/10
		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\eclipse-workspace\\USACO\\Crossroad1\\10.in"));
		int numSight = Integer.parseInt(in.readLine());
		int previousRoad = -1;
		int cow = -1;
		int road = -1;
		int crosses = 0;
		int first = 1;
		Sighting[] sights = new Sighting[numSight];
		for (int i = 0; i < numSight; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			cow = Integer.parseInt(st.nextToken());
			road = Integer.parseInt(st.nextToken());
			Sighting temp = new Sighting(cow, road);
			sights[i] = temp;
			
		}
		for (int seek = 1; seek < 11; seek++) {
			for (int i = 0; i < numSight; i++) {
				if (sights[i].ID == seek) {
					if (first == 0) {
						if (sights[i].road != previousRoad) {
							crosses++;
						}
					} else {
						first = 0;
					}
					previousRoad = sights[i].road;
				}
			}
			first = 1;
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crossroad.out")));
		out.print(crosses);
		System.out.println(crosses);
		out.close();
		in.close();
	
	}
	static class Sighting implements Comparable<Sighting> {
		int ID;
		int road;
		public Sighting(int s, int n) {
			this.ID = s;
			this.road = n;
		}
		public int compareTo(Sighting other) {
			return ID - other.ID;
		}
		public String toString() {
			return this.ID + "_" + this.road;
		}
	}
}
