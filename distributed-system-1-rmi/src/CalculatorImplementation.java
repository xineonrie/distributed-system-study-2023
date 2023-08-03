

import java.rmi.RemoteException;

import java.util.Arrays;
import java.util.Stack;

public class CalculatorImplementation implements Calculator {
    public Stack<Integer> centralStack = new Stack<Integer>();
    public void Calculator() {
        
    }

    public void pushValue(int val) throws RemoteException {
         System.out.println("Pushvalue Success! now the top is : "+ val);
        this.centralStack.push(val);
        return;
    }

    public void pushOperation(String operator) throws RemoteException {
        // pop all the elements to stackArr.
        int length = this.centralStack.size();
        int[] stackArr = new int[length];
        System.out.println("length of the stack: " + this.centralStack.size());
        for(int i = 0; i < length; i++) {
            stackArr[i] = this.centralStack.peek();
            System.out.println(stackArr[i]);

            this.centralStack.pop();
        }

        Arrays.sort(stackArr);
        if(operator.equals("min")) {
            // for min - push the min value of all the popped values;
            this.centralStack.push(stackArr[0]);
            System.out.println("min val: " + this.centralStack.peek());

        } else if(operator.equals("max")) {
            // for max - push the max value of all the popped values
            this.centralStack.push(stackArr[length-1]);
        } else if(operator.equals("lcm")) {
            // for lcm - push the least common multiple of all the popped values;
            int res = stackArr[0];
            for (int i = 1; i < length; i++)
                res = lcm(res, stackArr[i]);
            
            this.centralStack.push(res);

        } else if(operator.equals("gcd")) {
            // for gcd - push the greatest common divisor of all the popped values.
            int gcdRes = gcd(stackArr[0], stackArr[length-1]);
            this.centralStack.push(gcdRes);

        } else {
            throw new UnsupportedOperationException("Invalid operator for method pushOperation: " + operator);
        }

        return;
    }

    private int gcd(int x, int y) {
        if(y == 0){
            return x;
        }
        return gcd(y,x%y);
    }
    
    private int lcm(int x, int y) {
        if(x == 0) {
            return 0;
        }
        return (x / gcd(x, y)) * y;
    }

    public int pop() throws RemoteException {
        if(!this.centralStack.empty()) {
            int res = this.centralStack.peek();
            this.centralStack.pop();

            return res;
        } else {
            throw new UnsupportedOperationException("The current stack is empty, it's not possible to pop any elements.");

        }
        
    }

    public boolean isEmpty() throws RemoteException {
        return this.centralStack.empty();
    }

    public int delayPop(int millis) throws RemoteException {
        int res = this.centralStack.peek();
        Thread.currentThread();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("Client error: " + e);
        } 
        if(!this.centralStack.empty()) {
            this.centralStack.pop();
        } else {
            throw new UnsupportedOperationException("The current stack is empty, it's not possible to pop any elements.");

        }

        return res;
    }

}

