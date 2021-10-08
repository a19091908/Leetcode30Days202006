package leetCodeJun2020;

public class PerfectSquares27 {

	public static void main(String[] args) {
		int n = 13;
		int ans = new PerfectSquares27().numSquares(n);
		System.out.println(ans);
	}

	private int numSquares(int n) {
		int[] dp = new int[n+1];
		dp[0] = 0;
		
		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 1; j*j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
			}
		}

		return dp[n];
	}

}
