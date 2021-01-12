package com.zhl.leetcode.algorithm;

/**
 * 一个字符串的最长回文串
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 三种解法
 * @author Zhanghualei
 * @Classname LongestPalindromeTest
 * @Date 2021/1/8 9:22
 */
public class LongestPalindromeTest {
    public static void main(String[] args) {
        // System.out.println(longestPalindromeCenterExpand("babacc"));
        System.out.println(longestPalindromeDP("abababcccccc"));


        System.out.println(false^false);
    }




    /**
     * a b a b a
     * 0 1 2 3 4
     * 最长回文串 动态规划解法
     * 原理：一个短回文串两端的字母相等 则加上两端的字母后仍然是回文  aba=true >> babab=true
     * P{i,j} 表示i到j是否是回文串
     * 得到状态转移公式  P{i,j} = P{i+1,j-1} && (Si == Sj)
     * 因此P{i,j}的值可以参考 P{i+1,j-1} 如果画出矩阵则代表每个值参考左下方的值
     * 由于i<j 填表时只填写右上部分，因为要参考左下单元格的值 所以需要 一列列竖着填
     *   0 1 2 3 4
     * 0 o x o x o
     * 1   o x o x
     * 2     o x o
     * 3       o x
     * 4         o
     *
     * @author zhanghualei
     * @date 2021/1/8 10:18
     * @param
     */
    public static String longestPalindromeDP(String s) {
        //特殊判断
        if (s == null || s.length() < 1) {
            return "";
        }
        int length = s.length();
        char[] chars = s.toCharArray();
        //定义一个bool数组矩阵来保存状态
        boolean[][] dp = new boolean[length][length];
        int begin = 0;
        int maxLength = 1;
        //预先初始化对角线
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        //一列列开始填表 j的0列填了所以从1开始
        for (int j = 1; j < length; j++) {
            //i从0 到j
            for (int i = 0; i < j; i++) {
                //以下几种情况
                if (chars[i] != chars[j]) {
                    //不等的时候 状态false
                    dp[i][j] = false;
                } else {
                    //首尾相等时
                    if (j - i < 3) {
                    //     ababa 2-0 =2 中间只有字母b 两边又相等  肯定是回文
                        dp[i][j] = true;
                    } else {
                        //状态转移
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                //求 下标
                if (dp[i][j] && maxLength < j - i +1) {
                    begin = i;
                    maxLength = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }

    /**
     * a b a b a
     * 0 1 2 3 4
     * 最长回文串 中心扩展法
     * 遍历得到中心，根据中心位置去向两边扩散，
     * 直到两边的值不等时
     * 得到最后相等的下标  0 4
     * 根据记录的最大长度去比较 大于最大长度则更新最大长度到新算出的最大长度
     * @author zhanghualei
     * @date 2021/1/8 9:25
     * @param
     */
    public static String longestPalindromeCenterExpand(String s){
        //先判断如果空串时直接返回
        if(s ==null||s.length() == 0) {
            return "";
        }
        //记录字符长度 记录最长回文长度 开始下标 转char数组
        int length = s.length();
        int end = 0;
        int begin = 0;
        char[] chars = s.toCharArray();
        //遍历中心点 传入扩展方法
        for (int i = 0; i < length; i++) {
            //此处分两种情况  奇数和偶数长度时中心点下标是不同的
            int odd = expandFromCenter(chars,i,i);
            int even = expandFromCenter(chars,i,i+1);
            //判断是否最大长度 更新最大长度和开始下标
            int max = Math.max(odd, even);
            if (max>end-begin){
                begin = i-(max-1)/2;
                end = i+ max/2+1;
            }

        }
        return s.substring(begin,end);

    }

    /**
     * 根据传入的下标向两边扩展 直到左右下标对应的值不同
     * @author zhanghualei
     * @date 2021/1/8 9:36
     * @param
     */
    private static int expandFromCenter(char[] chars, int left, int right) {
        while (left>=0 && right<chars.length && chars[left] ==chars[right]) {
            --left;
            ++right;
        }
        return right-left-1;
    }


    /**
     * 最长回文字串 暴力法
     * @author zhanghualei
     * @date 2021/1/7 15:52
     * @param
     */
    public static String longestHuiwenStr1(String str){
        if(str.length()<2){
            return str;
        }
        char[] chars = str.toCharArray();

        //记录开始下标和最大长度下标
        int begin=0;
        int maxL = 1;
        //枚举出所有子串 判断是否回文
        int len = str.length();
        for (int i = 0; i < len; i++) {
            for (int j=i+1;j<len;j++){
                //判断 j-i+1>maxL 是否回文
                if(j-i+1>maxL && validateHuiwen(chars,i,j)){
                    begin=i;
                    maxL = j-i+1;
                }


            }
        }
        return str.substring(begin,begin+maxL);
    }
    public static boolean validateHuiwen(char[] chars, int start, int end){
        while (start < end) {
            if (chars[start] != chars[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
