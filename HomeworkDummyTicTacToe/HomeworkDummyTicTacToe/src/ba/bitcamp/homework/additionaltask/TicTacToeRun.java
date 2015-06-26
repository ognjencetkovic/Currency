package ba.bitcamp.homework.additionaltask;
/**
 * Class containing logic needed to run a game of Tic Tac Toe.
 * @author ognjen.cetkovic
 *
 */
public class TicTacToeRun {

	public static final int GAME_ACTIVE = -1;
	public static final int GAME_IS_A_TIE = 0;
	public static final int PLAYER_X = 1;
	public static final int PLAYER_O = 2;
	public static final int NUMBER_OF_ROWS_AND_COLUMNS = 3;
	
	private int[][] table;
	private int player;
	private int counter;
	
	/**
	 * Default constructor.
	 */
	public TicTacToeRun() {
		super();
		this.table = new int[TicTacToeRun.NUMBER_OF_ROWS_AND_COLUMNS][TicTacToeRun.NUMBER_OF_ROWS_AND_COLUMNS];
		this.player = PLAYER_X;
		this.counter = 0;
	}
	
	/**
	 * Inputs value at row i, column j.
	 * @param i A row
	 * @param j A column
	 */
	public void changeTable(int i, int j){
		table[i][j] = player;
		counter++;
	}
	
	/**
	 * Changes players (X to O, and vice versa).
	 */
	public void changePlayer(){
		if(player == TicTacToeRun.PLAYER_X)
			player = TicTacToeRun.PLAYER_O;
		else
			player = TicTacToeRun.PLAYER_X;
	}
	
	/**
	 * Checks game`s status and returns -1 if game is still active, 0 if it`s a tie, and 1 or 2 if 
	 * one of the players won (1 if it is X, ot 2 if it is O).
	 * @return
	 */
	public int getStatus(){
		if(checkRows() || checkColumns() || checkDiagonals())
			return player;
		else if(counter == TicTacToeRun.NUMBER_OF_ROWS_AND_COLUMNS * NUMBER_OF_ROWS_AND_COLUMNS)
			return TicTacToeRun.GAME_IS_A_TIE;
		changePlayer();
		return TicTacToeRun.GAME_ACTIVE;
	}

	/**
	 * Returns true if one row of given matrix contains Xs or Os (1s or 2s represent players in code). 
	 * @return True if one row contains Xs or Os
	 */
	public boolean checkRows(){
		boolean hasWon = true;
		for (int i = 0; i < table.length; i++) {
			hasWon = true;
			for (int j = 0; j < table.length; j++) {
				if(table[i][j] != player){
					hasWon = false;
					break;
				}
			}
			if(hasWon){
				break;
			}
		}
		return hasWon;
	}
	
	/**
	 * Returns true if one column of given matrix contains Xs or Os (1s or 2s representing players in code). 
	 * @return True if one column contains Xs or Os
	 */
	public boolean checkColumns(){
		boolean hasWon = true;
		int[] array;
		for (int i = 0; i < table.length; i++) {
			hasWon = true;
			array = getColumnFromMatrix(table, i);
			for (int j = 0; j < array.length; j++) {
				if(array[j] != player){
					hasWon = false;
					break;
				}
			}
			if(hasWon){
				break;
			}
		}
		return hasWon;
	}
	
	/**
	 * Returns true if one diagonal of given matrix contains Xs or Os (1s or 2s representing players in code). 
	 * @return True if one diagonal contains Xs or Os
	 */
	public boolean checkDiagonals(){
		boolean hasWon = true;
		int[] array = getPrimaryDiagonalFromMatrix(table);
		for (int j = 0; j < array.length; j++) {
			if(array[j] != player){
				hasWon = false;
				break;
			}
		}
		if(hasWon){
			return hasWon;
		}
		hasWon = true;
		array = getSecondaryDiagonalFromMatrix(table);
		for (int j = 0; j < array.length; j++) {
			if(array[j] != player){
				hasWon = false;
				break;
			}
		}
		return hasWon;
	}
	
	/**
	 * Returns an array containing elements of given column.
	 * @param matrix A matrix representing Tic Tac Toe table
	 * @param index Index of column
	 * @return An array
	 */
	public static int[] getColumnFromMatrix(int[][] matrix, int index){
		int[] array = new int[matrix.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = matrix[i][index];
		}
		return array;
	}
	
	/**
	 * Returns an array containing elements of primary diagonal.
	 * @param matrix A matrix representing Tic Tac Toe table
	 * @return An array
	 */
	public static int[] getPrimaryDiagonalFromMatrix(int[][] matrix){
		int[] array = new int[matrix.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = matrix[i][i];
		}
		return array;
	}

	/**
	 * Returns an array containing elements of secondary diagonal.
	 * @param matrix A matrix representing Tic Tac Toe table
	 * @return An array
	 */
	public static int[] getSecondaryDiagonalFromMatrix(int[][] matrix){
		int[] array = new int[matrix.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = matrix[i][array.length - 1 - i];
		}
		return array;
	}
	
	
}
