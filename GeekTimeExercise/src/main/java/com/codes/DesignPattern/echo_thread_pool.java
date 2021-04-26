package com.codes.DesignPattern;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class echo_thread_pool {
    public static void main(String[] args) throws IOException {
        final ServerSocketChannel serverSocketChannel =
                ServerSocketChannel.open().bind(new InetSocketAddress(8008));
        //ExecutorService executorService = Executors.newFixedThreadPool(500);
        ExecutorService executorService = new ThreadPoolExecutor(
                50, 500, 60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(2000),
                r -> {
                    return new Thread(r, "echo-" + r.hashCode());
                },
                new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            while (true) {
                SocketChannel sc = serverSocketChannel.accept();
                executorService.execute(() -> {
                    try {
                        ByteBuffer rb = ByteBuffer.allocate(1024);
                        sc.read(rb);
                        Thread.sleep(2000);
                        ByteBuffer wb = rb.flip();
                        sc.write(wb);
                        sc.close();
                    } catch (Exception e) {
                        System.out.println("Exception");
                    }
                });
            }
        } finally {
            serverSocketChannel.close();
        }
    }
}
