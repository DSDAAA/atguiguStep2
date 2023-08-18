package org.example.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client3 {
    public static void main(String[] args) throws IOException {
        System.out.println("------------客户端------------");

        Socket socket = new Socket("localhost", 6666);

        Scanner scanner = new Scanner(System.in);
        String letters = scanner.next();
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        printStream.println(letters);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bufferedReader.readLine();

        printStream.close();
        bufferedReader.close();
        scanner.close();
        socket.close();
    }
}
