package MiscQuestions;

/**
给一个矩形区域长w高h，给一个string，给一个font的范围minF->maxF
 给两个函数可以调用height_of(font)返回某个font的高度，width_of(font, ch)返回某个char在某个font的长度，求能在矩形中放下string的最大font size
 理解题意就用了15分钟，最后写的还有小bug，来不及改了说了思路她说sounds work，但是感觉悲剧了

 Followup: 这个题还有个followup。。。要求换行不能切断单词

 Followup: è¿™ä¸ªé¢˜è¿˜æœ‰ä¸ªfollowupã€‚ã€‚ã€‚è¦�æ±‚æ�¢è¡Œä¸�èƒ½åˆ‡æ–­å�•è¯�

 http://www.1point3acres.com/bbs/thread-168483-1-1.html
 johnjavabean
 */
public class FontsInRectangle {
   int height_of(int font) {
       return 1;
   }
    int width_of(int font, int ch) {
       return 1;
   }

   int maximumFit(int w, int h, int minF, int maxF, String s) {
       int low = minF, high = maxF;
       while (low < high) {
           int mid = (low+high)/2;
           if (canFit(w, h, mid, s)) {
               low = mid;
           } else {
               high = mid;
           }
       }
       return low;
   }

    boolean canFit(int w, int h, int font, String s) {
        // How many lines can you fit?
        int numberOfLines = h /height_of(font);

        char[] arr = s.toCharArray();
        int widthOfCurrentLine = 0;
        int lineNumber = 0;
        for (char c : arr) {
            if (widthOfCurrentLine + width_of(font, c) > w) {
                // can't fit into the current line
                // choose new line
                lineNumber++;
                widthOfCurrentLine = width_of(font, c);
            } else {
                widthOfCurrentLine += width_of(font, c);
            }
            if (lineNumber > numberOfLines) {
                return false;
            }
        }
        return true;
    }

    // Follow-up: how many words can fit
    boolean canFitWords(int w, int h, int font, String s) {

        // How many lines can you fit?
        int numberOfLines = h /height_of(font);

        String[] arr = s.split(" ");
        int widthOfCurrentLine = 0;
        int lineNumber = 0;
        for (String word : arr) {
            if (widthOfCurrentLine + width_of(font, word) > w) {
                // can't fit into the current line
                // choose new line
                lineNumber++;
                widthOfCurrentLine = width_of(font, word);
            } else {
                widthOfCurrentLine += width_of(font, word);
            }
            if (lineNumber > numberOfLines) {
                return false;
            }
        }
        return true;
    }

    int width_of(int font, String word) {
        int total = 0;
        for (char c : word.toCharArray()) {
            total += width_of(font, c);
        }
        return total;
    }
}
