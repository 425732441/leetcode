package com.zhl.leetcode.algorithm;

/**
 * 链表反转练习
 *
 * @author Zhanghualei
 * @Classname ReverseLinkList
 * @Date 2021/1/8 15:06
 */
public class ReverseLinkList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public static ListNode reverseLinkList(ListNode head) {
        ListNode recur = recur(head, null);

        return recur;
    }

    /**
     * 递归法实现链表反转
     * 1->2->3->4->null
     * null<-4<-3<-2<-1
     *
     * @param
     * @author zhanghualei
     * @date 2021/1/8 15:08
     */
    public static ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }
        //递归后移
        ListNode recur = recur(cur.next, cur);
        //反转指针
        cur.next = pre;
        return recur;


    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode listNode = reverseLinkList(listNode1);
        System.out.println(11);


    }

}
