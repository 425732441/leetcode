package com.zhl.leetcode.algorithm;

/**
 * 青蛙跳台阶问题
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * @author Zhanghualei
 * @Classname FrogSteps
 * @Date 2021/1/10 18:34
 */
public class FrogClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairsNoArray(4));

    }
    /**
     * 思路：
     * f(x) = f(x-1)+f(x-2)
     * n=1 res =1;
     * n=2 res =2;
     * n=3 res =1+2;
     * n=4 res = 3+2;
     * @author zhanghualei
     * @date 2021/1/10 18:38
     * @param
     */
    public static int climbStairs(int n){
        if(n==1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] =1;
        dp[2] =2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1]+dp[i-2])%1000000007;

        }
        return dp[n];
    }

    /**
     * 不使用数组 空间复杂度降到O(1)
     * @author zhanghualei
     * @date 2021/1/10 18:46
     * @param
     */
    public static int climbStairsNoArray(int n){
        int sum,a=1,b = 2;
        for (int i = 1; i < n; i++) {
            sum = (a+b)%1000000007;
            a = b;
            b = sum;
        }
        return a;
    }



}
