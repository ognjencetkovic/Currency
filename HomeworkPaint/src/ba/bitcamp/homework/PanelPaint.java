package ba.bitcamp.homework;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class PanelPaint extends JPanel{
	
	private static final long serialVersionUID = 3961372100730794186L;
	public static final int MINIMUM_SIZE = 5;
	public static final int MAXIMUM_SIZE = 50;
	public static final int STEP_SIZE = 5;
	
	private static PointArray points = new PointArray();
	
	private static Color activeColor;
	private static int activeSize;
	private static boolean pen = true;
	private static boolean brush = false;
	
	
	
	public PanelPaint() {
		super();
		
		
		setBackground(Color.WHITE);
		addMouseMotionListener(new MouseHandler());
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		usePen(g);
		useBrush(g);
		
	}
	
	/**
	 * @return the pen
	 */
	public static boolean isPen() {
		return pen;
	}

	/**
	 * @param pen the pen to set
	 */
	public static void setPen(boolean pen) {
		PanelPaint.pen = pen;
	}

	/**
	 * @return the brush
	 */
	public static boolean isBrush() {
		return brush;
	}

	/**
	 * @param brush the brush to set
	 */
	public static void setBrush(boolean brush) {
		PanelPaint.brush = brush;
	}

	/**
	 * @param activeColor the activeColor to set
	 */
	public static void setActiveColor(Color activeColor) {
		PanelPaint.activeColor = activeColor;
	}

	/**
	 * @param activeSize the activeSize to set
	 */
	public static void setActiveSize(int activeSize) {
		PanelPaint.activeSize = activeSize;
	}

	/**
	 * @return the activeColor
	 */
	public static Color getActiveColor() {
		return activeColor;
	}

	/**
	 * @return the activeSize
	 */
	public static int getActiveSize() {
		return activeSize;
	}
	
	public static void undo(){
		if(PanelPaint.points.getLength() < 10){
			PanelPaint.points.setLength(0);
		}
		PanelPaint.points.setLength(PanelPaint.points.getLength() - 10);
		
	}

	public static void redo(){
		//TODO
		if(PanelPaint.points.getLength() < 10){
			PanelPaint.points.setLength(0);
		}
		PanelPaint.points.setLength(PanelPaint.points.getLength() - 10);
	}
	
	public void useBrush(Graphics g){
		for (int i = 0; i < PanelPaint.points.getLength(); i++) {
			Point p = PanelPaint.points.elementAt(i);
			if(p.isBrush()){
				g.setColor(p.getColor());
				g.fillOval(p.getX(), p.getY(), p.getSize(), p.getSize());				
			}
		}
	}

	public void usePen(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		for (int i = 0; i < PanelPaint.points.getLength() - 1; i++) {
			Point p1 = PanelPaint.points.elementAt(i);
			Point p2 = PanelPaint.points.elementAt(i+1);
			if(p1.isPen()){
				g.setColor(p1.getColor());
				g2d.setStroke(new BasicStroke(p1.getSize()));
				g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());							
			}
		}
	}
	
	private class MouseHandler implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			Point newPoint = new Point(e.getX(), e.getY(), activeColor, activeSize, pen, brush);
			PanelPaint.points.addPoint(newPoint);
			if(e.isControlDown())
				newPoint.setColor(Color.WHITE);
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
