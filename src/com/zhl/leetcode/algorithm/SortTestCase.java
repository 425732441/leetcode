package com.zhl.leetcode.algorithm;

/**
 * @author Zhanghualei
 * @Classname Main
 * @Date 2021/2/5 16:30
 */
public class SortTestCase {
    public static String sumTwoNum(String a, String b) {
        try {
            return "\"" + (Integer.valueOf(a) + Integer.valueOf(b)) + "\"";
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        // int[] arr = {1, 3, 2, 6, 9, 7, 8, 4, 5, 0, 8, 8, 9, 1, 2, 3, 4, 5};
        int[] arr1 = {1, 3, 4, 6, 8, 2, 6, 5, 7, 10, 6};

        // selectSort(arr);
        // bubbleSort(arr1);
        // insertSort(arr);
        // shellSort(arr);
        // mergeSort(arr, 0, arr.length - 1);
        quicksort(arr1, 0, arr1.length - 1);
        print(arr1);
    }

    public static void quicksort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(arr, left, right);
        quicksort(arr, left, partition - 1);
        quicksort(arr, partition + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        //右边界做pivot
        int pivot = arr[right];
        int i = left;
        int j = right - 1;
        while (i <= j) {
            //找i的位置
            while (i <= j && arr[i] <= pivot) {
                i++;
            }
            while (i <= j && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, i, right);
        return i;
    }

    private static void quicksort1(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i < j) {

            while (i < j && arr[j] >= pivot) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
            }
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
            }

            if (i >= j) {
                arr[i] = pivot;
            }
        }
        quicksort1(arr, left, i - 1);
        quicksort1(arr, i + 1, right);


    }

    public static void mergeSort(int[] arr, int left, int right) {
        //base case
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        //递归排左子数组
        mergeSort(arr, left, mid);
        //递归排右子数组
        mergeSort(arr, mid + 1, right);
        //合并
        merge(arr, left, mid + 1, right);

    }

    /**
     * 假设两个子数组分别有序 进行合并排序
     *
     * @param left     子数组1左边界
     * @param splitPos 子数组2左边界
     * @param right    子数组2右边界
     * @author zhanghualei
     * @date 2021/2/15 15:55
     */
    private static void merge(int[] arr, int left, int splitPos, int right) {
        //创建新数组
        int[] newArray = new int[right - left + 1];
        //三个指针
        int i = left;
        int j = splitPos;
        int k = 0;
        while (i <= splitPos - 1 && j <= right) {
            /*if (arr[i] <= arr[j]) {
                newArray[k] = arr[i];
                k++;
                i++;
            } else {
                newArray[k] = arr[j];
                k++;
                j++;
            }*/
            //简写为
            newArray[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        //多余的数字直接赋值
        while (i <= splitPos - 1) {
            newArray[k++] = arr[i++];
        }
        while (j <= right) {
            newArray[k++] = arr[j++];
        }
        //数组赋值到原数组
        for (int m = 0; m < newArray.length; m++) {
            arr[left + m] = newArray[m];
        }
    }

    /**
     * 希尔排序：
     * 思路：
     * 每次排序使用间隔h的一组数组子序列进行插入排序，最后使用间隔为1进行插入排序
     *
     * @param arr
     * @author zhanghualei
     * @date 2021/2/15 11:13
     */
    public static void shellSort(int[] arr) {

        for (int h = (arr.length / 2); h > 0; h /= 2) {
            System.out.println(h + "~");
            for (int i = h; i < arr.length; i++) {
                //要插入的数
                int tmp = arr[i];
                int j = i;
                while (j - h >= 0 && tmp < arr[j - h]) {
                    arr[j] = arr[j - h];
                    j -= h;
                }
                if (i != j) {
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //要插入的数
            int tmp = arr[i];
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (i != j) {
                arr[j] = tmp;
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        boolean flag = false;
        for (int j = arr.length - 1; j > 0; j--) {
            if (findMax(arr, j, flag)) {
                System.out.println("循环结束！");
                break;
            }
        }
    }

    /**
     * 给定数组中 j位置之前的最大值放到j位置上
     *
     * @param
     * @author zhanghualei
     * @date 2021/2/12 21:29
     */
    private static boolean findMax(int[] arr, int j, boolean flag) {
        for (int i = 0; i < j; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            } else if (!flag && i == j - 1) {
                //如果没交换 说明已经有序 不再继续下去
                flag = true;
            }
        }
        return flag;
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minpos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minpos]) {
                    minpos = j;
                }
            }
            swap(arr, i, minpos);

            System.out.println("minpos: " + minpos);
            print(arr);
        }
    }

    private static void print(int[] arr) {
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        //交换
        // System.out.print(" swap i:" + i + " j:" + j);
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
