import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Family {

	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\USACO\\Bronze\\PLACEHOLD\\1.in"));
		BufferedReader in = new BufferedReader(new FileReader("family.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("family.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(ln.nextToken());
		String firstName = ln.nextToken();
		String secondName = ln.nextToken();
		ArrayList<Cow> cows = new ArrayList<Cow>();
		for (int i = 0; i < n; i++) {
			ln = new StringTokenizer(in.readLine());
			String x = ln.nextToken();
			String y = ln.nextToken();
			int xIndex = -1;
			int yIndex = -1;
			for (int j = 0; j < cows.size(); j++) {
				if (cows.get(j).name.equals(x)) {
//					Found mother
					xIndex = j;
				}
				if (cows.get(j).name.equals(y)) {
//					Found child
					yIndex = j;
				}
			}
			if (xIndex == -1 && yIndex == -1) {
//				Didn't find either
				Cow mom = new Cow(null, x);
				Cow child = new Cow(mom, y);
				cows.add(child);
				mom.children.add(child);
				cows.add(mom);
			} else if (yIndex == -1) {
//				Only found mother
				Cow mom = cows.get(xIndex);
				Cow child = new Cow(mom, y);
				cows.add(child);
				mom.children.add(child);
			} else if (xIndex == -1) {
//				Only found child
				Cow child = cows.get(yIndex);
				Cow mom = new Cow(null, x);
				child.mother = mom;
				mom.children.add(child);
				cows.add(mom);
			} else {
//				Found both
				Cow child = cows.get(yIndex);
				Cow mom = cows.get(xIndex);
				child.mother = mom;
				mom.children.add(child);
			}
		}
		Cow firstCow = null;
		Cow secondCow = null;
		for (int i = 0; i < cows.size(); i++) {
			Cow temp = cows.get(i);
			if (temp.name.equals(firstName)) {
				firstCow = temp;
			} else if (temp.name.equals(secondName)) {
				secondCow = temp;
			}
		}
		boolean found = false;
		if (firstCow.mother == secondCow.mother) {
//			Sharing the same mother means they are siblings
			out.println("SIBLINGS");
			found = true;
		}
//		Direct descendants
		Cow curr = firstCow;
		int generations = 0;
		Cow mother = curr.mother;
		if (!found) {
			while (mother != null) {
				if (mother == secondCow) {
					found = true;
					out.print(secondName + " is the ");
					for (int i = 1; i < generations; i++) {
						out.print("great-");
					}
					if (generations > 0) {
						out.print("grand-");
					}
					out.print("mother of " + firstName);
					break;
				}
				curr = curr.mother;
				mother = curr.mother;
				generations++;
			}
		}
		if (!found) {
			curr = secondCow;
			generations = 0;
			mother = curr.mother;
			while (mother != null) {
				if (mother == firstCow) {
					found = true;
					out.print(firstName + " is the ");
					for (int i = 1; i < generations; i++) {
						out.print("great-");
					}
					if (generations > 0) {
						out.print("grand-");
					}
					out.print("mother of " + secondName);
					break;
				}
				curr = curr.mother;
				mother = curr.mother;
				generations++;
			}
		}
		if (!found) {
			curr = firstCow;
			generations = 0;
			mother = curr.mother;
			while (mother != null) {
				for (int i = 0; i < mother.children.size(); i++) {
					Cow temp = mother.children.get(i);
					if (secondCow == temp) {
						found = true;
						out.print(secondName + " is the ");
						for (int j = 1; j < generations; j++) {
							out.print("great-");
						}
						out.print("aunt of " + firstName);
						break;
					}
				}
				curr = curr.mother;
				mother = curr.mother;
				generations++;
			}
		}
		if (!found) {
			curr = secondCow;
			generations = 0;
			mother = curr.mother;
			while (mother != null) {
				for (int i = 0; i < mother.children.size(); i++) {
					Cow temp = mother.children.get(i);
					if (firstCow == temp) {
						found = true;
						out.print(firstName + " is the ");
						for (int j = 1; j < generations; j++) {
							out.print("great-");
						}
						out.print("aunt of " + secondName);
						break;
					}
				}
				curr = curr.mother;
				mother = curr.mother;
				generations++;
			}
		}
		if (!found) {
			curr = firstCow;
			generations = 0;
			mother = curr.mother;
			while (mother != null) {
				curr = curr.mother;
				mother = curr.mother;
				generations++;
			}
			Cow firstRoot = curr;
			curr = secondCow;
			generations = 0;
			mother = curr.mother;
			while (mother != null) {
				curr = curr.mother;
				mother = curr.mother;
				generations++;
			}
			Cow secondRoot = curr;
			if (firstRoot == secondRoot) {
				found = true;
				out.println("COUSINS");
			}
		}
		if (!found) {
			out.println("NOT RELATED");
		}
		out.close();
		in.close();
	}
	
	static class Cow {
		ArrayList<Cow> children = new ArrayList<Cow>();
		String name;
		Cow mother;
		
		public Cow(Cow a, String b) {
			mother = a;
			name = b;
		}
	}
}
