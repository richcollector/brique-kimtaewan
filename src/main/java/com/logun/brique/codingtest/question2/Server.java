package com.logun.brique.codingtest.question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 56768;

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("서버 START!!");

        ExecutorService executor = Executors.newCachedThreadPool();

        while (true) {
            Socket clientSocket = serverSocket.accept();

            executor.submit(() -> {
                try {
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    String inputMessage;
                    while ((inputMessage = in.readLine()) != null) {
                        System.out.println("받은 요청: " + inputMessage);
                        Thread.sleep(3000);
                        if (inputMessage.equals("Ping")) {
                            out.println("Pong");
                            break;
                        } else {
                            out.println(inputMessage);
                            break;
                        }
                    }
                    out.close();
                    in.close();
                    clientSocket.close();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
