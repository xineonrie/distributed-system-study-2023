

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class CalculatorServer {
    public static void main(String[] args) throws RemoteException {
        try {
            CalculatorImplementation p1 = new CalculatorImplementation();
            Calculator Obj1 = (Calculator) UnicastRemoteObject.exportObject(p1, 0);

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9001, null);
            System.out.println("Server is ready!");
            registry.rebind("Cal1", Obj1);
            System.out.println("Bind is ready!");
        } catch(Exception e) {
            System.out.println("Server error: " + e);
        }
    }
}