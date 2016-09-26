package Leetcode;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class MaximalRectangle {
	public static int maximalRectangle(char[][] matrix) {
		int m = matrix.length;
		if (m == 0) {
			return 0;
		}
		int n = matrix[0].length;

		int[] hist = new int[n];
		int maxArea = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					hist[j] = 0;
				} else {
					hist[j] = i > 0 ? hist[j] + 1 : 1;
				}
			}
			int area = largestRectangleArea(hist);
			maxArea = Math.max(area, maxArea);
		}
		return maxArea;
	}

    private static int largestRectangleArea(int[] heights) {
        int l = heights.length;
        Stack<Integer> hts = new Stack<>();
        Stack<Integer> positions = new Stack<>();
        
        int maxArea = 0;
        for (int i = 0; i < l; i++) {
            if (hts.isEmpty() || heights[i] > hts.peek()) {
                hts.push(heights[i]);
                positions.push(i);
            } else if (heights[i] == hts.peek()) {
                continue;
            } else {
                int ht = 0;
                int pos = 0;
                while (!hts.isEmpty() && hts.peek() >= heights[i]) {
                    ht = hts.pop();
                    pos = positions.pop();
                    maxArea = Math.max(ht * (i - pos), maxArea);
                }
                hts.push(heights[i]);
                positions.push(pos);
            }
        }
        
        while (!hts.isEmpty()) {
            maxArea = Math.max(maxArea, (l - positions.pop()) * hts.pop());
        }
        return maxArea;
    }
	
    @Test
	public void test() {
		int[] hists = {1};
		int area = largestRectangleArea(hists);
		Assert.assertEquals(1, area);
	}
}
