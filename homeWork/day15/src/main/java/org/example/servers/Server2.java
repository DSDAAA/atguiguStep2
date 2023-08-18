package org.example.servers;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7777);
        Socket socket = serverSocket.accept();

        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        String fileName = objectInputStream.readUTF();
        String UID = "" + fileName + System.currentTimeMillis() + ".jpg";

        FileOutputStream fileOutputStream = null;
        fileOutputStream = new FileOutputStream(UID);
        byte[] data = new byte[1024];
        int length;
        while ((length = objectInputStream.read(data)) != -1) {
            fileOutputStream.write(data, 0, length);
        }

        fileOutputStream.close();
        printStream.close();
        objectInputStream.close();
        socket.close();
        serverSocket.close();
    }
}
