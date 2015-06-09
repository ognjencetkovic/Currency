package newpackage;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawWindow extends JFrame {
	private static final long serialVersionUID = 6569564515489073403L;
	
	private BufferedImage img;
	private JPanel imgPanel;
	
	public DrawWindow() {
		imgPanel = new JPanel() {
			private static final long serialVersionUID = -6089197466826384928L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (img != null) {
					g.drawImage(img, 0, 0, null);
				}
			}
		};
		
		add(imgPanel);
		setSize(1200, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("JAVA Drawing");
		setVisible(true);
	}
	
	public void setImage(BufferedImage img) {
		this.img = img;
		imgPanel.updateUI();
	}
}
