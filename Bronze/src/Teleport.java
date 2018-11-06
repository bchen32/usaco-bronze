import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Teleport {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 10/10 Correct
		int[] transport = new int[2];
		int[] teleport = new int[2];
		
		int teleportUse1 = 0;
		int teleportUse2 = 0;
		int manual = 0;
		
		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\eclipse-workspace\\USACO\\Teleport\\10.in"));
		StringTokenizer ln1 = new StringTokenizer(in.readLine());
		transport[0] = Integer.parseInt(ln1.nextToken());
		transport[1] = Integer.parseInt(ln1.nextToken());
		teleport[0] = Integer.parseInt(ln1.nextToken());
		teleport[1] = Integer.parseInt(ln1.nextToken());
		
		teleportUse1 = Math.abs(transport[0] - teleport[0]) + Math.abs(transport[1] - teleport[1]);
		teleportUse2 = Math.abs(transport[0] - teleport[1]) + Math.abs(transport[1] - teleport[0]);
		manual = Math.abs(transport[1] - transport[0]);
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
		out.print(Math.min(teleportUse1, Math.min(teleportUse2, manual)));
		System.out.println(Math.min(teleportUse1, Math.min(teleportUse2, manual)));
		in.close();
		out.close();
	}

}
