public class Code04_QuickSort {
    public static void main(String[] args) {
        
    }

    public static void quickSort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        
        if (L < R) {
            swap(arr, L + (int) Math.random() * (R - L + 1), R); // 这里需要+1吗？

            int[] p = partation(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
        
    }

    public static int[] partation(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;

        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }

        swap(arr, more, R);
        return new int[] {less + 1, more};
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
