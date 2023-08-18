package org.example.thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class ServerThread extends Thread {
    Socket socket;

    @Override
    public void run() {
        Map<String, String> map = new HashMap<>();
        map.put("星期一", "Monday");
        map.put("星期二", "Tuesday");
        map.put("星期三", "Wednesday");
        map.put("星期四", "Thursday");
        map.put("星期五", "Friday");
        map.put("星期六", "Saturday");
        map.put("星期日", "Sunday");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            String key = bufferedReader.readLine();
            if (map.containsKey(key)) {
                printStream.println(map.get(key));
            } else {
                printStream.println("输入有误");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
