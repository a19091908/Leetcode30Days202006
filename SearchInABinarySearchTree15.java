package leetCodeJun2020;

public class SearchInABinarySearchTree15 {

	public static void main(String[] args) {
		TreeNode15 root = new TreeNode15(4,
				new TreeNode15(2,
						new TreeNode15(1), 
						new TreeNode15(3)
						),
				new TreeNode15(7));
		int val = 5;
		TreeNode15 ansNode = searchBST(root,val);
		System.out.println((ansNode == null)? null:ansNode.val);
	}

	private static TreeNode15 searchBST(TreeNode15 root, int val) {
		if (root == null) 
			return null;
		
		if (root.val == val) 
			return root;
		else
		if (root.val > val) 
			return searchBST(root.left,val);
		else
			return searchBST(root.right,val);
		
	}

}

//Definition for a binary tree node.
class TreeNode15 {
    int val;
    TreeNode15 left;
    TreeNode15 right;
    TreeNode15() {}
    TreeNode15(int val) { this.val = val; }
    TreeNode15(int val, TreeNode15 left, TreeNode15 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}