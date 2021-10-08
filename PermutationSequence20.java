package leetCodeJun2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class PermutationSequence20 {

	public static void main(String[] args) {
		int n = 2;
		int k = 2;
		
		String ansStr = getPermutation(n,k);
		System.out.println(ansStr);

	}

	private static String getPermutation(int n, int k) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		int sum = 1;
		
		for (int i = 1; i <= n; i++) {
			list.add(i);
			sum = sum * i;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = n; i > 0; i--) {
			sum = sum/i;
			
			int position = (k-1)/sum;
			sb.append(list.remove(position));
			
			k = k % sum;
			if (k == 0) {
				k = sum;
			}
		}
		
		return sb.toString();
	}
	

}
