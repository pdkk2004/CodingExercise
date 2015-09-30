package Leetcode;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int s = carry;
            if (i >= 0) {
                s += a.charAt(i) - '0';
            }
            if (j >= 0) {
                s += b.charAt(j) - '0';
            }
            
            int d = s / 2;
            int r = s % 2;
            carry = d;
            sb.insert(0, r);
        }
        
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString(); 
    }
}
