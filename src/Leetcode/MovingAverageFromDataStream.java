package Leetcode;

public class MovingAverageFromDataStream {
    
	private int size;
    private int count;
    private int sum;
    private int[] data;
    
    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
        this.size = size;
        this.data = new int[size];
    }
    
    public double next(int val) {
        count++;
        sum += val - data[(count - 1) % size];
        data[(count - 1) % size] = val;
        return sum / (double)(count < size ? count : size);
    }
}
