package com.zhl.leetcode.algorithm;

import java.util.LinkedList;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * @author Zhanghualei
 * @Classname MinStack
 * @Date 2021/1/10 13:18
 */
public class MinStack {

    /**
     * 思路：使用辅助栈实现存储最小值 每次push入栈时将比较后的最小值存到辅助栈里
     *
     * @author zhanghualei
     * @date 2021/1/10 13:20
     * @param
     */
    LinkedList<Integer> dataStack, minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        dataStack = new LinkedList();
        minStack = new LinkedList();
    }

    //push时判断当前最小值和x的大小 如果x小于当前最小值 x进入minstack
    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty() || x<=minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if(dataStack.pop().equals(minStack.peek())){
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
