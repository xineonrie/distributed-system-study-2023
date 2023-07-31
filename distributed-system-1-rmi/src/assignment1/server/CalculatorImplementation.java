package assignment1.server;

import java.rmi.RemoteException;

import java.util.Arrays;
import java.util.Stack;


public class CalculatorImplementation implements Calculator {
    public Stack<Integer> centralStack = new Stack<Integer>();

    @Override
    public void pushValue(int val) throws RemoteException {
        this.centralStack.push(val);
    }

    @Override
    public void pushOperation(String operator) throws RemoteException {
        // pop all the elements to stackArr.
        Integer[] stackArr = new Integer[this.centralStack.size()];
        for(int i = 0; i < this.centralStack.size(); i++) {
            stackArr[i] = this.centralStack.peek();
            this.centralStack.pop();
        }
        Arrays.sort(stackArr);
        if(operator == "min") {
            // for min - push the min value of all the popped values;
            this.centralStack.push(stackArr[0]);
        } else if(operator == "max") {
            // for max - push the max value of all the popped values
            this.centralStack.push(stackArr[this.centralStack.size()-1]);
        } else if(operator == "lcm") {
            // for lcm - push the least common multiple of all the popped values;
            int min, max, temp, res = 0;
           
            for(int i = 0; i<stackArr.length; i++) {
               for(int j = i+1; j<stackArr.length-1; j++) {
                  if(stackArr[i] > stackArr[j]) {
                     min = stackArr[j];
                     max = stackArr[i];
                  } else {
                     min = stackArr[i];
                     max = stackArr[j];
                  }
                  for(int k =0; k<stackArr.length; k++) {
                     temp = k * max;
                     if(temp % min == 0) {
                        res = temp ;
                     }
                  }
               }
            }

            this.centralStack.push(res);

        } else if(operator == "gcd") {
            // for gcd - push the greatest common divisor of all the popped values.
            int gcdRes = gcd(stackArr[0], stackArr[this.centralStack.size()-1]);
            this.centralStack.push(gcdRes);

        } else {
            throw new UnsupportedOperationException("Server error: Invalid operator for pushOperation");
        }

        return;
    }

    private int gcd(int x, int y) {
        if(y==0){
            return x;
        }
        return gcd(y,x%y);
    }

    @Override
    public int pop() throws RemoteException {
        int res = this.centralStack.peek();
        this.centralStack.pop();

        return res;
    }

    @Override
    public boolean isEmpty() throws RemoteException {
        return this.centralStack.empty();
    }

    @Override
    public int delayPop(int millis) throws RemoteException {
        int res = this.centralStack.peek();
        Thread.currentThread();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        this.centralStack.pop();

        return res;
    }

}

