package com.codes;


import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Cache<K, V> {
    final Map<K, V> m =
            new HashMap<>();
    final ReadWriteLock rwl =
            new ReentrantReadWriteLock();
    // 读锁
    final Lock r = rwl.readLock();
    // 写锁
    final Lock w = rwl.writeLock();

    // 读缓存
    V get(K key) {
        r.lock();
        try {
            //缓存中存在，直接返回
            if (m.containsKey(key)) {
                return m.get(key);
            }
        } finally {
            r.unlock();
        }

        w.lock();
        try {
            //再次检查缓存中是否存在（重点理解！！！）
            if (m.containsKey(key)) {
                return m.get(key);
            }
            //查询数据库并写入
            V value = DB.getByKey(key);
            m.put(key, value);
            return m.get(key);
        } finally {
            w.unlock();
        }
    }

    // 写缓存
    V put(K key, V value) {
        w.lock();
        try {
            return m.put(key, value);
        } finally {
            w.unlock();
        }
    }
}