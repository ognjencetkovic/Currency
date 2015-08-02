package ba.bitcamp.homework.task3;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task3 extends JFrame {

	private static final long serialVersionUID = 2470732168806218166L;

	private JLabel lbl = new JLabel();
	private JButton btn = new JButton("Stop");
	char c = 'a';
	
	public Task3() {
		
		setLayout(new BorderLayout());
		
		add(lbl);
		add(btn, BorderLayout.SOUTH);
		
		setTitle("Task 3");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		while (true) {
			new LabelThread().start();
			
		}
	}
	
	private class LabelThread extends Thread {
		
		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lbl.setText(lbl.getText() + c++);
			repaint();
		}
	}
	
	public static void main(String[] args) {
		new Task3();
	}
}
