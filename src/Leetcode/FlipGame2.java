package Leetcode;

public class FlipGame2 {
	
	public boolean canWin(String s) {
		for (int i = -1; (i = s.indexOf("--", i + 1)) >= 0;) {
			if (!canWin(s.substring(0, i) + '-' + s.substring(i + 2))) {
				return true;
			}
		}
		return false;
	}
}
