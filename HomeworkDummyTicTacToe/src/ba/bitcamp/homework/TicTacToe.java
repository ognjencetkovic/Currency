package ba.bitcamp.homework;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TicTacToe extends JFrame{
	
	private static final long serialVersionUID = 3422916801085155976L;
	public static final int NUMBER_OF_ROWS_AND_COLUMNS = 3;
	
	private JButton[][] fields;
	private String sign;
	private int[][] table;
	
	
	public TicTacToe() {
		super();
		setLayout(new GridLayout(TicTacToe.NUMBER_OF_ROWS_AND_COLUMNS, TicTacToe.NUMBER_OF_ROWS_AND_COLUMNS));
		sign = "O";
		
		fields = new JButton[TicTacToe.NUMBER_OF_ROWS_AND_COLUMNS][TicTacToe.NUMBER_OF_ROWS_AND_COLUMNS];
		for (int i = 0; i < fields.length; i++) {
			for (int j = 0; j < fields[i].length; j++) {
				fields[i][j] = new JButton();
				fields[i][j].addActionListener(new Action(fields[i][j], i, j));
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
		private int row;
		private int column;		
		
		public Action(JButton button, int row, int column) {
			super();
			this.button = button;
			this.row = row;
			this.column = column;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(button.getText().equals("") && sign.equals("X")){
				sign = "O";
				button.setText(sign);
				table[row][column] = 2;
			} else if(button.getText().equals("") && sign.equals("O")){
				sign = "X";
				button.setText(sign);
				table[row][column] = 1;
			}
		}
	}
	
	public void getEmptytable(){
		table = new int[TicTacToe.NUMBER_OF_ROWS_AND_COLUMNS][TicTacToe.NUMBER_OF_ROWS_AND_COLUMNS];
	}
	
	public boolean checktable(int turn, int i, int j){
		if(table[i][j] == 0){
			table[i][j] = turn;
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		new TicTacToe();
	}
}
