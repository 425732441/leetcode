package com.zhl.leetcode.algorithm;

import java.util.stream.IntStream;

/**
 * @author Zhanghualei
 * @Classname Aqs
 * @Date 2020/12/18 18:01
 */
public class Aqs {



    static volatile int data =0;
    // static AtomicInteger data = new AtomicInteger(0);

    public static void main(java.lang.String[] args) {
        // 类的成员变量
        // main方法内代码
        IntStream.range(0, 2).forEach((i) -> {
            new Thread(() -> {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                IntStream.range(0, 100).forEach(y -> {
                    data++;
                });
            System.out.println(Thread.currentThread().getName());
            }).start();
        });

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(data);
    }
}

