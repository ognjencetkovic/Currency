package ba.bitcamp.homework.task3;

import javax.swing.JOptionPane;

public class Task3 {
	
	public static void main(String[] args) {
		
		try {
			int sum = Integer.parseInt(JOptionPane.showInputDialog("Input number"));
			while (JOptionPane.showConfirmDialog(null, "Do you want to add another number?", "Message", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				String s = JOptionPane.showInputDialog("Input number");
				if(s != null){
					sum += Integer.parseInt(s);
				} else {
					JOptionPane.showMessageDialog(null, "Sum is " + sum + ".");
					System.exit(0);
				}
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid input");
			System.exit(0);
		}
		
	}
}
