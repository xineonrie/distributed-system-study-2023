package assignment1.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    // This method will take val and push it on to the top of the stack.
    public void pushValue(int val) throws RemoteException;
    // This method will use a string to control the calculation.
    public void pushOperation(String operator) throws RemoteException;
    // This method will pop the top of the stack and return it to the client.
    public int pop() throws RemoteException;
    // This method will return true if the stack is empty, false otherwise.
    public boolean isEmpty() throws RemoteException;
    // This method will wait millis milliseconds before carrying out the pop operation as above.
    public int delayPop(int millis) throws RemoteException;
}