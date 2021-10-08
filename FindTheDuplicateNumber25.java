package leetCodeJun2020;

public class FindTheDuplicateNumber25 {

	public static void main(String[] args) {
		int[] nums = {3,1,3,4,2};
		int ans = new FindTheDuplicateNumber25().findDuplicate(nums);
		System.out.println(ans);
	}

	private int findDuplicate(int[] nums) {
		
		int cycleJoinPoint = turtleAndRabbitRaceAlgorithm(nums);
		
		return cycleJoinPoint;
	}

	private int turtleAndRabbitRaceAlgorithm(int[] nums) {
		int diffJoinPoint = findDiffSpeedJoinPoint(nums);
		int cycleJoinPoint = findCycleJoinPoint(diffJoinPoint, nums);
		return cycleJoinPoint;
	}

	private int findCycleJoinPoint(int diffJoinPoint, int[] nums) {
		int point = 0;
		
		while (point != diffJoinPoint) {
			point = nums[point];
			diffJoinPoint = nums[diffJoinPoint];
		}
		
		return point;
	}

	private int findDiffSpeedJoinPoint(int[] nums) {
		int slowInd = nums[0];
		int fastInd = nums[nums[0]];
		
		while (slowInd != fastInd) {
			slowInd = nums[slowInd];
			fastInd = nums[nums[fastInd]];
		}
		
		return fastInd;
	}

}
