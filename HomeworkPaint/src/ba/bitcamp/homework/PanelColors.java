package ba.bitcamp.homework;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelColors extends JPanel{
	
	private static final long serialVersionUID = -5980706311428588011L;

	private static Color[] supportedColors = new Color[]{Color.BLACK, Color.BLUE, Color.RED, Color.ORANGE, Color.CYAN, Color.GREEN};
	
	private JButton[] btnsColor = new JButton[supportedColors.length];
	//private static Color activeColor;
	
	public PanelColors() {
		PanelPaint.setActiveColor(supportedColors[0]);
		
		for (int i = 0; i < btnsColor.length; i++) {
			btnsColor[i] = new JButton("Pick");
			btnsColor[i].setName(Integer.toString(i));
			btnsColor[i].setForeground(supportedColors[i]);
			btnsColor[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton clicked = (JButton) e.getSource();
					PanelPaint.setActiveColor(supportedColors[Integer.parseInt(clicked.getName())]);
					//activeColor = supportedColors[Integer.parseInt(clicked.getName())];
				}
			});
			
			add(btnsColor[i]);
		}
	}

//	/**
//	 * @return the activeColor
//	 */
//	public Color getActiveColor() {
//		return activeColor;
//	}
	
}
