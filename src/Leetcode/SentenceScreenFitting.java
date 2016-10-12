package Leetcode;

public class SentenceScreenFitting {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        String pattern = String.join(" ", sentence) + " ";
        int len = pattern.length();
        int start = 0;
        for (int i = 0; i < rows; i++) {
            start = start + cols;
            if (pattern.charAt(start % len) == ' ') {
                start++;
            } else {
                while (start > 0 && pattern.charAt((start - 1) % len) != ' ') {
                    start--;
                }
            }
        }
        return start / len;
    }
}
