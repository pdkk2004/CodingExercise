package Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class StrStrKMP {
	
	public static int strStr(String s, String p) {
		int ls = s.length();
		int lp = p.length();
		int i = 0, j = 0;
		int[] next = next(p);
		
		while (i < ls && j < lp) {
			if (s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
				if (j == lp) {
					return i - lp;
				}
			} else if (j > 0){
				j = next[j];
			} else {
				i++;
			}
		}
		return -1;
	}
	
	/**
	 * My own implementation.
	 * @param p
	 * @return
	 */
	private static int[] next(String p) {
		int l = p.length();
		int[] N = new int[l + 1];
		N[0] = -1;
		
		for (int i = 2; i <= l; i++) {
			int j = N[i - 1];
			while (true) {
				if (p.charAt(i - 1) == p.charAt(j)) {
					N[i] = j + 1;
					break;
				} else if (j > 0) {
					j = N[j];
				} else {
					N[i] = 0;
					break;
				}
			}
		}
		return N;
	}
	
	/**
	 * Implementation from
	 * http://blog.csdn.net/v_july_v/article/details/7041827
	 * @param p
	 * @return
	 */
	private static int[] next1(String p) {
		int l = p.length();
		int[] N = new int[l + 1];
		N[0] = -1;
		
		int i = 0;
		int j = -1;
		while (i < l) {
			if (j == -1 || p.charAt(i) == p.charAt(j)) {
				i++;
				j++;
				N[i] = j;
			} else {
				j = N[j];
			}
		}
		return N;
	}
	
	@Test
	public void TestNext() {
		String s = "ABABA";
		int[] N = next(s);
		System.out.println(Arrays.toString(N));
		int[] N1 = next1(s);
		System.out.println(Arrays.toString(N1));
		
		Assert.assertArrayEquals(N, N1);
	}
	
	@Test
	public void TestKMP() {
		String p = "ABCDABD";
		String s = "ADFABCDABDERFL";
		
		Assert.assertEquals(3, strStr(s, p));
	}
}
