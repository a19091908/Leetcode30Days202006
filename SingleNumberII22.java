package leetCodeJun2020;

public class SingleNumberII22 {

	public static void main(String[] args) {
		int[] nums = {2,1,2,1,2,1,99};
		int ans = singleNumber(nums);
		System.out.println(ans);
	}

	private static int singleNumber(int[] nums) {
		int ones = 0, twos = 0;
		
		for (int num : nums) {
			ones = (num ^ ones) & ~twos;
			twos = (num ^ twos) & ~ones;
		}

		return ones;
	}

}
