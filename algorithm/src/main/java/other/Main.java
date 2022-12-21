package other;

import java.util.HashMap;

class Node {
    Integer key;
    int value;
    Node prev;
    Node next;

    public Node() {
    }

    Node(Integer key, int value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }
}

class LRU {
    HashMap<Integer, Node> keyMap = new HashMap<Integer, Node>();
    int size;
    Node head;
    Node tail;

    int capacity;

    LRU(int size) {
        capacity = size;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(Integer key) {
        Node node = keyMap.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(Integer key, int value) {
        Node node = keyMap.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            keyMap.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                Node rev = removeTail();
                keyMap.remove(rev.getKey());
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node newNode) {
        newNode.prev = head;
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
    }

    private Node removeTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
}

public class Main {
    public static void main(String[] args) {
        LRU lru = new LRU(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1));
        lru.put(3, 3);
        lru.get(2);
        lru.put(4, 4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
    }
}