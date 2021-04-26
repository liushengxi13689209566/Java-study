package com.codes.DesignPattern;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class echo_easy {
    public static void main(String[] args) throws IOException {
        final ServerSocketChannel serverSocketChannel =
                ServerSocketChannel.open().bind(new InetSocketAddress(8008));
        try {
            while (true) {
                SocketChannel sc = serverSocketChannel.accept();
                new Thread(() -> {
                    try {
                        ByteBuffer rb = ByteBuffer.allocate(1024);
                        sc.read(rb);
                        Thread.sleep(2000);
                        ByteBuffer wb = (ByteBuffer) rb.flip();
                        sc.write(wb);
                        sc.close();
                    } catch (Exception e) {
                        System.out.println("Exception");
                    }
                }).start();
            }
        } finally {
            serverSocketChannel.close();
        }
    }
}
