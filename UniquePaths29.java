package leetCodeJun2020;

public class UniquePaths29 {

	public static void main(String[] args) {
		
		int m = 7; 
		int n = 3;
		int ans = new UniquePaths29().uniquePaths(m,n);
		System.out.println(ans);

	}

	private int uniquePaths(int m, int n) {
		int[] dpArr = new int[n];
		
		for (int i = 0; i < n; i++) 
			dpArr[i] = 1;
		
		for (int j = 1; j < m; j++) {
			for (int i = 1; i < n; i++) {
				dpArr[i] += dpArr[i-1];
			}
		}
		
		return dpArr[n-1];
	}

}
