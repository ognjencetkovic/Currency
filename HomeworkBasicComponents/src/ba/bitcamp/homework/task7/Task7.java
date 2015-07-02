package ba.bitcamp.homework.task7;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Task7 extends JPanel{
	
	private static final long serialVersionUID = -7348784816620870853L;

	private JSlider slider = new JSlider(0, 300);
	private int x;
	private int y;
	private int radius;
	private boolean clicked;
	
	public Task7() {
		setLayout(new BorderLayout());
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if(clicked){
					radius = slider.getValue();
					System.out.println(radius);
					repaint();					
				}
			}
		});
		addMouseListener(new Action());
		add(slider, BorderLayout.SOUTH);
	}
	
	private class Action extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			x = e.getX();
			y = e.getY();
			clicked = true;
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(x - radius / 2, y - radius / 2, radius, radius);
	}
	
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setContentPane(new Task7());
		window.setTitle("Task 7");
		window.setSize(400, 300);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	
}
