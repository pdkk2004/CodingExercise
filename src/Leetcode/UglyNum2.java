package Leetcode;
import java.util.ArrayList;

public class UglyNum2 {
	
	public static void main(String[] args) {
		System.out.println(nthUglyNumber(7));
	}
	
    public static int nthUglyNumber(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(1);
        int i1 = 0, i2 = 0, i3 = 0;
        while (res.size() < n) {
            int m1 = res.get(i1) * 2;
            int m2 = res.get(i2) * 3;
            int m3 = res.get(i3) * 5;
            int min = Math.min(m1, Math.min(m2, m3));
            res.add(min);
            if (min == m1) {
                i1++;
            }
            if (min == m2) {
                i2++;
            }
            if (min == m3){
                i3++;
            }
        }
        System.out.println(res.toString());
        return res.get(res.size() - 1);
    }
}
