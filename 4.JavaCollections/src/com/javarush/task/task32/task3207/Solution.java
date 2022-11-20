package com.javarush.task.task32.task3207;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
К серверу по RMI
*/

public class Solution {
    public static final String UNIC_BINDING_NAME = "double.string";
    public static Registry registry;

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                DoubleString service = (DoubleString) registry.lookup(UNIC_BINDING_NAME);
                String result = service.doubleString("test string");
                System.out.println(result);
            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    public static void main(String[] args) {
        // Pretend we're starting an RMI server as the main thread
        Remote stub = null;
        try {
            registry = LocateRegistry.createRegistry(2099); //создаем специальный объект – реестр.
            // В нем надо регистрировать объекты, которые мы шарим. Дальше ими занимается Java-машина.
            // 2099 – это порт (уникальный номер, по которому другая программа может обратиться к нашему реестру объектов).
            final DoubleStringImpl service = new DoubleStringImpl(); // создаем объект DoubleStringImpl, который будет доступен удаленно,
            // и чьи методы будут вызваться

            stub = UnicastRemoteObject.exportObject(service, 0); //создание «заглушки»
            registry.bind(UNIC_BINDING_NAME, stub); //регистрируем в реестре заглушку нашего объекта под уникальным именем.
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

        // Start the client
        CLIENT_THREAD.start();
    }
}
