package leetCodeJun2020;

import java.util.PriorityQueue;
import java.util.Queue;

public class TwoCityScheduling3 {

	public static void main(String[] args) {
		int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
		int minCost = twoCitySchedCost(costs);
		System.out.println(minCost);
	}

	private static int twoCitySchedCost(int[][] costs) {
		int sum = 0;
		Queue<Integer> queue = new PriorityQueue<Integer>();
		
		// first compute the sum of the cost all people spent to go to A place
		// second compute the difference between the cost to go to A and B
		for (int[] personCost : costs) {
			sum += personCost[0];
			queue.offer(personCost[1]-personCost[0]);
		}
		
		int theNoPeopleEachPlace = costs.length/2;
		
		for (int i = 0; i < theNoPeopleEachPlace; i++) 
			sum += queue.poll();
		
		return sum;
	}

}
