package MiscQuestions;

public class ChunkPalindrome {

	/**
	 * 实现int countChunk(String input)， 给定一个字符串，找出最多有多少个chunked palindrome,
		正常的palindrome是abccba, chunked palindrome的定义是：比如volvo, 可以把vo划分在一起，(vo) (l) (vo)，
		那么它是个palindrome。求实现返回最大的chunk 数量。
	 * @param str
	 * @return
	 */
	public int chunkPalindrome(String str) {
		int l = str.length();
		if (l < 2) {
			return l;
		}
		
		for (int i = 1; i <= l / 2; i++) {
			String left = str.substring(0, i);
			String right = str.substring(l - i);
			if (left.equals(right)) {
				return 2 + chunkPalindrome(str.substring(i, l - i));
			}
		}
		return 1;  //Note if str is not a plindrome, it can be treated as on chunk then the palindrome chunk is 1.
	}
}
