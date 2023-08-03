

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9001, null);

            Calculator obj1 = (Calculator) registry.lookup("Cal1");
            obj1.pushValue(2);
            obj1.pushValue(34);
            System.out.println("Now Time" + System.currentTimeMillis());
            int val = obj1.delayPop(3000);
            System.out.println("Pop Time: " + System.currentTimeMillis() + "\n Pop Val: " + val);
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Client error: " + e);
        }
    }
}