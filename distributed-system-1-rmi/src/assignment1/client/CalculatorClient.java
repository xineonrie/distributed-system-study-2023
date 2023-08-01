package assignment1.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main() {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9000, null);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}