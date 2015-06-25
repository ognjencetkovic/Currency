package ba.bitcamp.homework;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DummyTicTacToe extends JFrame{
	
	private static final long serialVersionUID = 3422916801085155976L;
	public static final int NUMBER_OF_ROWS_AND_COLUMNS = 3;
	
	private JButton[][] fields;
	private String sign;
	
	
	public DummyTicTacToe() {
		super();
		setLayout(new GridLayout(DummyTicTacToe.NUMBER_OF_ROWS_AND_COLUMNS, DummyTicTacToe.NUMBER_OF_ROWS_AND_COLUMNS));
		sign = "";
		
		fields = new JButton[DummyTicTacToe.NUMBER_OF_ROWS_AND_COLUMNS][DummyTicTacToe.NUMBER_OF_ROWS_AND_COLUMNS];
		for (int i = 0; i < fields.length; i++) {
			for (int j = 0; j < fields[i].length; j++) {
				fields[i][j] = new JButton();
				fields[i][j].addActionListener(new Action(fields[i][j]));
				add(fields[i][j]);
			}
		}
		
		setTitle("Tic Tac Toe");
		setSize(300, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	private class Action implements ActionListener {
		
		private JButton button;
		
		public Action(JButton button) {
			super();
			this.button = button;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(sign.equals("X")){
				sign = "O";
			} else {
				sign = "X";
			}
			button.setText(sign);
		}
	}
	
	public static void main(String[] args) {
		new DummyTicTacToe();
	}
}
