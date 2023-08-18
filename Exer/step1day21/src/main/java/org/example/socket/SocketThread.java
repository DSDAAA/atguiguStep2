package org.example.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class SocketThread extends Thread {
    Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintStream ps = new PrintStream(socket.getOutputStream());
        ) {
            //读取数据
            String line = br.readLine();
            //反转
            StringBuffer reverse = new StringBuffer(line).reverse();
            //展示数据
            System.out.println(socket.getInetAddress()+"发来的信息是 = " + line+",反转后:"+reverse);
            //数据反馈
            ps.println(reverse.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
