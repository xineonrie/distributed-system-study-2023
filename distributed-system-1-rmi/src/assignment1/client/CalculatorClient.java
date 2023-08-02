package assignment1.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main() {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9000, null);

            Calculator obj1 = (Calculator) registry.lookup("Cal1");
            obj1.pushValue(12);
            obj1.pushValue(34);
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Client error: " + e);
        }
    }
}