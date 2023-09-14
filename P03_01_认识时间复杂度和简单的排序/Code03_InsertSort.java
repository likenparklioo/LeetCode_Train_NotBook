package P03_01_认识时间复杂度和简单的排序;

public class Code03_InsertSort {
    public static int[] insertSort(int[] arr) {
        int[] res = arr.clone();
        for (int i = 1; i < res.length; i++) {
            for (int j = i - 1; j >= 0 && res[j] > res[j + 1]; j--) {
                swap(res, j, j + 1);
            }
        }
        return res;
    }

    public static void swap(int[] arr, int i, int j) {
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
