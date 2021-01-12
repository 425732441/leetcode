package com.zhl.leetcode.algorithm;

/**
 * @author Zhanghualei
 * @Classname RecursiveTest
 * @Date 2020/12/22 21:52
 */
public class RecursiveTest {

    /**
     * 阶乘计算
     *
     * @param
     * @author zhanghualei
     * @date 2020/12/22 21:58
     */
    static long jiecheng(int i) {
        if (i == 1 || i == 2) {
            return i;
        }
        return i * jiecheng(i - 1);
    }

    /**
     * 斐波那契数列
     *
     * @param
     * @author zhanghualei
     * @date 2020/12/22 21:59
     */
    static int fib(int i) {
        if (i < 2) {
            return i;
        }
        return fib(i - 1) + fib(i - 2);

    }

    public static void main(java.lang.String[] args) {
        System.out.println(jiecheng(13));
        for (int i = 0; i < 10; i++) {
            System.out.println(fib(i) + "+" + i);

        }

    }
}
