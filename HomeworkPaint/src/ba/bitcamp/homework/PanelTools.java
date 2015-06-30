package ba.bitcamp.homework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelTools extends JPanel {
	
	private static final long serialVersionUID = 2474028279626979307L;

//	private static final int MINIMUM_BRUSH_SIZE = 5;
//	private static final int MAXIMUM_BRUSH_SIZE = 50;
//	private static final int STEP_BRUSH_SIZE = 5;

	//private static int activeSize;
	private JButton btnBrushSizePlus = new JButton("+");
	private JButton btnBrushSizeMinus = new JButton("-");
	private JButton btnPen = new JButton("Pen");
	private JButton btnBrush = new JButton("Brush");
	private JButton btnUndo = new JButton("Undo");
	private JButton btnRedo = new JButton("Redo");
	
	
	
	public PanelTools() {
		
		//activeSize = MINIMUM_BRUSH_SIZE;
		PanelPaint.setActiveSize(PanelPaint.MINIMUM_SIZE);
		
		
		btnBrushSizeMinus.addActionListener(new Action());
		btnBrushSizePlus.addActionListener(new Action());
		btnPen.addActionListener(new Action());
		btnBrush.addActionListener(new Action());
		btnUndo.addActionListener(new Action());
		btnRedo.addActionListener(new Action());
		
		
		add(btnBrushSizeMinus);
		add(btnBrushSizePlus);
		add(btnPen);
		add(btnBrush);
		add(btnUndo);
		add(btnRedo);
	}
	
	private class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnBrushSizeMinus && PanelPaint.getActiveSize() > PanelPaint.MINIMUM_SIZE){
				PanelPaint.setActiveSize(PanelPaint.getActiveSize() - PanelPaint.STEP_SIZE);
				//activeSize -= PanelTools.STEP_BRUSH_SIZE;
			} else if(e.getSource() == btnBrushSizePlus && PanelPaint.getActiveSize() < PanelPaint.MAXIMUM_SIZE){
				PanelPaint.setActiveSize(PanelPaint.getActiveSize() + PanelPaint.STEP_SIZE);
				//activeSize += PanelTools.STEP_BRUSH_SIZE;
			} else if(e.getSource() == btnPen){
				PanelPaint.setBrush(false);
				PanelPaint.setPen(true);
			} else if(e.getSource() == btnBrush){
				PanelPaint.setBrush(true);
				PanelPaint.setPen(false);
			} else if (e.getSource() == btnUndo){
				PanelPaint.undo();
			} else if (e.getSource() == btnUndo){
				PanelPaint.redo();
			}
			
		}
		
	}



//	/**
//	 * @return the activeSize
//	 */
//	public int getActiveSize() {
//		return activeSize;
//	}
	
	
}
