package com.zhl.leetcode.algorithm;

/**
 * @author Zhanghualei
 * @Classname StringAlgorithm
 * @Date 2020/12/22 11:08
 */
public class StringAlgorithm {
    /**
     * 给定⼀个字符串，验证它是否是回⽂串，只考虑字⺟和数字字符，可以忽略字⺟的⼤⼩
     * 写。 说明：本题中，我们将空字符串定义为有效的回⽂串。
     * 输⼊: "A man, a plan, a canal: Panama"
     * 输出: true
     * 思路：从首尾分别向中间遍历，下标相遇前每个charArr[i]和charArr[j]相等
     *
     * @param s
     * @author zhanghualei
     * @date 2020/12/22 11:09
     */
    public static boolean isHuiwen(String s) {
        //字符串转char数组
        char[] charArr = s.toCharArray();
        int i = 0, j = charArr.length - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(charArr[i])) {
                //如果头部循环指指针向非数字字母的字符，指针向后
                i++;
            } else if (!Character.isLetterOrDigit(charArr[j])) {
                //如果尾部循环指针指向非数字字母的字符，指针向前
                j--;
            } else {
                // 比较值是否相等 不等则返回false，相等则继续循环直到结束
                if (Character.toLowerCase(charArr[i]) != Character.toLowerCase(charArr[j])) {
                    System.out.println(charArr[i] + " " + i);
                    System.out.println(charArr[j] + " " + j);
                    return false;
                }
                i++;
                j--;

            }
        }

        return true;

    }

    /**
     * 最长回文字串 暴力法
     * @author zhanghualei
     * @date 2021/1/7 15:52
     * @param
     */
    public static java.lang.String longestHuiwenStr(java.lang.String str){
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

    public static void main(java.lang.String[] args) {
        java.lang.String s = "aababab";
        System.out.println(longestHuiwenStr(s));
        /*if (true) {
            System.out.println(0);
        } else if (true) {
            System.out.println(1);
        }
        System.out.println(isHuiwen("a man, a plan, a canal: Panama"));*/
    }
}
