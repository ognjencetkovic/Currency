import java.util.Arrays;



public class EnverValuta {

	public static void main(String[] args) {
		String [] s = new String[]{"EURO 0.88", "BAM 1.73" , "USD 1.00"}; 
		String [] s1 = getNumOfCurrency(s);
		
		System.out.println(Arrays.toString(s1));
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

}
