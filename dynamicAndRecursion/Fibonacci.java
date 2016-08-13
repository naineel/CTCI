package dynamicAndRecursion;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacciRecursive(10));
		System.out.println(fibonacciDP(10, new int[100]));
	}
	
	public static int fibonacciRecursive(int num) {
		if (num <= 1) {
			return num; 
		}
		return fibonacciRecursive(num-1) + fibonacciRecursive(num-2);
	}
	
	public static int fibonacciDP(int num, int[] fib) {
		if (num == 0) {
			return 0;
		} else if (num == 1) {
			return 1;
		} else if (fib[num] > 0) {
			return fib[num];
		} else {
			fib[num] = fibonacciDP(num-1, fib) + fibonacciDP(num-2, fib);
			return fib[num];
		}
	}

}
