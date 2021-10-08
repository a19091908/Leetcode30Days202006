package leetCodeJun2020;

import java.util.ArrayList;

public class UniqueBinarySearchTrees24 {
	ArrayList<Integer> arrList;
	
	public static void main(String[] args) {
		UniqueBinarySearchTrees24 ubst = new UniqueBinarySearchTrees24();
		int n = 4;
		int ans = ubst.numTrees(n);
		System.out.println(ans);
		ans = ubst.numTrees(10);
		System.out.println(ans);
	}
	
	public UniqueBinarySearchTrees24(){
		arrList = new ArrayList<Integer>();
		arrList.add(0, 1);
		arrList.add(1, 1);
	}

	private int numTrees(int n) {
		
		if (n < arrList.size()) {
			return arrList.get(n);
		}else {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += numTrees(i) * numTrees(n-i-1);
			}
			arrList.add(n,sum);
			return sum;
		}
	}


}
