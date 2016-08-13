package linkedLists;

public class LinkedListSolution {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(40);
		list.add(50);
		//list.display();
		list.addToFront(30);
		list.addToFront(100);
		list.addAfterNode(40, 10);
		list.delete(10);
		//list.display();
		list.deleteAt(3);
		list.add(10);
		list.add(20);
//		list.display();
		System.out.println("**************************");
		list.swapNodesWithoutSwappingData(100, 40);
		list.display();
		list.reverseLinkedList();
		System.out.println("Reversed Linked list:");
		
		list.add(10);
		list.display();
//		list.removeDuplicates();
		list.removeDuplicatesWithoutBuffer();
		System.out.println("Duplicates: ");
		list.display();
		System.out.println("K Last element");
		list.findKToLastNode(3);
		System.out.println("Partion and merge");
		list.partitionLinkedListAroundGivenValue(35);
		list.display();
		
		Node a = new Node(1);
		Node b = new Node(2);
		a.setNext(b);
		
		Node c = new Node(3);
		b.setNext(c);
		Node d = new Node(4);
		c.setNext(d);
		Node e = new Node(5);
		d.setNext(e);
		Node f = new Node(6);
		e.setNext(f);
		Node g = new Node(7);
		f.setNext(g);
		Node h = new Node(8);
		g.setNext(h);
		Node i = new Node(9);
		h.setNext(i);
		Node j = new Node(10);
		i.setNext(j);
		Node k = new Node(1);
		j.setNext(k);
		
//		k.setNext(d);
		
		LinkedList add2 = new LinkedList();
		add2.add(2);
		add2.add(9);
		add2.add(5);
		
//		add1.addTwoLinkedLists(add2);
		
		Node start = findStartOfLoop(a);
		if (start == null) {
			System.out.println("Node doesnt exist");
		} else {
			System.out.println("Data equal to " + start.getData());
		}
		
	}

	private static Node findStartOfLoop(Node a) {
		Node slow = a;
		Node fast = a;
		Node head = a;
		
		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (slow == fast) {
				break;
			}
		}
		
		if (fast != null || fast.getNext() != null) {
			return null;
		}
		
		slow = head;
		while (slow != fast) {
			slow = slow.getNext();
			fast = fast.getNext();
		}
		
		return fast; 
	}

}
