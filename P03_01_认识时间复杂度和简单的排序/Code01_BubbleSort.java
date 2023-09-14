package P03_01_认识时间复杂度和简单的排序;

public class Code01_BubbleSort {
    // 冒泡排序
    public int[] bubbleSort(int[] sourceArray) {
        int[] arr = sourceArray.clone();
        int len = arr.length;
        // 外层循环控制排序趟数
        for (int i = 0; i < len - 1; i++) {
            // 内层循环控制每一趟排序多少次
            for (int j = 0; j < len - 1 - i; j++) {
                // 比较相邻元素，如果前者大于后者，则交换位置
                if (arr[j] > arr[j + 1]) {
                    // 交换位置
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    // 交换位置
    public void swap(int[] arr, int i, int j) {
        // 交换位置
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        // 交换位置
        // arr[i] = arr[i] ^ arr[j];
        // arr[j] = arr[i] ^ arr[j];
        // arr[i] = arr[i] ^ arr[j];
    }
}
