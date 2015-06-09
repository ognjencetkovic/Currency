import java.util.Scanner;

public class Tomislav {

	public static void main(String[] args) {
		// printResult("EUR", 7574.58967);
		getValue();
	}

	public static void printResult(String s, double d) {
		System.out.printf("You changed: %.2f %s. ", d, s);
	}

	public static double getValue() {
		Scanner in = new Scanner(System.in);
		System.out.println("Input value you want to exchange");
		double num = in.nextDouble();
		return num;

	}
}
