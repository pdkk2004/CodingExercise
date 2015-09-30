package Leetcode;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] input = {""};
		System.out.println(sol.fullJustify(input, 2));
	}
	
    public List<String> fullJustify(String[] words, int L) {
        List<String> ret = new LinkedList<String>();
        int count = 0;
        int len = 0;
        int i = 0;
        while (i < words.length) {
            String word = words[i];
            int newLen = len + count + word.length();
            if (newLen <= L) {
                count++;
                len = len + word.length();
                i++;
            } else {
                String newLine = composeLine(words, i - count, count, len, L);
                ret.add(newLine);
                count = 0;
                len = 0;
            }
            if (i == words.length) {
                ret.add(composeLine(words, i - count, count, len, L));
            }
        }
        return ret;
    }
    
    private String composeLine(String[] words, int start, int count, int len, int limit) {
        StringBuilder sb = new StringBuilder();
        
        //handle last line
        if (start + count == words.length) {
            for (int i = start; i < start + count - 1; i++) {
                sb.append(words[i]).append(" ");
            }
            sb.append(words[start + count - 1]);
            
            for (int i = 0; i < limit - sb.length(); i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        
        if (count == 1) {
            sb.append(words[start]);
            for (int i = 0; i < limit - words[start].length(); i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        
        //handle lines except last line
        int baseSpaces = (limit - len) / (count - 1);
        int extraSpace = (limit - len) % (count - 1);
        String baseSpaceStr = spaceHelper(baseSpaces);
        
        for (int i = 0; i < count - 1; i++) {
            sb.append(words[start + i]).append(baseSpaceStr);
            if (i >= count - extraSpace - 1) {
                sb.append(" ");
            }
        }
        sb.append(words[start + count - 1]);
        return sb.toString();
    }
    
    private String spaceHelper(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}