package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class SummaryRanges {
    
	static private class Interval {
		private int start;
		private int end;
		
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public String toString() {
			return "[" + this.start + "," + this.end + "]";
		}
	}
	
    static private class BSTNode {
        
        private Interval interval;
        BSTNode left;
        BSTNode right;
        
        public BSTNode(Interval i) {
            this.interval = i;
        }
    }
    
    private BSTNode remove(Interval itv, BSTNode root) {
        if (root == null || itv == null) {
            return root;
        }
        
        if (itv.end < root.interval.start) {
            root.left = remove(itv, root.left);
        } else if (itv.start > root.interval.end) {
            root.right = remove(itv, root.right);
        } else if (root.left != null && root.right != null) {
            root.interval = findMin(root.right).interval;
            root.right = remove(root.interval, root.right);
        } else {
            root = root.left != null ? root.left : root.right;
        }
        return root;
    }
    
    private BSTNode findKey(int v, BSTNode root) {
        if (root == null) {
            return null;
        }
        
        if (v < root.interval.start) {
            return findKey(v, root.left);
        } else if (v > root.interval.end) {
            return findKey(v, root.right);
        } else {
            return root;
        }
    }
    
    private BSTNode addKey(int v, BSTNode root) {
        if (root == null) {
            return new BSTNode(new Interval(v, v));
        }
        if (v < root.interval.start) {
            root.left = addKey(v, root.left);
        } else if (v > root.interval.end) {
            root.right = addKey(v, root.right);
        }
        return root;
    }
    
    private BSTNode findMin(BSTNode root) {
        if (root == null) {
            return null;
        }
        
        BSTNode p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }
    
    private List<Interval> inorder(BSTNode root) {
        List<Interval> list = new LinkedList<>();
        Stack<BSTNode> stack = new Stack<>();
        BSTNode p = root;
        
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                BSTNode toPop = stack.pop();
                list.add(toPop.interval);
                p = toPop.right;
            }
        }
        return list;
    }
    
    
    private BSTNode root;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        this.root = null;
    }
    
    public void addNum(int val) {
        if (this.root == null) {
            this.root = addKey(val, this.root);
        } else {
            if (findKey(val, this.root) != null) {
                return;
            }
            BSTNode L = findKey(val - 1, this.root);
            BSTNode R = findKey(val + 1, this.root);
            if (L != null && R != null) {
                int e = R.interval.end;
                this.root = remove(R.interval, this.root);
                L.interval.end = e;
            } else if (L != null) {
                L.interval.end++;
            } else if (R != null) {
                R.interval.start--;
            } else {
                addKey(val, this.root);
            }
        }
    }
    
    public List<Interval> getIntervals() {
        return inorder(this.root);
    }
    
    @Test
    public void test() {
    	SummaryRanges sr = new SummaryRanges();
    	sr.addNum(6);
    	System.out.println(sr.getIntervals().toString());
    	sr.addNum(6);
    	System.out.println(sr.getIntervals().toString());
    	sr.addNum(0);
    	System.out.println(sr.getIntervals().toString());
    	sr.addNum(4);
    	System.out.println(sr.getIntervals().toString());
    	sr.addNum(8);
    	System.out.println(sr.getIntervals().toString());
    	sr.addNum(7);
    	System.out.println(sr.getIntervals().toString());
    	sr.addNum(6);
    	System.out.println(sr.getIntervals().toString());
    	sr.addNum(4);
    	System.out.println(sr.getIntervals().toString());
    	sr.addNum(7);
    	System.out.println(sr.getIntervals().toString());
    	sr.addNum(5);
    	System.out.println(sr.getIntervals().toString());
    }
}
