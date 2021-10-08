package leetCodeJun2020;

public class SortColors11 {

	public static void main(String[] args) {
		
		int[] nums = {2,0,2,1,1,0};
		
		printInt(nums);
		
		sortColors(nums);

		printInt(nums);
	}
	
	private static void sortColors(int[] nums) {
		int left = 0, right = nums.length-1;
		
		for (int i = 0; i < nums.length; i++) {			
			if (nums[i] == 0) 
				left++;
			else if(nums[i] == 2)
				right--;
		}
		
		for (int i = 0; i < left; i++) 
			nums[i] = 0;
		
		for (int i = left; i <= right; i++) 
			nums[i] = 1;

		for (int i = right+1; i < nums.length; i++) 
			nums[i] = 2;
		
	}

	private static void printInt(int[] nums) {
		for (int i = 0; i < nums.length; i++) 
			System.out.print(""+nums[i]+",");
		System.out.println();
	}

	

}
