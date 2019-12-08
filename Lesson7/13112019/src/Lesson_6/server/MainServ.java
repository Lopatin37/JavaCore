package Lesson_6.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.ArrayList;
import java.util.Vector;

public class MainServ {
    private Vector<ClientHandler> clients;
    ArrayList<String> nicksOnline;

    public MainServ() {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;
        nicksOnline = new ArrayList<>();

        try {
            AuthService.connect();
            server = new ServerSocket(8089);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился!");
                new ClientHandler(this, socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();
        }
    }

    public void broadcastMsg(String msg) {
        for (ClientHandler o: clients) {
            o.sendMsg(msg);
        }
    }

    public void privateMsg(String msg){
        String[] tokens = msg.split(" ");
        StringBuilder str = new StringBuilder(tokens[0]); // в tokens[0] хранится ник отправителя
        for(int i = 3; i < tokens.length; i++){
            str.append(" ").append(tokens[i]);
        }
        String newMsg = str.toString();
        //Далее находится индекс отправителя и получателя.
        //После этого им отсылаются сообщения. Это позволяет отослать два сообщения при одном проходе массива.
        int indexOfSender = -1;
        int indexOfRecipient = -1;
        for(ClientHandler o : clients){
            if(o.nick.equals(tokens[0])) indexOfSender = clients.indexOf(o);
            if(o.nick.equals(tokens[2])) indexOfRecipient = clients.indexOf(o);
        }
        if((indexOfRecipient >= 0) && (indexOfSender >= 0)) {
            clients.get(indexOfRecipient).sendMsg(newMsg);
            clients.get(indexOfSender).sendMsg(newMsg);
            return;
        }

        for(ClientHandler o : clients){
            if(o.nick.equals(tokens[0])) o.sendMsg("Клиент " + tokens[2] + " отсутствует.");
        }
    }

    public void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }
}
