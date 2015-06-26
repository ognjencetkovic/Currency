package ba.bitcamp.homework.additionaltask;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 * Window containing Tic Tac Toe table.
 * @author ognjen.cetkovic
 *
 */
public class TicTacToeGUI extends JFrame{
	
	private static final long serialVersionUID = 3422916801085155976L;
	public static final int NUMBER_OF_ROWS_AND_COLUMNS = 3;
	public static final String SIGN_X = "X";
	public static final String SIGN_O = "O";
	
	private JButton[][] fields;
	private String sign;
	private TicTacToeRun game;
	
	/**
	 * Default constructor.
	 */
	public TicTacToeGUI() {
		super();
		setLayout(new GridLayout(TicTacToeGUI.NUMBER_OF_ROWS_AND_COLUMNS, TicTacToeGUI.NUMBER_OF_ROWS_AND_COLUMNS));
		
		fields = new JButton[TicTacToeGUI.NUMBER_OF_ROWS_AND_COLUMNS][TicTacToeGUI.NUMBER_OF_ROWS_AND_COLUMNS];
		for (int i = 0; i < fields.length; i++) {
			for (int j = 0; j < fields[i].length; j++) {
				fields[i][j] = new JButton();
				fields[i][j].addActionListener(new Action(fields[i][j], i, j));
				fields[i][j].setBackground(new Color(0, 0, 205));
				fields[i][j].setFont(new Font("Calibri", Font.BOLD, 26));
				fields[i][j].setForeground(Color.WHITE);
				add(fields[i][j]);
			}
		}
		
		sign = TicTacToeGUI.SIGN_X;
		game = new TicTacToeRun();
		
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
			if(button.getText().equals("")){
				turn(button, row, column);				
			}
		}
	}
	
	/**
	 * Changes sign from X to O, and vice versa.
	 */
	public void changeSign(){
		if(sign == TicTacToeGUI.SIGN_O)
			sign = TicTacToeGUI.SIGN_X;
		else
			sign = TicTacToeGUI.SIGN_O;
	}
	
	/**
	 * Inputs new results and checks if the game is over, if so, constructs OptionWindow.
	 * @param button Button that was pressed
	 * @param row Row of the button
	 * @param column Column of the button
	 */
	public void turn(JButton button, int row, int column){
		button.setText(sign);
		game.changeTable(row, column);
		if(game.getStatus() == TicTacToeRun.GAME_IS_A_TIE){
			new OptionWindow("<html>It`s a tie!<br>Play another game?</html>");
			setVisible(false);
		} else if(game.getStatus() == TicTacToeRun.PLAYER_X){
			new OptionWindow("<html>Player X won!<br>Play another game?</html>");
			setVisible(false);			
		} else if(game.getStatus() == TicTacToeRun.PLAYER_O){
			new OptionWindow("<html>Player O won!<br>Play another game?</html>");
			setVisible(false);			
		}
		changeSign();
	}
}
