package com.zhl.leetcode.algorithm.stringoperate;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * @author Zhanghualei
 * @Classname ReverseWords
 * @Date 2021/1/11 17:46
 */
public class ReverseWords {
    /**
     * 思路： 使用栈来倒序
     * 1.字符串去首尾空格
     * 2.单词按正序入栈
     * 3.单词出栈 组成新字符串
     *
     * @param
     * @author zhanghualei
     * @date 2021/1/11 17:47
     */
    public static String reverseWords(String s) {
        //字符串去空格
        String trimStr = s.trim();
        //创建栈
        Deque<String> deque = new ArrayDeque<>();
        //循环字符串
        int left = 0, right = trimStr.length();
        int tmpPos = 0;
        while (left < right) {
            if (trimStr.charAt(left) == ' ') {
                // 遇到空格说明是一个单词
                //前面的字符串 [tmpPos,left] 入栈
                deque.push(trimStr.substring(tmpPos, left));
                tmpPos = left+1;
            }
            left++;
        }
        //结束后
        deque.push(trimStr.substring(tmpPos, left));
        return String.join(" ", deque);
    }

    public static void main(String[] args) {
        String s = " hello world we. are. family! ";
        System.out.println(reverseWords(s));
    }
}
