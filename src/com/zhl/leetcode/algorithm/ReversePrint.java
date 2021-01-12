package com.zhl.leetcode.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.ToIntFunction;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * <p>
 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 * @author Zhanghualei
 * @Classname ReversePrint
 * @Date 2021/1/10 9:43
 */
public class ReversePrint {
    static ArrayList<Integer> res = new ArrayList();

    /**
     * 递归遍历链表到最后节点 再回溯进行数组的填充
     *
     * @param
     * @author zhanghualei
     * @date 2021/1/10 9:45
     */
    public static int[] reversePrint(ListNode head) {
        recur(head);
        int[] result = new int[res.size()];
        return res.stream().mapToInt(value -> value).toArray();
    }

    /**
     * 链表只能从前往后访问  利用栈后进先出的特点 将链表从前往后加入栈 从栈中挨个取出就是倒序了
     *
     * @param
     * @author zhanghualei
     * @date 2021/1/10 9:45
     */
    public static int[] reversePrintUseStack(ListNode head) {
        //linkList做栈
        LinkedList<Integer> l = new LinkedList();

        //遍历链表
        while (head !=null) {
            l.push(head.val);
            //指针后移
            head=head.next;
        }
        //返回int数组

        return l.stream().mapToInt(v->v).toArray();

    }

    public static void recur(ListNode head) {
        //边界条件 head==null  返回
        if (head == null) {
            return;
        }
        //递归向后移动节点 直到head=null后开始回溯
        recur(head.next);
        res.add(head.val);
    }

}
