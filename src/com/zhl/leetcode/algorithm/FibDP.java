package com.zhl.leetcode.algorithm;

/**
 * 动态规划解决斐波那契数列
 * 0 1 1 2 3 5 8 ...
 * @author Zhanghualei
 * @Classname FibDP
 * @Date 2021/1/10 17:48
 */
public class FibDP {

    public static int fibDP(int n){
        //定义一个状态数组 dp[i]为位置i的数字
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        if (n==0||n==1){
            return n;
        }

        for (int i = 2; i <= n; i++) {
            //填充数组
            dp[i] = (dp[i-1] + dp[i-2])%1000000007;
        }
        return dp[n];
    }

    public static int fib(int n){

        int sum,a=0,b=1;
        for (int i = 0; i < n; i++) {
            sum = (a+b)%1000000007;
            a = b;
            b = sum;
            //填充数组
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(fibDP(5));
        System.out.println(fib(0));

    }
}
