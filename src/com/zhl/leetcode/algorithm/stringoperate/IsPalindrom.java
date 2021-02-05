package com.zhl.leetcode.algorithm.stringoperate;

import java.util.Scanner;

/**
 * 一个字符串中回文的个数
 *
 * @author Zhanghualei
 * @Classname IsPalindrom
 * @Date 2021/2/5 17:12
 */
public class IsPalindrom {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int length = s.length();
        int res = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if(isPalindrom(s.substring(i,j+1))){
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    public static boolean isPalindrom(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars[length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
