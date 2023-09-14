package P03_01_认识时间复杂度和简单的排序;

public class Code04_BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int L = 0;
        int R = arr.length - 1;
        int mid = 0;
        while (L <= R) {
            // mid = (L + R) / 2;
            // mid = L + (R - L) / 2;
            mid = L + ((R - L) >> 1);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) { // 左边
                R = mid - 1;
            } else { // 右边
                L = mid + 1;
            }
        }
        return -1;        
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
