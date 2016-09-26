package Leetcode;

public class DesignTicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagnal;
    private int antiDiagnal;
    private int n;
    
    /** Initialize your data structure here. */
    public DesignTicTacToe(int n) {
        this.n = n;
        this.rows = new int[n];
        this.cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        rows[row] += player == 2 ? -1 : 1;
        cols[col] += player == 2 ? -1 : 1;
        if (row == col) {
            diagnal += player == 2 ? -1 : 1;
        }
        
        if (row + col == n - 1) {
            antiDiagnal += player == 2 ? -1 : 1;
        }
        
        for (int i = 0; i < n; i++) {
            if (Math.abs(rows[i]) == n) {
                return rows[i] > 0 ? 1 : 2;
            }
            if (Math.abs(cols[i]) == n) {
                return cols[i] > 0 ? 1 : 2;
            }
        }
        
        if (Math.abs(diagnal) == n) {
            return diagnal > 0 ? 1 : 2;
        }
        if (Math.abs(antiDiagnal) == n) {
            return antiDiagnal > 0 ? 1 : 2;
        }
        return 0;
    }
}
