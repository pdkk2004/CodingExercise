package Common;

public class TreeNodeWithParent extends TreeNode {
	
	public TreeNodeWithParent p;
	
	public TreeNodeWithParent(int v) {
		super(v);
	}
	
	public TreeNodeWithParent(int v, TreeNodeWithParent p) {
		this(v);
		this.p = p;
	}
}
