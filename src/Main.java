import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		start();
	}
	
	/**
	 * Starts program.
	 */
	public static void start() {
		System.out.println("---------------------------------------");
		System.out.println("----------EXCHANGE CURRENCIES----------");
		System.out.println("---------------------------------------");
		
		String fileName = "src/Currency.txt";
		try {
			TextIO.readFile(fileName);
		} catch (Exception e) {
			System.out.println("File does not exist");
			System.exit(0);
		}
		String[] currencyNames = getNumOfCurrency(getArrayFromFile(fileName));
		double[] currencyValues = getCurrencyValues(getArrayFromFile(fileName));
		
		int cur1 = getCurrency(currencyNames);

		double value = getValue();
		System.out.println("To which currency you want to exchange:");
		int cur2 = getCurrency(currencyNames);
		
		
		exchange(currencyValues[cur1], currencyValues[cur2], value, currencyNames[cur2]);
		
	}

	/**
	 * Prints result on console
	 */
	public static void printResult(String s, double d) {
		System.out.printf("You exchanged: %.2f %s. ", d, s);
	}
	
	/**
	 * Method from more strings takes the first three characters and returns them in a string!
	 * @param Arrays of String;
	 * @return Arrays of String;
	 */
	public static String[] getNumOfCurrency(String [] s) {
		String [] newArr  = new  String[s.length];
		for (int i = 0; i < s.length; i ++) {
			newArr [i] = s[i].substring (0,3);
		}
		
	
		return newArr;
	}
	
	/**
	 * Print on the console offered currency's and ask user to input which currency 
	 * he wants by typing one of the offered number
	 * @param array of String
	 * @return integer
	 */
	public static int getCurrency(String [] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(" " + i);
			System.out.print("  ");
		}
		System.out.println();
		for(int i = 0; i < array.length ; i++){
			System.out.print(array[i] + " ");
		}
		int n;
		while(true){
			try{
				System.out.print("\nChoose currency: ");
				n = input.nextInt();
				if(n < 0 || n >= array.length){
					throw new IndexOutOfBoundsException();
				}
				break;
			}catch(InputMismatchException ex){
				System.out.print("Wrong input. Input number!");
				input.nextLine();
			}catch(IndexOutOfBoundsException ex){
				System.out.print("Wrong input. Input number!");
				input.nextLine();
			}
			
			
		}
		return n;
	}

	/**
	 * Returns double read from console.
	 * @return Double.
	 */
	public static double getValue(){
		double value = 0;
		while(true){
			try {
				System.out.print("Input value you want to exchange: ");
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
	 * Returns array of string read from file, with each string representing one line in file.
	 * @param fileName A path to file.
	 * @return Array of strings.
	 */
	public static String[] getArrayFromFile(String fileName){
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
	public static void exchange(double oldCurrency, double newCurrency, double value, String currencyName){
		double newValue = value * newCurrency / oldCurrency;
		printResult(currencyName, newValue);
	}
}
