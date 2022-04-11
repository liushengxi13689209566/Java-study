package mq;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Date: 2022-04-08 08:50
 * @Author: liushengxi
 * @Description: 剑指 Offer 59 - II. 队列的最大值
 */
public class MaxQueue {
    //主队列
    Queue<Integer> queue;
    //辅助队列
    Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<Integer>();
        deque = new LinkedList<Integer>();
    }

    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        }
        //直接出队头即可
        return deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        //注意这里判断的是 last 即队尾
        while (!deque.isEmpty() && deque.peekLast() <= value) {
            deque.pollLast();
        }
        deque.offerLast(value);
    }


    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int ans = queue.peek();
        if (ans == deque.peekFirst()) {
            deque.pollFirst();
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        MaxQueue obj = new MaxQueue();
        int param_1 = obj.max_value();
        int param_3 = obj.pop_front();
    }
}
