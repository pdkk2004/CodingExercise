package Leetcode;

import org.apache.commons.lang.NotImplementedException;

public class FindTheCelebrity {
    public int findCelebrity(int n) {
        int cand = 0;
        for (int i = 1; i < n; i++) {
            boolean know = knows(cand, i);
            if (know) {
                cand = i;
            } 
        }
        
        for (int i = 0; i < n; i++) {
            if (cand != i && (!knows(i, cand) || knows(cand, i))) {
                return -1;
            }
        }
        return cand;
    }
    
    private boolean knows(int a, int b) {
    	throw new NotImplementedException();
    }
}
