package com.zhl.leetcode.algorithm;

/**
 * 链表相关算法
 *
 * @author Zhanghualei
 * @Classname LinklistAlgorithm
 * @Date 2020/12/22 15:34
 */
public class LinklistAlgorithm {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }


    /**
     * 实现链表反转
     *
     * @param
     * @author zhanghualei
     * @date 2020/12/22 15:51
     */
    static ListNode ReverseList(ListNode head) {
        ListNode old = head;
        ListNode newNode = null;
        while (old != null){
            ListNode next = old.next;
            old.next = newNode;
            newNode = old;
            old = next;

        }
        return newNode;
    }

    /**
     * 递归 自下到上
     * @author zhanghualei
     * @date 2020/12/23 12:12
     * @param
     */
    static ListNode ReverseListDG(ListNode head) {

        //边界条件
        if(head==null || head.next == null){
            return head;
        }
        // 递归
        ListNode listNode = ReverseListDG(head.next);

        //处理
        head.next.next = head;
        head.next = null;

        return listNode;
    }

    /**
     * 递归 自上到下 尾递归
     * @author zhanghualei
     * @date 2020/12/23 12:12
     * @param
     */
    static ListNode ReverseListDG(ListNode head,ListNode tmpNode) {

        //边界条件
        if(head==null){
            return tmpNode;
        }

        //处理
        ListNode next = head.next;
        head.next = tmpNode;

        // 尾递归
        return ReverseListDG(next,head);
    }


    public static void main(java.lang.String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        // ListNode listNode = ReverseList(a);
        ListNode listNode = ReverseListDG(a,null);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


}
