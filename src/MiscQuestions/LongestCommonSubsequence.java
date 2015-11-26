package MiscQuestions;

/*
 * http://www.fgdsb.com/2015/01/03/longest-common-subsequence/
 */
public class LongestCommonSubsequence {

	public int lcs(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		int[][] L = new int[l1 + 1][l2 + 1];
		
		for (int i = 0; i < l1; i++) {
			for (int j = 0; j < l2; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					L[i + 1][j + 1] = L[i][j] + 1;
				} else {
					L[i + 1][j + 1] = Math.max(L[i][j + 1], L[i + 1][j]);
				}
			}
		}
		return L[l1][l2];
	}
}
