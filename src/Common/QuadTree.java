package Common;

import java.util.ArrayList;

/**
 * QuadTree implemention.
 * According to interview question:
 * http://www.fgdsb.com/2015/01/25/intersection-of-two-quadtrees/
 * The num represents the number of 1 of a QuadTree.
 * @author kkdpan
 *
 */
public class QuadTree {
	
	public ArrayList<QuadTree> children = new ArrayList<QuadTree>();
	public int num = 0;
	
	public QuadTree() {
		
	}
	
	public QuadTree(int num) {
		this.num = num;
	}
}
