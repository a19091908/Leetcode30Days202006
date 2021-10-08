package leetCodeJun2020;

public class SearchInsertPosition10 {

	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int target = 7;
		int ans = searchInsert(nums,target);
		System.out.println(ans);
	}

	private static int searchInsert(int[]  nums, int target) {
		int left = 0, right = nums.length-1;
		
		while (left < right) {
			int midIndex = (left+right)/2;
			int mid = nums[midIndex];
			
			if (mid > target) {
				right = midIndex;
			}else 
			if (mid < target) {
				left = midIndex + 1;
			}else {
				return midIndex;
			}
		}
		
		if (nums[left] > target) {
			return left;
		}else
		if (nums[left] < target) {
			return left+1;
		}else
			return left;
	}

}
