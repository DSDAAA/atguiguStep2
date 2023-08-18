package org.example.controller;

import java.io.IOException;
import java.net.*;

public class Client1 {
    public static void main(String[] args) throws IOException {
        System.out.println("-----------客户端-----------");
        DatagramSocket socket = new DatagramSocket();
        byte[] bArr = {65, 66, 67, 68};

        //todo 准备数据包
        DatagramPacket datagramPacket = new DatagramPacket(bArr,bArr.length, InetAddress.getLocalHost(),9999);

        socket.send(datagramPacket);
        socket.close();
    }
}
