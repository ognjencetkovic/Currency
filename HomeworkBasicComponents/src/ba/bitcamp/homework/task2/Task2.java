package ba.bitcamp.homework.task2;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task2 extends JFrame{
	
	private static final long serialVersionUID = 3013638455369930880L;

	private JLabel lblText = new JLabel("Example", JLabel.CENTER);
	private JCheckBox ckbBold = new JCheckBox("Bold");
	private JCheckBox ckbItalic = new JCheckBox("Italic");
	private JButton btnApply = new JButton("Apply");
	
	public Task2() {
		
		setLayout(new GridLayout(4, 1));
		
		lblText.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 25));
		btnApply.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (ckbItalic.isSelected() && ckbBold.isSelected()){
					lblText.setFont(new Font(Font.MONOSPACED, Font.ITALIC + Font.BOLD, 25));
				} else  if (ckbItalic.isSelected()){
					lblText.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 25));					
				} else  if (ckbBold.isSelected()){
					lblText.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));					
				} else {
					lblText.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 25));										
				}
				
			}
		});
		
		add(lblText);
		add(ckbItalic);
		add(ckbBold);
		add(btnApply);
		
		setTitle("Task 2");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Task2();
	}
}
