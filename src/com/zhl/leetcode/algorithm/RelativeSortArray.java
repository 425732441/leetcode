package com.zhl.leetcode.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**  数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 * 提示：
 *
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 *  @author Zhanghualei
 * @Classname RelativeSortArray
 * @Date 2021/1/9 9:20
 */
public class RelativeSortArray {

    /**
     * 思路：
     * 1.构造一个map放arr2的元素和位置
     * 2.对arr1进行自定义比较器排序
     *
     * @author zhanghualei
     * @date 2021/1/9 9:23
     * @param
     */
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Integer[] integersArr1 = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        //1.构造map放arr2的元素和位置
        HashMap<Integer, Integer> mapArr2 = new HashMap<>(16);
        for (int i = 0; i < arr2.length; i++) {
            mapArr2.put(arr2[i],i);
        }
        Arrays.sort(integersArr1, (o1, o2) -> {
            //到map中获取指定数字的key  找不到则指定为1001
            Integer a1 = mapArr2.getOrDefault(o1, 1001);
            Integer a2 = mapArr2.getOrDefault(o2, 1001);
            if(a1!=1001 || a2 !=1001){
                return a1-a2;
            }
            return o1-o2;
        });
        int[] ints = Arrays.stream(integersArr1).mapToInt(o -> o).toArray();
        return ints;

    }
    /**
     * [28,6,22,8,44,17]
     * [22,28,8,6]
     * 使用stream api 解决
     * @author zhanghualei
     * @date 2021/1/9 10:37
     * @param
     */
    public static int[] relativeSortArrayWithStream(int[] arr1, int[] arr2) {
        Map<Integer, Integer> mapArr2 = IntStream.range(0, arr2.length).boxed().collect(Collectors.toMap(i -> arr2[i], i -> i));
        return Arrays.stream(arr1).boxed().sorted((o1, o2) -> {
            Integer a1 = mapArr2.getOrDefault(o1, 1001);
            Integer a2 = mapArr2.getOrDefault(o2, 1001);
            if (a1 != 1001 || a2 != 1001) {
                return a1 - a2;
            }
            System.out.println(o1);
            System.out.println(o2);
            return o1 - o2;
        }).mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        // int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        // int[] arr2 = {2,1,4,3,9,6};

        int[] arr1 = {28,6,22,8,44,17};
        int[] arr2 = {22,28,8,6};
        //期望 [2,2,2,1,4,3,3,9,6,7,19]
        int[] ints = relativeSortArrayWithStream(arr1, arr2);
        System.out.println(1);
    }
}
