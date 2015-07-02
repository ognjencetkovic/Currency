package ba.bitcamp.homework.task1;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Task1 extends JFrame{
	
	private static final long serialVersionUID = 3013638455369930880L;

	private JLabel lblText = new JLabel("Example", JLabel.CENTER);
	private JSlider slider = new JSlider(0, 80);
	
	public Task1() {
		
		setLayout(new BorderLayout());
		
		slider.setValue(12);
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				lblText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, slider.getValue()));
			}
		});
		
		add(lblText);
		add(slider, BorderLayout.SOUTH);
		
		setTitle("Task 1");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Task1();
	}
}
