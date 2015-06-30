package ba.bitcamp.homework;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainWindow extends JFrame{
	
	private static final long serialVersionUID = -3643440059998167908L;
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	
	
	
	private PanelColors pnlColors = new PanelColors();
	private PanelPaint pnlPaint = new PanelPaint();
	private PanelTools pnlTools = new PanelTools();
	
	public MainWindow() {
		
		setLayout(new BorderLayout());
		
		add(pnlColors, BorderLayout.NORTH);
		add(pnlPaint, BorderLayout.CENTER);
		add(pnlTools, BorderLayout.SOUTH);
		
		
		
		setSize(MainWindow.FRAME_WIDTH, MainWindow.FRAME_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new MainWindow();
		
	}
	
}
