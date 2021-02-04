package com.zhl.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU算法思路：
 * 通过map实现O(1)的查找效率，通过双向链表实现存放后的位移操作
 * get()---> 找到的元素要移动到队列头部，返回对应值
 * 找不到返回-1
 * put()---> 存在的元素更新值并且移动到头部
 * ---> 不存在的元素，直接添加到头部
 * ---> 长度超出的情况：移除队列尾部的元素
 * 移动到头部和添加到头部 共有操作部分为添加到头部
 * 移动到头部 = 断开元素（移除）+添加到头部
 *
 * @author Zhanghualei
 * @Classname LRU
 * @Date 2021/2/4 9:11
 */
public class LRU {
    int capacity;
    //创建头尾dummy节点 方便操作
    Node head, tail;
    Map<Integer, Node> cache = new HashMap<>();

    public LRU(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        //下边两行将头尾节点双向连接 这样在放入元素后可以很容易的将元素插入到head和tail之间
        // node.next = head.next,  新节点后继指向头节点后继
        // node.prev=head,  新节点前驱指向头节点
        // head.next.prev=node  头节点后继节点的前驱指向新节点
        // head.next=node,  头节点的后继指向新节点
        head.next = tail;
        tail.prev = head;
    }

    /**
     * @param
     * @author zhanghualei
     * @date 2021/2/4 9:41
     */
    void put(int key, int value) {
        //判断是否存在这个节点
        if (cache.containsKey(key)) {
            //更新值
            Node node = cache.get(key);
            node.val = value;
            //移动到头部
            moveToHead(node);
        } else {
            //添加节点到头部
            Node node = new Node(key, value);
            addToHead(node);
            //添加到map中
            cache.put(key, node);
            //判断是否超出容量
            if (cache.size() > capacity) {
                removeTail();
            }
        }
    }

    int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            //移动到头部
            moveToHead(node);
            //返回当前值
            return node.val;
        }
    }

    private void removeTail() {
        Node prev = tail.prev;
        cache.remove(prev.key);
        removeNode(prev);
    }

    private void moveToHead(Node node) {
        //1.断开
        Node removed = removeNode(node);
        //2.添加到头部
        addToHead(removed);
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private Node removeNode(Node node) {
        //当前节点前驱的后继指向当前节点的后继
        node.prev.next = node.next;
        //当前节点后继的前驱指向当前节点的前驱
        node.next.prev = node.prev;
        //返回当前节点
        return node;
    }

    static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRU lRUCache = new LRU(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
    }
}
