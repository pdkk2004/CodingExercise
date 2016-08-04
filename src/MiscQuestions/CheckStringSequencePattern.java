package MiscQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.*;

/**
 * 判断字符串s是否是按照顺序规则字符串t排好序的。t规定哪个字符该出现在哪个前面。t是有效的顺序字符串。即每个字符不会出现多次，但也不确保26个字母都有。
 * s中某些字符可能不在t中，那么这些字符必须得跟自己相同的字符成群出现（不能有脱离群体单独出现的）。 s= "ccbbfffffaaaa" t="cba"
 * => true 因为t规定c在b前，b在a前出现，s确实如此。f不在t中出现，但f是成群出现的。因此符合。 s= "ccbbfffffaaaaffff"
 * t="cba" => false， f没有成群出现。
 * 
 * @author kkdpan
 */

public class CheckStringSequencePattern {

	public boolean isValid(String str, String pattern) {
		int si = 0, pi = 0;
		Map<Character, Integer> pMap = new HashMap<>();
		Set<Character> metBefore = new HashSet<>();
		for (int i = 0; i < pattern.length(); i++) {
			pMap.put(pattern.charAt(i), i);
		}

		while (si < str.length()) {
			char c = str.charAt(si);
			int sj = si + 1;
			while (sj < str.length() && str.charAt(sj) == c) {
				sj++;
			}
			if (pMap.containsKey(c)) {
				int pos = pMap.get(c);
				if (pos < pi) {
					return false;
				} else {
					pi = pos;
				}
			} else {
				if (metBefore.contains(c)) {
					return false;
				} else {
					metBefore.add(c);
				}
			}
			si = sj;
		}
		return true;
	}

	@Test
	public void test() {
		Assert.assertEquals(true, isValid("ccbbfffffaaaa", "cba"));
		Assert.assertEquals(false, isValid("ccbbfffffaaaaffff", "cba"));
		Assert.assertEquals(false, isValid("accbbfffffaaaa", "cba"));
		Assert.assertEquals(false, isValid("aaaaccbbfffff", "cba"));
		Assert.assertEquals(false, isValid("aaaaeeeccbbfffff", "cba"));

	}
}
