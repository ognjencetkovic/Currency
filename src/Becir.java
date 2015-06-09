import java.util.InputMismatchException;
import java.util.Scanner;


public class Becir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] array = new String[]{"EUR","GBP", "INR", "AUD", "CAD", "NZD", "YNJ", "BAM", "HRK", "USD"};
		getCurrency(array);
	}
	/**
	 * Print on the screen offered currency's and ask user to input which currency 
	 * he wants by typing one of the offered number
	 * @param array of String
	 * @return integer
	 */
	public static int getCurrency(String [] array){
		Scanner in = new Scanner(System.in);
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
				n = in.nextInt();
				if(n < 0 || n >= array.length){
					throw new IndexOutOfBoundsException();
				}
				break;
			}catch(InputMismatchException ex){
				System.out.println("Wrong input. Input number!");
				in.nextLine();
			}catch(IndexOutOfBoundsException ex){
				System.out.println("Wrong input. Input number!");
				in.nextLine();
			}
			
			
		}
		in.close();
		return n;
		
		
	}
}
