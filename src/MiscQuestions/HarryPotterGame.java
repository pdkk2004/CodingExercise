package MiscQuestions;

/**
 * http://www.fgdsb.com/2015/01/06/harry-potter-game/
 * @author dipa
 *
 */
public class HarryPotterGame {
	
	public static int initialStrength(int[][] mat) {
		int m = mat.length;
		if (m == 0) {
			throw new IllegalArgumentException();
		}
		int n = mat[0].length;
		
		int[][] L = new int[m][n];
		
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1 && j == n - 1) {
					L[i][j] = Math.max(1, 1 - mat[i][j]);
				}
				int right = (j == n - 1 ? Integer.MAX_VALUE : L[i][j + 1] - mat[i][j]);
				int down = (i == m - 1 ? Integer.MAX_VALUE : L[i + 1][j] - mat[i][j]);
				L[i][j] = Math.max(1, Math.min(right, down));
			}
		}
		return L[0][0];
	}
}
