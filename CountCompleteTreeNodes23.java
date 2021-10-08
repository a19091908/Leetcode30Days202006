package leetCodeJun2020;

public class CountCompleteTreeNodes23 {

	public static void main(String[] args) {
		TreeNode1 root = new TreeNode1(1, new TreeNode1(2), new TreeNode1(3));
		root.left.left = new TreeNode1(4);
		root.left.right = new TreeNode1(5);
		root.right.left = new TreeNode1(6);
		
		int ans = countNodes(root);
		System.out.println(ans);

	}

	private static int countNodes(TreeNode1 root) {
		int leftH = getLeftHeight(root);
		int rightH = getRightHeight(root);
		
		if (leftH != rightH) {
			return countLeftTree(root.left,leftH-1) + 1 + countRightTree(root.right,rightH-1);
		}else {
			return (int) Math.pow(2, leftH)-1;
		}

	}

	private static int countRightTree(TreeNode1 root, int rightHeight) {
		if (rightHeight == 1) {
			if (root.left != null) {
				return 2;
			}else {
				return 1;
			}
		}
		int leftHeight = getLeftHeight(root);
		if (leftHeight != rightHeight) {
			return countLeftTree(root.left, leftHeight-1) + 1 + countRightTree(root.right, rightHeight-1);
		}else {
			return (int) Math.pow(2, leftHeight)-1;
		}
	}

	private static int countLeftTree(TreeNode1 root, int leftHeight) {
		if (leftHeight == 1) 
			return 1;
		int rightHeight = getRightHeight(root);
		if (leftHeight != rightHeight) {
			return countLeftTree(root.left, leftHeight - 1) + 1 + countRightTree(root.right, rightHeight - 1);
		}else {
			return (int) Math.pow(2, leftHeight)-1;
		}
	}

	private static int getRightHeight(TreeNode1 root) {
		return root == null ? 0 : 1 + getRightHeight(root.right);
	}

	private static int getLeftHeight(TreeNode1 root) {
		return root == null ? 0 : 1 + getLeftHeight(root.left);
	}

}
