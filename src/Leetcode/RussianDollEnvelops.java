package Leetcode;

import java.util.Arrays;

public class RussianDollEnvelops {
    private class Tuple implements Comparable<Tuple>{
        int w;
        int h;
        
        public Tuple(int w, int h) {
            this.w = w;
            this.h = h;
        }
        
        public int compareTo(Tuple t) {
            if (this.w != t.w) {
                return this.w - t.w;
            } else {
                return this.h - t.h;
            }
        }
    }
    
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n <= 1) {
            return n;
        }
        Tuple[] envs = new Tuple[n];;
        for (int i = 0; i < n; i++) {
            envs[i] = new Tuple(envelopes[i][0], envelopes[i][1]);
        }
        
        Arrays.sort(envs);
        int largest = 0;
        
        int[] ret = new int[envelopes.length];
        ret[0] = 1;
        for (int i = 1; i < n; i++) {
            int prevLargest = findPrevLargestEnv(envs, i, ret);
            ret[i] = prevLargest + 1;
            largest = Math.max(ret[i], largest);
        }
        
        return largest;
    }
    
    private int findPrevLargestEnv(Tuple[] envs, int index, int[] rst) {
        int largest = 0;
        for (int i = index - 1; i >= 0; i--) {
            if (envs[index].h > envs[i].h && envs[index].w > envs[i].w && rst[i] > largest) {
                largest = rst[i];
            }
        }
        return largest;
    }
}
