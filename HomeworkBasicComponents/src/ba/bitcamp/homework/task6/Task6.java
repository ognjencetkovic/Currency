package ba.bitcamp.homework.task6;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Task6 extends JFrame{
	
	private static final long serialVersionUID = 3013638455369930880L;

	private JLabel lblTime = new JLabel("", JLabel.CENTER);
	private JTextField txtTime = new JTextField();
	private JButton btnStart = new JButton("Start");
	private int time = -1;
	
	public Task6() {
		
		setLayout(new GridLayout(3, 1));
		
		txtTime.setHorizontalAlignment(JTextField.CENTER);

		Timer timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(time >= 0){
					lblTime.setText((time--) + "");
				}
			}
		});
		
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(time == -1){
					try {
						time = Integer.parseInt(txtTime.getText());
						timer.start();
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Wrong input");
					}					
				}
			}
		});
		
		add(lblTime);
		add(txtTime);
		add(btnStart);
		
		setTitle("Task 6");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Task6();
	}
}
