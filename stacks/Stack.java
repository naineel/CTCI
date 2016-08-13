package stacks;

public class Stack {
	private int a[];
	private int top = -1;
	
	public Stack() {
		a = new int[5];
	}
			
	public Stack(int n) {
		a = new int[n];
	}
	
	public void push(int num) {
		if (top == a.length - 1) {
			System.out.println("Stack is full");
		} else {
			a[++top] = num;
		} 
	}
	
	public int pop() {
		if (top == -1) {
			System.out.println("stack is empty");
			return 0;
		} else {
			return a[top--];
		}
		
	}
	
	public boolean empty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}
	
	public int peek() throws Exception {
		if (top == -1) {
			throw new Exception("Stack is empty");
		} else {
			return a[top];
		}
	}

	public boolean isFull() {
		return (top == a.length -1);
	}
	
}
