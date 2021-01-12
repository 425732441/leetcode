package com.zhl.leetcode.algorithm;


import java.util.Stack;

/**
 * stack不推荐使用 仅用于demo示例
 *
 * @author Zhanghualei
 * @Classname QueueWithStack
 * @Date 2021/1/5 15:05
 */
public class QueueWithStack<T> {
    Stack<T> s1 = new Stack<>();
    Stack<T> s2 = new Stack<>();
    T front;

    public void push(T val) {
        if (s1.isEmpty()) {
            front = val;
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(val);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public T pop() {
        T pop = s1.pop();
        if (!s1.isEmpty()) {
            front = s1.peek();
        }
        return pop;
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    public static void main(java.lang.String[] args) {
        /*QueueWithStack<Integer> queueWithStack = new QueueWithStack<>();
        for (int i = 0; i < 20; i++) {
            queueWithStack.push(i);
        }


        while (!queueWithStack.isEmpty()) {
            System.out.println(queueWithStack.pop());
        }*/

        int[] arr = {3, 7, 1, 2, 7, 5, 8, 9,0,15,23,11,100,11};

        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {

            System.out.println(i);
        }

    }


    /**
     * 快速排序算法
     * @author zhanghualei
     * @date 2021/1/7 15:47
     * @param
     */
    public static void quickSort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int base = arr[L];
        int left = L;
        int right = R;
        //当左下标小于右下标时  循环移动下标
        while (left < right) {
            //1.先移动右侧下标 满足右边数字小于基准点的情况时 交换 left right下标对应值
            //1.1先移动右侧下标
            while (left < right && arr[right] >= base) {
                right--;
            }
            //1.2跳出循环后 说明 arr[right] < base 需要移动
            if (left < right) {
                arr[left] = arr[right];
            }
            //2.移动左侧下标 满足左边数字大于基准点数字时  交换 right left 对应下标的值
            while (left < right && arr[left] <= base) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
            }
            //3.left 和 right 相遇后  当前位置值 放基准点
            if (left >= right) {
                arr[left] = base;
            }

        }
        quickSort(arr, L, right - 1);
        quickSort(arr, right + 1, R);


    }
}
