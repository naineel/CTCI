package linkedLists;

import java.util.HashSet;

public class LinkedList {
	Node first;

	public void add(int i) {
		Node n = new Node(i);
		if (first == null) {
			first = n;
		} else {
			Node p = first;
			while (p.getNext() != null) {
				p = p.getNext();
			}
			p.setNext(n);
		} 
	}
	
	public void display() {
		Node p = first;
		while (p != null) {
			System.out.println(p.getData());
			p = p.getNext();
		}
	}

	public void addToFront(int i) {
		Node n = new Node(i);
		Node p = first;
		if (p == null) {
			first = n;
		} else {
			first = n;
			n.setNext(p);
		}
		
	}

	public void addAfterNode(int prev, int i) {
		Node p = first;
		while (p.getData() != prev) {
			p = p.getNext();
		}
		Node next = p.getNext();
		Node x = new Node(i);
		p.setNext(x);
		x.setNext(next);
	}

	public void delete(int i) {
		Node p = first;
		while (p.getNext().getData() != i) {
			p = p.getNext();
		}
		p.setNext(p.getNext().getNext());
	}

	public void deleteAt(int pos) {
		Node p = first;
		if (pos == 0) {
			first = p.getNext();
			return;
		} else {
			for (int i=0; i < pos-1 ; i++) {
				p = p.getNext();
			}
			p.setNext(p.getNext().getNext());
		}
		
	}
	
	public void swapNodesWithoutSwappingData(int data1, int data2) {
		
		//case 1
		if (data1 == data2) {
			System.out.println("The nodes are the same");
			return;
		}
		
		//Keep track of prev and Curr

		Node prevX = null;
		Node currentX = first;
		while (currentX != null && currentX.getData() != data1) {
			prevX = currentX;
			currentX = currentX.getNext();
		}
		
		Node prevY = null;
		Node currentY = first;
		while (currentY != null && currentY.getData() != data2) {
			prevY = currentY;
			currentY = currentY.getNext();
		}
		
		// Case 2: Elements are not present, nothing to do
		if (currentX == null || currentY == null) {
			System.out.println("Either of the two data points do not exist;");
			return;
		}
		
		if (prevX == null) {
			System.out.println(data1 + ": is the head");
			first = currentY;
		} else {
			prevX.setNext(currentY);
		}
		
		if (prevY == null) {
			System.out.println(data2 + ": is the head");
			first = currentX;
		} else {
			prevY.setNext(currentX);
		}
		
		Node temp = currentX.getNext();
		currentX.setNext(currentY.getNext());
		currentY.setNext(temp);
	}

	public void reverseLinkedList() {
		//Case: Nothing to swap as only one element.
		if (first.getNext() == null) {
			return;
		}
		
		Node prev = null;
		Node current = first;
		Node nextNode = null;
		
		while (current != null) {
			nextNode = current.getNext();
			current.setNext(prev);
			prev = current;
			current = nextNode;
		}
		
		first = prev;
	}

	public void removeDuplicates() {
		HashSet<Integer> table = new HashSet<Integer>();
		Node p = first;
		Node linkedListNode= null;
		while (p != null) {
			if (table.contains(p.getData())) {
				linkedListNode.setNext(p.getNext());
			} else {
				table.add(p.getData());
				linkedListNode = p;
			}
			p = p.getNext();
		}
		
	}
	
	public void removeDuplicatesWithoutBuffer() {
		Node current = first;
		
		if (first == null) return;
		
		while (current != null) {
			Node runner = current;
			
			while (runner.getNext() != null) {
				if (runner.getNext().getData() == current.getData()) {
					runner.setNext(runner.getNext().getNext());
				} else {
					runner = runner.getNext();
				}
			}
			current = current.getNext();
		}
		
	}
	
	public void findKToLastNode(int K) {
		Node head = first;
		Node runner = first;
		
		if (head == null) return;
		
		for (int i=0 ; i < K-1; i++) {
			if (runner == null) return;
			runner = runner.getNext();
		}
		
		//check again
		
		if (runner == null) return;
		
		while (runner.getNext() != null) {
			runner = runner.getNext();
			head = head.getNext();
		}
		
		System.out.println(K + " to last element is " + head.getData());
		
	} 
	
	public void partitionLinkedListAroundGivenValue(int value) {
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;
		
		Node node = first;
		while (node != null) {
			Node next = node.getNext();
			node.setNext(null);
			if (node.getData() < value) {
				if (beforeStart == null){
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.setNext(node);
					beforeEnd = node;
				}
			} else {
				if (afterStart == null){
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.setNext(node);
					afterEnd = node;
				}
			}
			
			node = next;
		}
		if (beforeStart == null) return;
	 	
		beforeEnd.setNext(afterStart);
		
	}

	public void addTwoLinkedLists(LinkedList add2) {
		Node firstStart = this.first;
		Node twoStart = add2.first;
		
		
		
	}
	
	
	
}
