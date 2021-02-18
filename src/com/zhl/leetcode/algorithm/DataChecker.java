package com.zhl.leetcode.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Zhanghualei
 * @Classname DataChecker
 * @Date 2021/2/17 12:12
 */
public class DataChecker {
    public static void main(String[] args) {
        boolean same = true;

        for (int j = 0; j < 1000; j++) {
            int[] ints = genRandomArray(10000);
            int[] ints1 = Arrays.copyOf(ints, ints.length);

            Arrays.sort(ints);
            int[] ints2 = SortTestCase.countSorted(ints1);
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] != ints2[i]) {
                    same = false;
                }
            }
        }


        System.out.println(same ? "ok" : "wrong");
    }

    private static int[] genRandomArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Random().nextInt(length);
        }
        return arr;
    }
}
