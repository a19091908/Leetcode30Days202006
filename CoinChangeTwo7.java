package leetCodeJun2020;

public class CoinChangeTwo7 {

	public static void main(String[] args) {
		int amount = 5; 
		int[] coins = {1, 2, 5};
		
		int ans = change(amount,coins);
		System.out.println(ans);

	}

	private static int change(int amount, int[] coins) {
		int[] dp = new int[amount+1];
		dp[0] = 1;
		
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j < dp.length; j++) {
				dp[j] = dp[j] + dp[j-coins[i]];
			}
		}

		return dp[amount];
	}

}
