package org.example.servers;

import org.example.thread.ServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server3 {
    public static void main(String[] args) throws IOException {
        System.out.println("-------------服务端--------------");

        ServerSocket serverSocket = new ServerSocket(6666);

        while (true) {
            Socket socket = serverSocket.accept();
            new ServerThread(socket).start();

            System.out.println(socket.getInetAddress());
            System.out.println(socket.getLocalPort());
            System.out.println(socket.getSoTimeout());
        }
    }
}
