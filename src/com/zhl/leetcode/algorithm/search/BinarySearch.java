package com.zhl.leetcode.algorithm.search;

import java.security.cert.TrustAnchor;

/**
 * 二分查找法查找某个值
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * @author Zhanghualei
 * @Classname BinarySearch
 * @Date 2021/1/11 11:42
 */
public class BinarySearch {

    /**
     * 思路：
     * 二分法查找目标的左边界下标 和右边界下标 计算得出目标个数
     * nums = [5,7,7,8,8,10]
     * Left = 2,right = 5
     * 结果 = right - left -1 = 2
     *
     * @param
     * @author zhanghualei
     * @date 2021/1/11 14:05
     */
    public static int binarySearch(int[] nums,int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left;
        try {
                left = searchLeft(nums, target);
        } catch (Exception e) {
            return 0;
        }
        int r = searchRight(nums, target);
        return r-left-1;
    }

    private static int searchLeft(int[] nums, int target) {
        // 定义i = 0 j = len(nums)-1 向中间移动 i=j时的下标就是左边界
        int i = 0, j = nums.length - 1;
        //此处 由于是取边界的下标  1 8 8 8 9 取 1 9 的下标 所以循环中 i<=j 这样循环完毕结果 j 会小于i
        //如果  1 8 8 8 9 取 第一个8 的下标 所以循环中 i<j 这样循环完毕结果 j == i
        while (i <= j) {
            //(i+j)/2 做中点mid 比较mid和target的情况
            int mid = (i + j) >>> 1;
            if (nums[mid] < target) {
                //mid 在 target左边 left 在[mid+1,j]之间  直接移动i 到mid+1
                i = mid +1;
            } else if(nums[mid] == target){
                //mid 和target相等
                // left 在 i 到 mid-1之间  [i,mid-1]  j = mid-1
                // right 在 [mid+1,j] i = mid +1
                j = mid -1;
            } else {
                //mid > target left 在 [i,mid-1]之间
                j = mid -1;
            }
        }
        // 判断是否存在 不存在返回-1
        if(nums[i] != target){
            throw new RuntimeException();
        }
        //返回i j 的区别 取边界 返回j  取第一个目标的下标 返回i
        return j;
    }
    public static int searchRight(int[] nums, int target){
        int i = 0, j = nums.length - 1;
        while(i<=j){
            int mid = (i+j) >>> 1;
            if(nums[mid] <= target){
                // [mid,j]
                i = mid + 1;
            } else {
                // [i,mid]
                j  = mid - 1;
            }
        }
        return i;
    }

    public static int search(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if(j >= 0 && nums[j] != target) return 0;
        // 搜索左边界 right
        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        return right - left - 1;
    }

    public static void main(String[] args) {
        // int[] nums = {1, 2, 3, 4, 5, 5, 5, 7, 8};
        int[] nums = {1};
        int i = binarySearch(nums, 1);
        searchRight(nums, 5);
        System.out.println(i);
    }
}
