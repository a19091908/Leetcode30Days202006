package leetCodeJun2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Map;

public class RandomizedSet12 {
	Map<Integer,Integer> map;
	List<Integer> list;
	int n;
	Random random;
	

	/**
	 * Your RandomizedSet object will be instantiated and called as such:
	 * RandomizedSet obj = new RandomizedSet();
	 * boolean param_1 = obj.insert(val);
	 * boolean param_2 = obj.remove(val);
	 * int param_3 = obj.getRandom();
	 */
	public static void main(String[] args) {
		RandomizedSet12 obj = new RandomizedSet12();
		boolean param_1 = obj.insert(2);
		obj.insert(3);
		obj.insert(4);
		obj.insert(5);
		System.out.println(param_1);
		
		boolean param_2 = obj.remove(3);
		System.out.println(param_2);
		
		int param_3 = obj.getRandom();
		System.out.println(param_3);
	}
	
    /** Initialize your data structure here. */
    public RandomizedSet12() {
        map = new HashMap<Integer,Integer>();
        list = new ArrayList<Integer>();
        n = 0;
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	if (map.containsKey((Integer)val)) 
			return false;
		else {
			map.put(val,n);
			list.add(n,val);
			n++;
			return true;
		}
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	Integer temp = map.get(val);
    	if (temp == null) 
			return false;
    	else {
    		n--;
    		
    		map.remove((Integer)val);

    		Integer lastElement = list.remove(n);
    		
    		if (val != lastElement.intValue()) {
    			map.put(lastElement, temp);
    			list.set((int)temp, lastElement);
			}
    		
    		return true;
    	}

    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(n));
    }

}
