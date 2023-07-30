package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

// 客户端方法
public class IRemoteObj extends Remote {
    // 客户端接口
    public String sayHelloWorld(string keywords) throws RemoteException;
}
