package org.example.client;

import java.io.*;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 7777);

        File file = new File("resources/photo.jpg");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeUTF(file.getName().substring(0, file.getName().lastIndexOf(".")));
        FileInputStream fileInputStream = new FileInputStream(file);

        byte[] data = new byte[1024];
        int len;
        while ((len = fileInputStream.read(data)) != -1) {
            objectOutputStream.write(data, 0, len);
        }
        socket.shutdownOutput();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String result = bufferedReader.readLine();
        System.out.println(result);

        objectOutputStream.close();
        bufferedReader.close();
        fileInputStream.close();
        socket.close();
    }
}
