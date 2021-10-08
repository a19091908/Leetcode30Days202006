package leetCodeJun2020;


import java.util.LinkedList;
import java.util.Queue;


public class CheapestFlightsWithinKStops14 {

	public static void main(String[] args) {
		int n = 3, src = 0, dst = 2, K = 1;
		int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
		
		int ans =  findCheapestPrice(n,flights,src,dst,K);
		
		System.out.println(ans);

	}

	private static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		boolean hasAns = false;
		int min = Integer.MAX_VALUE;
		
		// create distArr
		int[][] distArr = new int[n][n];
		for (int[] flight : flights) 
			distArr[flight[0]][flight[1]] = flight[2];
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[]{src,0});
		
		int stopCities = -1;
		
		while (! queue.isEmpty()) {
			
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				
				// tempArr[0]: i ; tempArr[1]: dist
				int[] tempArr = queue.poll();
				
				if (tempArr[1] >= min) continue;
				
				for (int j = 0; j < n; j++) {
					if (distArr[tempArr[0]][j] != 0) {
						if (j == dst) {
							min = Math.min(min, tempArr[1]+distArr[tempArr[0]][j]);
							hasAns = true;
							continue;
						}
						else {
							queue.add(new int[] {j,tempArr[1]+distArr[tempArr[0]][j]});
						}
					}
				}
			}
			stopCities++;
			
			if (stopCities == K) 
				break;
			
		}
		
		return (hasAns)?min:-1;

	}


}
