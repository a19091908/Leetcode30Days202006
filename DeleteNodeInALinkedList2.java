package leetCodeJun2020;

public class DeleteNodeInALinkedList2 {

	public static void main(String[] args) {
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node1 = new ListNode(1);
		ListNode node9 = new ListNode(9);
		
		node4.next = node5;
		node5.next = node1;
		node1.next = node9;
		
		ListNode node = node4;
		
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
		
		System.out.println("---");
		
		deleteNode(node5);
		
		node = node4;
		
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

	private static void deleteNode(ListNode node) {
		node.val = node.next.val;
        node.next = node.next.next;
	}

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}