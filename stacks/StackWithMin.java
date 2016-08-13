package stacks;


public class StackWithMin extends Stack {
	Stack s2;
	
	public StackWithMin() {
		s2 = new Stack();
	}
	
	public void push(int v) {
		try {
			
			if (s2.peek() > v) {
				s2.push(v);
			} 
			
			super.push(v);
		
		} catch (Exception e) {
		}
	}
	
	public int pop() {
		int value = super.pop();
		try {
			if (value == min()) {
				return s2.pop();
			}
		} catch (Exception e) {
		}
		return value;
	}
	
	public int min() throws Exception {
		if (s2.empty()) {
			throw new Exception("Stack is empty");
		} else {
			return s2.peek();
		}
	}
	
}
