import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Odometer {

	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new FileReader("D:\\bench\\eclipse\\USACO\\Bronze\\Odometer\\2.in"));
		BufferedReader in = new BufferedReader(new FileReader("odometer.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("odometer.out")));
		StringTokenizer ln = new StringTokenizer(in.readLine());
		long firstInt = Long.parseLong(ln.nextToken());
		long secondInt = Long.parseLong(ln.nextToken());
		long count = secondInt;
		int digits = 0;
		while (count > 0) {
			count /= 10;
			digits++;
		}
		int interestingNums = 0;
		for (int numDigits = 3; numDigits < digits + 1; numDigits++) {
			for (int digitVal = 0; digitVal < 10; digitVal++) {
				for (int changedDigitIndex = 0; changedDigitIndex < numDigits; changedDigitIndex++) {
					for (int changedDigitVal = 0; changedDigitVal < 10; changedDigitVal++) {
						if (changedDigitVal == digitVal) {
							continue;
						}
						if (changedDigitIndex == 0 && changedDigitVal == 0) {
							continue;
						}
						if (digitVal == 0 && changedDigitIndex != 0) {
							continue;
						}
						long num = 0;
						for (int i = 0; i < numDigits; i++) {
							int curr = 0;
							if (i == changedDigitIndex) {
								curr = changedDigitVal;
							} else {
								curr = digitVal;
							}
							num += curr * Math.pow(10, (numDigits - i - 1));
						}
						if (num >= firstInt && num <= secondInt) {
							interestingNums++;
						}
					}
				}
			}
		}
		out.println(interestingNums);
		out.close();
		in.close();
	}
}
