package stacks;

import java.util.ArrayList;

public class SetOfStacks {
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	
	public void push(int v) {
		Stack last = getLastStack();
		
		if (last == null || last.isFull()){
			Stack newStack = new Stack();
			newStack.push(v);
			stacks.add(newStack);
		} else {
			last.push(v);
		}
		
	}

	private Stack getLastStack() {
		if (stacks.size() == 0) {
			return null;
		} else {
			return stacks.get(stacks.size() - 1);
		}
	}

	public int pop() {
		Stack last = getLastStack();
		int num = last.pop();
		if (last.empty()) {
			stacks.remove(stacks.size()-1);
		}
		return num;
	}
}

