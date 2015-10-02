package Leetcode;
import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	
	public static void main(String[] args) {
		System.out.println(isHappy(3));
	}
	
    public static boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<Integer>();
        while (n != 1) {
            visited.add(n);
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) ^ 2;
                n = n / 10;
            }
            if (visited.contains(sum)) {
                return false;
            } else {
                n = sum;
            }
        }
        return true;
    }
}
