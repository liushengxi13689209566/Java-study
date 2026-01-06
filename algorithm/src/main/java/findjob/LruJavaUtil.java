package findjob;

import java.util.*;

public class LruJavaUtil {


    public static class LRUCache6<K, V> {
        private final int capacity;
        private final Map<K, V> cache;
        private final Deque<K> accessOrder;


        public LRUCache6(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>();
            this.accessOrder = new ArrayDeque<>();
        }

        public V get(K key) {
            if (!cache.containsKey(key)) {
                return null;
            }

            // 更新访问顺序
            updateAccess(key);
            return cache.get(key);
        }

        private void updateAccess(K key) {
            // 实际项目中可以使用更高效的数据结构
            accessOrder.remove(key); // O(n)
            accessOrder.addFirst(key);
        }

        public void put(K key, V value) {
            if (cache.containsKey(key)) {
                // 更新现有键值
                cache.put(key, value);
                updateAccess(key);
            } else {
                if (cache.size() >= capacity) {
                    // 移除最久未使用的
                    K oldestKey = accessOrder.removeLast();
                    cache.remove(oldestKey);
                }
                cache.put(key, value);
                accessOrder.addFirst(key);
            }
        }

        public void printCache() {
            System.out.println("访问顺序: " + accessOrder);
            System.out.println("缓存内容: " + cache);
        }
    }

    public static void main(String[] args) {
        LRUCache6<Integer, String> cache = new LRUCache6<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.printCache();

        System.out.println();
        System.out.println();

        cache.get(2); // 访问 B
        cache.printCache();

        System.out.println();
        System.out.println();

        cache.put(4, "D"); // 添加 D，A 被移除
        cache.printCache();
    }
}
