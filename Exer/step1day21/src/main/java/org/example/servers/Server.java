package org.example.servers;

import org.example.socket.SocketThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("-------服务端--------");
        ServerSocket serverSocket = new ServerSocket(9999);
        int count = 0;
        while (true) {
            Socket socket = serverSocket.accept();
            count++;
            System.out.println("这是第"+ count+" 他的ip是"+socket.getInetAddress());
            new SocketThread(socket).start();

        }
    }
}
