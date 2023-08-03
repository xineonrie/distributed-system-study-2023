

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9001, null);

            Calculator obj1 = (Calculator) registry.lookup("Cal1");
            obj1.pushValue(2);
            obj1.pushValue(6);
            obj1.pushValue(18);
            obj1.pushOperation("lcm");
            int minVal = obj1.pop();
            System.out.println("test lcm: " + minVal);
            
        } catch (Exception e) {
            System.out.println("Client error: " + e);
        }
    }
}