package com.logun.brique.codingtest.question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost";
        int port = 56768;
        String[] messageList = {"ping", "ping", "111"};

        for (int i = 0; i < 3; i++) {
            Thread clientThread = new Thread(new ClientTask(serverAddress, port, i, messageList[i]));
            clientThread.start();
        }
    }
}

class ClientTask implements Runnable {
    private String serverAddress;
    private int port;
    private int clientId;
    private String message;

    public ClientTask(String serverAddress, int port, int clientId, String message) {
        this.serverAddress = serverAddress;
        this.port = port;
        this.clientId = clientId;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket(serverAddress, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(message);
            System.out.println("요청 값 " + clientId + ": "  + message);

            String response = in.readLine();
            System.out.println("Client " + clientId + " 응답: " + response);

            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
