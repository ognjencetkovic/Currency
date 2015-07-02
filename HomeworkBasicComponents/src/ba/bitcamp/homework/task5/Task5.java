package ba.bitcamp.homework.task5;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Task5 extends JFrame{
	
	private static final long serialVersionUID = 3013638455369930880L;

	private int red;
	private int green;
	private int blue;
	private JSlider slRed = new JSlider(0, 255);
	private JSlider slGreen = new JSlider(0, 255);
	private JSlider slBlue = new JSlider(0, 255);
	
	public Task5() {
		
		setLayout(new GridLayout(3, 2));
		initSlider(slRed, "Red");
		initSlider(slGreen, "Green");
		initSlider(slBlue, "Blue");
		
		setTitle("Task 5");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void initSlider(JSlider slider, String color){
		slider.setValue(0);
		updateBackgound();
		slider.setAutoscrolls(true);
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider changed = (JSlider) e.getSource();
				switch (color) {
				case "Red":
					red = changed.getValue();
					break;
				case "Green":
					green = changed.getValue();
					break;
				case "Blue":
					blue = changed.getValue();
					break;
				}
				updateBackgound();
			}

		});
		add(slider);
	}
	
	private void updateBackgound() {
		slRed.setBackground(new Color(red, green, blue));
		slGreen.setBackground(new Color(red, green, blue));
		slBlue.setBackground(new Color(red, green, blue));
		repaint();
	}
	
	public static void main(String[] args) {
		new Task5();
	}
}
