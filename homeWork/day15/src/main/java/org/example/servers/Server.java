package org.example.servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("-------------------服务端---------------");
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        PrintStream printStream = new PrintStream(socket.getOutputStream());
        printStream.println("欢迎咨询尚硅谷!");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(socket.getInetAddress().getHostAddress() + "留言:" + LocalDateTime.now());
        System.out.println(bufferedReader.readLine() + "\n");
        printStream.println("这个月的所有期班都已经满了,只能报下个月的班");
        System.out.println(socket.getInetAddress().getHostAddress() + "留言:" + LocalDateTime.now());
        System.out.println(bufferedReader.readLine());

        socket.close();
        serverSocket.close();
    }
}
