package com.zhl.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 *  @author Zhanghualei
 * @Classname TwoSum
 * @Date 2021/1/9 12:43
 */
public class TwoSum {
    /**
     * 暴力查找法
     * @author zhanghualei
     * @date 2021/1/9 12:43
     * @param
     */
    public static int[] twoSum1(int[] nums,int target){
        //暴力查找
        //循环查找 最后一个节点不需要访问 所以外侧i<nums.length-1
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("无结果");
    }
    /**
     * 查找表法
     * @author zhanghualei
     * @date 2021/1/9 12:43
     * @param
     */
    public static int[] twoSum2(int[] nums,int target){
        //nums[i]+nums[j] = target ==> nums[i] = target - nums[j]
        //循环将数据放到一个map中 key是数字 value是下标位置
        //每次放之前判断一下map中是否存在key 为 target-nums[x]的数字
        //存在则 map中的value 和 x 就是结果，不存在则将nums[x]为key x为value 放入map
        HashMap<Object, Object> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if( map.containsKey(key)){
                //如果 map中存在
                int t = (int)map.get(key);
                return new int[]{t,i};
            } else {
                //map中不存在目标值
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("无结果");
    }

    public static String replaceSpace(String s) {
        int length = s.length();
        int size = 0;
        char[] chars = new char[length*3];
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if ( c== ' '){
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            } else {
                chars[size++] = c;
            }
        }
        return new String(chars,0,size);
    }
    public static void main(String[] args) {
        String a = "We are one";
        int[] nums = {2,11,15,7};
        int[] ints = twoSum2(nums, 9);
        System.out.println(1);
        System.out.println(replaceSpace(a));
    }
}
