

import java.util.Arrays;
import java.util.Scanner;

public class Ognjen {
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(getCurrencyValues(getArrayFromFile())));
		getValue();
		exchange(0.88, 1.73, 10);
	}
	
	/**
	 * Returns double read from console.
	 * @return Double.
	 */
	public static double getValue(){
		double value = 0;
		while(true){
			try {
				System.out.print("Input value you want to change: ");
				value = input.nextDouble();
				break;
			} catch (Exception e) {
				input.nextLine();
				System.out.println("Wrong input!");
			}
		}
		return value;
	}
	
	/**
	 * Returns array of doubles, read from array of strings.
	 * @param s Array of strings.
	 * @return Array of doubles.
	 */
	public static double[] getCurrencyValues(String[] s){
		double[] values = new double[s.length];
		try {
			for (int i = 0; i < values.length; i++) {
				values[i] = Double.parseDouble(s[i].substring(4));
			}
		} catch (NumberFormatException e) {
			System.out.println("Corrupt file!");
		}
		return values;
	}
	
	/**
	 * Returns array of string read from file, with each string representing one line in file
	 * @return Array of strings
	 */
	public static String[] getArrayFromFile(){
		String fileName = "src/Currency.txt";
		TextIO.readFile(fileName);
		int length = 0;
		while(!TextIO.eof()){
			TextIO.getln();
			length++;
		}
		String[] inStr = new String[length + 1];
		inStr[0] = "USD 1.00";
		TextIO.readFile(fileName);
		for (int i = 1; i < inStr.length; i++) {
			inStr[i] = TextIO.getln();
		}
		return inStr;
	}
	
	/**
	 * Exchanges one currency to another.
	 * @param oldCurrency Old currency value.
	 * @param newCurrency New currency value.
	 * @param value Amount of money.
	 */
	public static void exchange(double oldCurrency, double newCurrency, double value){
		double newValue = value * newCurrency / oldCurrency;
		System.out.println(newValue);
	}
	
}
