package leetCodeJun2020;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueReconstructionByHeight6 {

	public static void main(String[] args) {
		int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		people = reconstructQueue(people);
		
		print2DArr(people);
		
	}

	private static void print2DArr(int[][] people) {
		for (int[] person : people) 
			System.out.println(String.format("{%s,%s}", person[0],person[1]));
	}

	private static int[][] reconstructQueue(int[][] people) {
		
		Queue<Person> queue = new PriorityQueue<Person>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				int c1 = o2.height - o1.height;
				if (c1 != 0) return c1;
				return o1.frontPerson - o2.frontPerson;
			}
		});
		
		for (int i = 0; i < people.length; i++) 
			queue.offer(new Person(people[i][0],people[i][1]));
		
		List<int[]> list = new LinkedList<int[]>();
		
		for (int i = 0; i < people.length; i++) {
			Person person = queue.poll();
			list.add(person.frontPerson, new int[]{person.height, person.frontPerson});
		}
		
		
		return list.toArray(new int[people.length][2]);
	}

}
class Person{
	int height;
	int frontPerson;
	public Person(int height, int frontPerson) {
		super();
		this.height = height;
		this.frontPerson = frontPerson;
	}
}
