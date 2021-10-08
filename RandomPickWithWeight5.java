package leetCodeJun2020;

import java.util.Random;

public class RandomPickWithWeight5 {
	int[] interval;
	Random r;

	public static void main(String[] args) {
		int n = 4000;
		
		int[] w = {2,1,4,2,1};
		RandomPickWithWeight5 rpw5 = new RandomPickWithWeight5(w);
		
		int[] calArr = new int[w.length];
		for (int i = 0; i < n; i++) {
			calArr[rpw5.pickIndex()]++;
		}
		
		for (int i = 0; i < calArr.length; i++) 
			System.out.println(String.format("%s: %s", i, calArr[i]));
		
		
	}

	RandomPickWithWeight5(int[] w){
		interval = new int[w.length];
		int sum = 0;
		
		for (int i = 0; i < w.length; i++) {
			sum += w[i];
			interval[i] = sum;
		}

	}
	
	private int pickIndex() {
		double random = Math.random()*interval[interval.length-1];
		
		for (int i = 0; i < interval.length; i++) {
			if(random < interval[i])
				return i;
		}
		return 0;
	}
}
