import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BalancedTeams {
	
	static Player[] players;
	static int best = Integer.MAX_VALUE;
	static int[] teamSizes = new int[4];

	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\USACO\\Bronze\\BalancedTeams\\4.in"));
		BufferedReader in = new BufferedReader(new FileReader("bteams.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bteams.out")));
		int n = 12;
		players = new Player[12];
		for (int i = 0; i < n; i++) {
			players[i] = new Player(Integer.parseInt(in.readLine()), 0);
		}
		placePlayer(0);
		out.println(best);
		out.close();
		in.close();
	}
	
	static void placePlayer(int playerNum) {
		if (playerNum == 12) {
//			Every player has been placed
			best = Math.min(best, calcDiff());
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (teamSizes[i] != 3) {
				teamSizes[i]++;
				players[playerNum].team = i;
				placePlayer(playerNum + 1);
				teamSizes[i]--;
			}
		}
	}
	
	static int calcDiff() {
		int[] teamSkills = new int[4];
		for (int i = 0; i < 12; i++) {
			teamSkills[players[i].team] += players[i].skill;
		}
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			max = Math.max(teamSkills[i], max);
			min = Math.min(teamSkills[i], min);
		}
		return max - min;
	}
	
	static class Player {
		int skill;
		int team;
		
		public Player(int a, int b) {
			skill = a;
			team = b;
		}
	}
}
