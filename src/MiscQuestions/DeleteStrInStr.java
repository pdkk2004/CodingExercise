package MiscQuestions;

import org.junit.*;

public class DeleteStrInStr {

	public int deleteStr(String source, String target) {
		if (source == null || target == null || target.length() == 0) {
			return 0;
		}
		
		StringBuilder sb = new StringBuilder(source);
		int count = 0;
		int i = 0;
		while (i <= sb.length() - target.length()) {
			int j = 0;
			while (j < target.length() && sb.charAt(i + j) == target.charAt(j)) {
				j++;
			}
			if (j == target.length()) {
				count++;
				sb.delete(i, i + j);
				if (i > 0) {
					i--;
				}
			} else {
				i++;
			}
		}
		return count;
	}
	
	@Test
	public void test() {
		String source = "aabb";
		String target = "ab";
		Assert.assertEquals(2, deleteStr(source, target));
		
		source = "abab";
		Assert.assertEquals(2, deleteStr(source, target));
		
		source = "abcab";
		Assert.assertEquals(2, deleteStr(source, target));
		
		source = "abacb";
		Assert.assertEquals(1, deleteStr(source, target));
		
		target = "";
		Assert.assertEquals(0, deleteStr(source, target));
		
		source = "aaabbb";
		target = "ab";
		Assert.assertEquals(3, deleteStr(source, target));

	}
	
	
}
