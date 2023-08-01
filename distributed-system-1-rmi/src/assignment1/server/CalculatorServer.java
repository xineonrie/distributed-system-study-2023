package assignment1.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer {
    public static void main(String[] args) throws RemoteException {
        try {
            CalculatorImplementation p1 = new CalculatorImplementation();
            Calculator Obj1 = (Calculator) UnicastRemoteObject.exportObject(p1, 0);

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9000, null);

            registry.bind("Cal1", Obj1);
        } catch(Exception e) {
            System.out.println("Server error: " + e);
        }
    }
}