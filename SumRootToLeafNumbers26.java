package leetCodeJun2020;

public class SumRootToLeafNumbers26 {
	public static void main(String[] args) {
		// 4,9,0,5,1
		TreeNode1 root = new TreeNode1(4, new TreeNode1(9), new TreeNode1(0));
		root.left.left = new TreeNode1(5);
		root.left.right = new TreeNode1(1);
		
		int ans = new SumRootToLeafNumbers26().sumNumbers(root);
		System.out.println(ans);
	}

	private int sumNumbers(TreeNode1 root) {
		return sumLeft(root,0);
	}

	private int sumLeft(TreeNode1 root, int tempSum) {
		if (root == null)
			return 0;
		
		int temp = 10*tempSum + root.val;
		
		if (root.left == null && root.right == null) 
			return temp;
		
		
		tempSum = sumLeft(root.left, temp) + sumLeft(root.right, temp);
		
		return tempSum;
	}

}
