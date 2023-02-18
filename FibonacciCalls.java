package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciCalls {
    private int numRecursiveCalls;

    private int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        numRecursiveCalls += 2;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public FibonacciCalls() throws IOException {
        int numCases;
        String line;
        BufferedReader in;

        in = new BufferedReader(new InputStreamReader(System.in));
        line = in.readLine();
        numCases = Integer.parseInt(line);

        for (int i = 0; i < numCases; i++) {
            int num;
            int result;

            numRecursiveCalls = 0;
            line = in.readLine();
            num = Integer.parseInt(line);
            result = fibonacci(num);

            System.out.println("fib(" + num + ") = " + numRecursiveCalls + " calls = " + result);


        }

    }

    public static void main(String[] args) throws IOException {
        new FibonacciCalls();
    }
}
