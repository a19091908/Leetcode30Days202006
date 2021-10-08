package leetCodeJun2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ReconstructItinerary28 {

	public static void main(String[] args) {
		String[][] strMatrix = 
			{{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
		List<List<String>> tickets = new ArrayList<>();
		for (String[] strArr : strMatrix) {
			ArrayList<String> tempList= new ArrayList<String>();
			for (String str : strArr) {
				tempList.add(str);
			}
			tickets.add(tempList);
		}
		
		List<String> list = new ReconstructItinerary28().findItinerary(tickets);
		
		int size = list.size();
		System.out.print("Start");
		for (int i = 0; i<size; i++) {
			System.out.print(" -> " + list.get(i));
		}
		
	}

	private List<String> findItinerary(List<List<String>> tickets) {
		HashMap<String,PriorityQueue<String>> map = new HashMap<>();
		
		int ticketSize = tickets.size();
		for (int i = 0; i < ticketSize; i++) {
			List<String> listStr = tickets.get(i);
			if (map.containsKey(listStr.get(0))) {
				map.get(listStr.get(0)).add(listStr.get(1));
			}else {
				PriorityQueue<String> pq = new PriorityQueue<String>();
				pq.add(listStr.get(1));
				map.put(listStr.get(0), pq);
			}
		}
		
		LinkedList<String> linkedList = new LinkedList<String>();
		getRoad("JFK", map, linkedList);
		
		return linkedList;
	}

	private void getRoad(String fromStr, HashMap<String, PriorityQueue<String>> map, LinkedList<String> arrayList) {
		
		PriorityQueue<String> pq = map.get(fromStr);
		
		while (pq != null && pq.peek() != null) {
			getRoad(pq.poll(), map, arrayList);
		}

		arrayList.add(0,fromStr);
	}

}
