import java.util.*;

/*
 *  This code tests the relative efficiency of recursive versus
 *  iterative computation of Fibonacci numbers. It defines two methods
 *  rFibonacci and iFibonacci for recursive and iterative computation,
 *  respectively.
 */

public class FibonacciComparison {

    // compute the n-th Fibonacci number using recursion
    private static int rFibonacci (int n) {
	if (n == 0 || n == 1) {
	    return 1;
	}

	return rFibonacci(n - 1) + rFibonacci(n - 2);
    }

    // compute teh n-th Fibonacci number iteratively
    private static int iFibonacci (int n) {
	if (n == 0 || n == 1) {
	    return 1;
	}

	int prev = 1;
	int cur = 1;
	int next;

	for (int i = 2; i <= n; i++) {
	    next = prev + cur;
	    prev = cur;
	    cur = next;
	}

	return cur;
    }

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	int fib;
	
	long startTime;
	long endTime;


	System.out.println("The Great Fibonacci Computing Program!\n\n");
	System.out.println("Recursive computation and runtimes:\n\n");

	for(int i = 0; i < 46; i++) {
	    startTime = System.nanoTime();
	    fib = rFibonacci(i);
	    endTime = System.nanoTime();
	    
	    System.out.println("f(" + i + ") = " + fib + ". That took " + (endTime - startTime) / 1_000_000 + "ms to complete." );
	}

	System.out.println("\n\nIterative computation and runtimes:\n\n");

	for(int i = 0; i < 46; i++) {
	    startTime = System.nanoTime();
	    fib = iFibonacci(i);
	    endTime = System.nanoTime();
	    
	    System.out.println("f(" + i + ") = " + fib + ". That took " + (endTime - startTime) / 1_000_000 + "ms to complete." );
	}

	
    }
}
