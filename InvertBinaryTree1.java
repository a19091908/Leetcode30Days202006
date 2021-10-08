package leetCodeJun2020;

public class InvertBinaryTree1 {

	public static void main(String[] args) {
		TreeNode1 root = new TreeNode1(4, new TreeNode1(2), new TreeNode1(7));
		root.left.left = new TreeNode1(1);
		root.left.right = new TreeNode1(3);
		root.right.left = new TreeNode1(6);
		root.right.right = new TreeNode1(9);
		
		TreeNode1 ansRoot = invertTree(root);
		
		System.out.println(ansRoot.val);
		
		System.out.print(ansRoot.left.val);
		System.out.print(" ");
		System.out.println(ansRoot.right.val);
		
		System.out.print(ansRoot.left.left.val);
		System.out.print(" ");
		System.out.print(ansRoot.left.right.val);
		System.out.print(" ");
		System.out.print(ansRoot.right.left.val);
		System.out.print(" ");
		System.out.print(ansRoot.right.right.val);
	}

	private static TreeNode1 invertTree(TreeNode1 parentNode) {
		
		if (parentNode.left != null || parentNode.right != null) {
			
			swapChildren(parentNode);
			
			if(parentNode.right != null) invertTree(parentNode.right);
			if(parentNode.left != null) invertTree(parentNode.left);
			
		}

		return parentNode;
	}

	private static void swapChildren(TreeNode1 node) {
		TreeNode1 temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

}

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1() {}
    TreeNode1(int val) { this.val = val; }
    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}