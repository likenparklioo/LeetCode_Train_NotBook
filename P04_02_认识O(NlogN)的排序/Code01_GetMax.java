// Title: 递归求最大值
public class Code01_GetMax {
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    // arr[L..R]范围上求最大值
    public static int process(int[] arr, int L, int R) {
        // Base case
        if (L == R) {
            return arr[L];
        }

        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);

        return Math.max(leftMax, rightMax);
    }
}
