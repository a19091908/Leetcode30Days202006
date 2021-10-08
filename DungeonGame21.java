package leetCodeJun2020;

import java.util.Stack;

public class DungeonGame21 {
	int[][] dungeon;
	int min;
	
	public static void main(String[] args) {
		int[][] dungeon = {
				{-2,-3,3},
				{-5,-10,1},
				{10,30,-5}
				};
		int ans = new DungeonGame21().calculateMinimumHP(dungeon);

		System.out.println(ans);
	}

	private int calculateMinimumHP(int[][] dungeon) {
		this.dungeon = dungeon;
		min = Integer.MAX_VALUE;
		int nodeMin = 1;
		int nodeSum = 1;
		
		findMinHP(0,0,nodeMin,nodeSum);
		
		return min;
	}

	private void findMinHP(int i, int j, int nodeMin,int nodeSum) {
		if (i >= dungeon.length || j >= dungeon[0].length) 
			return;
		
		nodeSum += -dungeon[i][j];
		nodeMin = Math.max(nodeMin, nodeSum);
		
		if (nodeMin >= min) 
			return;
		
		boolean isIExccedLen = i+1 >= dungeon.length;
		boolean isJExccedLen = j+1 >= dungeon[0].length;
		
		if ( !isIExccedLen && !isJExccedLen) {
			
			if (dungeon[i+1][j] >= dungeon[i][j+1]) {
				
				findMinHP(i+1,j,nodeMin,nodeSum);
				findMinHP(i,j+1,nodeMin,nodeSum);
			}else {
				
				findMinHP(i,j+1,nodeMin,nodeSum);
				findMinHP(i+1,j,nodeMin,nodeSum);
			}
		}else
		if (!isIExccedLen) {
			
			findMinHP(i+1,j,nodeMin,nodeSum);
		}else 
		if (!isJExccedLen){
			
			findMinHP(i,j+1,nodeMin,nodeSum);
		}else {
			min = nodeMin;
		}
		
	}

}
