package com.zhl.leetcode.algorithm;

/**
 * 两数字相加  数字每位在链表节点中保存
 * 2->4->3
 * 5->6->4
 * -------
 * 7->0->8
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * @author Zhanghualei
 * @Classname AddTwoNumbers
 * @Date 2021/1/8 16:00
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode L11 = new ListNode(2);
        ListNode L12 = new ListNode(4);
        ListNode L13 = new ListNode(3);

        L11.next = L12;
        L12.next = L13;

        ListNode L21 = new ListNode(5);
        ListNode L22 = new ListNode(6);
        ListNode L23 = new ListNode(4);
        L21.next = L22;
        L22.next = L23;
        ListNode listNode = addTwoNumbers(L11, L21);

        System.out.println(2);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //进位保存
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        //如果l1 或者l2 有一个不空  则可以继续向后移
        while (l1!=null || l2 != null || carry != 0){
            int v1 = l1==null?0:l1.val;
            int v2 = l2==null?0:l2.val;
            // 两值相加
            int sum = (v1+v2+carry);
            head.next = new ListNode(sum%10);
            carry = sum /10;
            head = head.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return dummy.next;
    }

}
