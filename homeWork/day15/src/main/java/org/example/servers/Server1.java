package org.example.servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Server1 {
    public static void main(String[] args) throws IOException {
        System.out.println("--------------服务端-------------");
        ServerSocket serverSocket = new ServerSocket(7777);
        Socket socket = serverSocket.accept();
        Map<String, String> map = new HashMap<>();
        map.put("星期一", "Monday");
        map.put("星期二", "Tuesday");
        map.put("星期三", "Wednesday");
        map.put("星期四", "Thursday");
        map.put("星期五", "Friday");
        map.put("星期六", "Saturday");
        map.put("星期日", "Sunday");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream printStream = new PrintStream(socket.getOutputStream());

        String line = bufferedReader.readLine();
        System.out.println("" + socket.getInetAddress() + socket.getLocalPort() + line + LocalDateTime.now());
        if (map.containsKey(line)) {
            printStream.println(map.get(line));
        } else {
            printStream.println("未查询到指定日期");
        }

        bufferedReader.close();
        printStream.close();
        socket.close();
        serverSocket.close();
    }
}
