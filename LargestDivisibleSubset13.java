package leetCodeJun2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset13 {

	public static void main(String[] args) {
		
		int[] nums = {1, 16, 7, 8, 4};
		List<Integer> ansList = largestDivisibleSubset(nums);
		
		ansList.forEach(x->System.out.print(x + ", "));
	}

	private static List<Integer> largestDivisibleSubset(int[] nums) {
		if (nums.length == 0) return new ArrayList();
		
		int[] lengthArr = new int[nums.length];
		int[] prevArr = new int[nums.length];
		
		int maxIndex = 0, max = 0;
		
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length; i++) {
			lengthArr[i] = 1;
			prevArr[i] = -1;
			
			for (int j = i-1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0 && lengthArr[j] + 1 > lengthArr[i]) {
					lengthArr[i] = lengthArr[j] + 1;
					prevArr[i] = j;
				}	
			}
			
			if ( max < lengthArr[i]) {
				max = lengthArr[i];
				maxIndex = i;
			}
			
		}
		
		// get List
		List<Integer> listArr = new ArrayList<Integer>(); 
		int tempIndex = maxIndex;
		while (tempIndex != -1) {
			listArr.add(nums[tempIndex]);
			tempIndex = prevArr[tempIndex];
		}
		
		Collections.reverse(listArr);
		
		return listArr;
	}

}
