package other;

import java.util.PriorityQueue;

/**
 * @Date: 2022-02-22 22:24
 * @Author: liushengxi
 * @Description:
 */
class KthLargest {
    PriorityQueue<Integer> pq;
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        if (pq.size() < k) {
            pq.add(val);
        }
        else if(val > pq.peek()){
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
