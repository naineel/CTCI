package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianValueUsingHeap_9 {

	private PriorityQueue<Integer> minHeap, maxHeap;
	public int numOfElements;
	
	public MedianValueUsingHeap_9() {
		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>(10, new MaxHeapComparator());
		numOfElements = 0;
	}
	
	public static void main(String[] args) {
		MedianValueUsingHeap_9 mv = new MedianValueUsingHeap_9();
		mv.addNewNumber(1);
		mv.addNewNumber(2);
		mv.addNewNumber(3);
		mv.addNewNumber(4);
		mv.addNewNumber(5);
		mv.addNewNumber(6);
		mv.addNewNumber(7);
		mv.addNewNumber(8);
		mv.addNewNumber(9);
		System.out.println(mv.getMedian());
	}

	private void addNewNumber(int randomNumber) {
		maxHeap.add(randomNumber);
		if (numOfElements % 2 == 0) {
			if (minHeap.isEmpty()) {
				numOfElements++;
				return;
			} else if (maxHeap.peek() > minHeap.peek()) {
				Integer maxHeapRoot = maxHeap.poll();
				Integer minHeapRoot = minHeap.poll();
				maxHeap.add(minHeapRoot);
				minHeap.add(maxHeapRoot);
			}
		} else {
			minHeap.add(maxHeap.poll());
		}
		numOfElements++;
	}
	
	public double getMedian() {
		if (numOfElements % 2 != 0) {
			return new Double(maxHeap.peek());
		} else {
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		}
	}
	
	private class MaxHeapComparator implements Comparator<Integer> {
		
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	}

}
