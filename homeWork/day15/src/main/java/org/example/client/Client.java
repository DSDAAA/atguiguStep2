package org.example.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("-------------------客户端---------------");
        Socket socket = new Socket("localhost", 9999);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());

        PrintStream printStream=new PrintStream(socket.getOutputStream());
        printStream.println("你好，我想报名这个月的JavaEE就业班！");
        System.out.println(bufferedReader.readLine());
        printStream.println("好的,赶紧帮我占个座");
        printStream.close();
        socket.close();
    }
}
