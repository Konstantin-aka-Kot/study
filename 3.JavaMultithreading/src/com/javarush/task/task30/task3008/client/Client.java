package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;


public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Введите адрес сервера:");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите ваше имя:");
        return ConsoleHelper.readString();
    }
    protected boolean shouldSendTextFromConsole() {return true;}
    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Не удалось отправить сообщение");
            clientConnected = false;
        }
    }
    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Ошибка при ожидании socketThread");
                return;
            }
        }
            if (clientConnected) {
                ConsoleHelper.writeMessage("Соединение установлено.\n" +
                        "Для выхода наберите команду 'exit'.");
            } else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            while (clientConnected) {
                    String s = ConsoleHelper.readString();
                    if (s.equals("exit")) break;
                    if (shouldSendTextFromConsole()) sendTextMessage(s);
                }


        }


    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {
            if (message != null) ConsoleHelper.writeMessage(message);
        }
        protected void informAboutAddingNewUser(String userName) {
            if (userName != null) ConsoleHelper.writeMessage(userName + " присоединился к чату");
        }
        protected void informAboutDeletingNewUser(String userName) {
            if (userName != null) ConsoleHelper.writeMessage(userName + " покинул чат");
        }
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }
        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.NAME_REQUEST) {
                    String userName = getUserName();
                    Message msg = new Message(MessageType.USER_NAME, userName);
                    connection.send(msg);
                } else if (message.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    break;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                String userName = message.getData();
                if (message.getType() == null) throw new IOException("Unexpected MessageType");
                switch (message.getType()) {
                    case TEXT :
                        processIncomingMessage(userName);
                        break;
                    case USER_ADDED :
                        informAboutAddingNewUser(userName);
                        break;
                    case USER_REMOVED :
                        informAboutDeletingNewUser(userName);
                        break;
                    default :
                        throw new IOException("Unexpected MessageType");
                }
            }
        }
        @Override
        public void run() {
            try {
                Socket socket = new Socket(getServerAddress(), getServerPort());
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }
    }
}
