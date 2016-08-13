package stacks;

import java.util.Stack;

public class TowerOfHanoi {
	int index;
	Stack<Integer> stack;
	
	public TowerOfHanoi(int i) {
		index = i;
		stack = new Stack<Integer>();
	}
	
	public int index() {
		return index;
	}
	
	public void add(int disk) {
		try {
			if (!stack.empty() && stack.peek() <= disk) {
				System.out.println("Can't place disk there!");
			} else {
				stack.push(disk);
			}
		} catch (Exception e) {
		}
	}
	
	public void moveOnTop(TowerOfHanoi t) {
		int disk = stack.pop();
		t.add(disk);
		System.out.println("Move disk " + disk + " from " + index() + " to " + t.index());
	}
	
	public void moveDiskTo(int n, TowerOfHanoi destination, TowerOfHanoi buffer) {
		if (n > 0) {
			moveDiskTo(n-1, buffer, destination);
			moveOnTop(destination);
			buffer.moveDiskTo(n-1, destination, this);
		}
		
	}
	
	public static void main(String args[]) {
		System.out.println("hello");
		int n = 1;
		TowerOfHanoi[] tower = new TowerOfHanoi[3];
		for (int i = 0; i < 3; i++) {
			tower[i] = new TowerOfHanoi(i);
		}
		
		// Biggest disk goes most below.
		for (int i = n-1; i >= 0; i--) {
			tower[0].add(i);
		}
		
		tower[0].moveDiskTo(n, tower[2], tower[1]);
		
	}
	
}
