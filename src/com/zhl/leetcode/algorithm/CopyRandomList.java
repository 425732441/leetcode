package com.zhl.leetcode.algorithm;

import java.util.HashMap;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * @author Zhanghualei
 * @Classname copyRandomList
 * @Date 2021/1/10 15:52
 */
public class CopyRandomList {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 思路：hash表法，
     * 构建一个map 放入 原节点和复制节点，后续参照原节点的next和random指针
     * 两次遍历：1次构建节点列表和map  一次调整next和random指向
     *
     * @param
     * @author zhanghualei
     * @date 2021/1/10 15:54
     */
    public Node copyRandomList(Node head) {
        //构建一个map
        HashMap<Node, Node> nodeMap = new HashMap<>(16);
        //第一次循环 构建map
        Node cur = head;
        while (cur != null) {
            nodeMap.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        //第二次循环 修改新节点的next和random指向
        cur = head;
        while (cur != null) {
            nodeMap.get(cur).next = nodeMap.get(cur.next);
            nodeMap.get(cur).random = nodeMap.get(cur.random);
            cur= cur.next;
        }
        return nodeMap.get(head);

    }
}
