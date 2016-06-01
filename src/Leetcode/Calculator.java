package Leetcode;

import java.util.Stack;

public class Calculator {
    
	
	public static void main(String[] args) {
		Calculator c = new Calculator();
		System.out.println(c.calculate("100000/1/2"));
	}
	
    private static enum Operator {
        PLUS('+'),
        MULT('*'),
        SUB('-'),
        DIV('/');
        
        private char sign;
        
        private Operator(char sign) {
            this.sign = sign;
        }
        
        public static Operator fromSign(char s) {
            for (Operator o : Operator.values()) {
                if (o.sign == s) {
                    return o;
                }
            }
            throw new IllegalArgumentException("");
        }
        
        public static boolean isOper(char s) {
            return '+' == s || '-' == s || '*' == s || '/' == s;
        }
        
        public int compare(Operator o) {
            return this.ordinal() % 2 - o.ordinal() % 2;
        }
        
        public int calculate(int n1, int n2) {
            switch(this.sign) {
                case '+' : return n1 + n2;
                case '-' : return n1 - n2;
                case '*' : return n1 * n2;
                case '/' : return n1 / n2;
                default : throw new RuntimeException();
            } 
        }
    }
    
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Operator> ops = new Stack<>();
        int i = 0;
        while (i < s.length())  {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            
            if (!Operator.isOper(c)) {
                int v = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    v = v * 10 + s.charAt(i) - '0';
                    i++;
                }
                nums.push(v);
            } else {
                Operator op = Operator.fromSign(c);
                if (ops.isEmpty() || op.compare(ops.peek()) > 0) {
                    ops.push(op);
                } else {
                    while (!ops.isEmpty() && op.compare(ops.peek()) <= 0) {
                        Operator o = ops.pop();
                        int n2 = nums.pop();
                        int n1 = nums.pop();
                        nums.push(o.calculate(n1, n2));
                    }
                    ops.push(op);
                }
                i++;
            }
        }
        
        
        while (!ops.isEmpty()) {
            Operator op = ops.pop();
            int n2 = nums.pop();
            int n1 = nums.pop();
            nums.push(op.calculate(n1, n2));
        }
        
        
        if (nums.size() != 1) {
            throw new RuntimeException();
        }
        return nums.pop();
    }
}
