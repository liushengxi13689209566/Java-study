package leftRight;

import java.util.LinkedList;
import java.util.Queue;

public class ApiRateLimiter {
    public static int rateLimiter(int n, int m, int[] requests) {
        // n: 滑动窗口大小（秒）
        // m: 阈值（窗口内最多允许的请求数）
        // requests[i]: 在第 i 秒到达的请求数量

        Queue<Integer> queue = new LinkedList<>();  // 等待队列
        int[] window = new int[n];  // 滑动窗口，记录过去 n 秒的请求数
        int windowIndex = 0;  // 当前窗口位置

        for (int t = 0; t < requests.length; t++) {
            int incomingRequests = requests[t];

            // 计算当前窗口内已允许的请求总数
            int currentWindowCount = 0;
            for (int count : window) {
                currentWindowCount += count;
            }

            // 处理新到达的请求
            int allowedFromIncoming = 0;
            int availableCapacity = m - currentWindowCount;

            if (availableCapacity > 0) {
                allowedFromIncoming = Math.min(incomingRequests, availableCapacity);
                incomingRequests -= allowedFromIncoming;
            }

            // 剩余的新请求加入队列
            if (incomingRequests > 0) {
                queue.offer(incomingRequests);
            }

            // 更新当前时间的窗口计数
            window[windowIndex] = allowedFromIncoming;

            // 尝试从队列中处理请求（如果还有容量）
            currentWindowCount += allowedFromIncoming;
            availableCapacity = m - currentWindowCount;

            while (!queue.isEmpty() && availableCapacity > 0) {
                int queuedRequests = queue.poll();
                int allowedFromQueue = Math.min(queuedRequests, availableCapacity);

                window[windowIndex] += allowedFromQueue;
                availableCapacity -= allowedFromQueue;
                currentWindowCount += allowedFromQueue;

                // 如果队列中的这批请求没有全部处理完，剩余的放回队列
                if (queuedRequests > allowedFromQueue) {
                    queue.offer(queuedRequests - allowedFromQueue);
                    break;
                }
            }

            // 移动窗口到下一秒
            windowIndex = (windowIndex + 1) % n;
        }

        // 返回队列中剩余的请求总数
        int queueSize = 0;
        while (!queue.isEmpty()) {
            queueSize += queue.poll();
        }

        return queueSize;
    }

    public static void main(String[] args) {
        // Example 1
        int n1 = 3;
        int m1 = 5;
        int[] requests1 = {1, 3, 2, 5};
        System.out.println("Example 1: " + rateLimiter(n1, m1, requests1)); // 输出: 5

        // 测试更多案例
        int n2 = 2;
        int m2 = 3;
        int[] requests2 = {2, 2, 2};
        System.out.println("Example 2: " + rateLimiter(n2, m2, requests2));

        int n3 = 4;
        int m3 = 10;
        int[] requests3 = {5, 5, 5, 5};
        System.out.println("Example 3: " + rateLimiter(n3, m3, requests3));
    }
}
