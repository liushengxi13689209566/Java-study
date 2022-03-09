package com.tattoo.code;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * @Date: 2022-02-07 11:45
 * @Author: liushengxi
 * @Description:
 */
// 生产者
class BrokenPrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled = false;

    BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!cancelled)
                // 生产素数
                queue.put(p = p.nextProbablePrime());
        } catch (InterruptedException consumed) {
        }
    }

    public void cancel() {
        cancelled = true;
    }
}
