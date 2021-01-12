package com.zhl.leetcode.algorithm;

import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedList;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * @author Zhanghualei
 * @Classname CQueue
 * @Date 2021/1/10 11:31
 */
public class CQueue {
    //两个栈 s1用于入队尾 s2用于删队首 s1 pop到s2中 顺序就变成s1中的倒序 s2中栈顶的就是s1中栈底元素（队首）

    LinkedList<Integer> s1,s2;
    public CQueue() {
        s1 = new LinkedList();
        s2 = new LinkedList();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    /**
     * 思路：
     * s2中有值 直接pop出栈顶
     * s2中无值 分两种情况
     * 1.s1中无值 返回-1
     * 2.s1有值 则将s1中元素出栈 再入到s2 最后弹出s2栈顶元素
     * @author zhanghualei
     * @date 2021/1/10 11:37
     * @param
     */
    public int deleteHead() {
        if(!s2.isEmpty()){
            return s2.pop();
        } else {
            if(s1.isEmpty()){
                return -1;
            } else {
                // s1出栈  入 s2
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                return s2.pop();
            }
        }
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);

        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */