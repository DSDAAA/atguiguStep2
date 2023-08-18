package org.example.servers;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
public class Server1 {
    public static void main(String[] args) throws IOException {
        System.out.println("--------------服务端------------");

        DatagramSocket server = new DatagramSocket(9999);
        byte[] bArr = new byte[10];
        DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length);
        int length = datagramPacket.getLength();
        server.receive(datagramPacket);
        System.out.println(length);
        String s = new String(bArr,0,length);
        System.out.println(s);
        server.close();
    }
}
