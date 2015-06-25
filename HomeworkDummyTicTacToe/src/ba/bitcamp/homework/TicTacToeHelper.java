package ba.bitcamp.homework;

public class TicTacToeHelper {

	public static final int PLAYER_X = 1;
	public static final int PLAYER_Y = 2;
	
	private int[][] table;
	private int player;
	
	/**
	 * @param board
	 */
	public TicTacToeHelper(int[][] table) {
		super();
		this.table = table;
		this.player = PLAYER_X;
	}
	
	public void getEmptytable(){
		table = new int[TicTacToe.NUMBER_OF_ROWS_AND_COLUMNS][TicTacToe.NUMBER_OF_ROWS_AND_COLUMNS];
	}
	
	public boolean checktable(int i, int j){
		if(table[i][j] == 0){
			table[i][j] = player;
			changePlayer();
			return true;
		}
		return false;
	}
	
	public void changePlayer(){
		if(player == TicTacToeHelper.PLAYER_X)
			player = TicTacToeHelper.PLAYER_Y;
		else
			player = TicTacToeHelper.PLAYER_X;
	}

	/**
	 * Returns true if one row of given matrix contains Xs or Os (1s or 2s representing players in code). 
	 * @param table A matrix representing Tic Tac Toe table
	 * @param player Index of player
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
	 * @param table A matrix representing Tic Tac Toe table
	 * @param player Index of player
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
	 * @param table A matrix representing Tic Tac Toe table
	 * @param player Index of player
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
