package P03_01_认识时间复杂度和简单的排序;

public class Code02_OddTimesNum {
    // arr中，只有一种数，出现奇数次
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        System.out.println(eor);
    }

    // arr中，有两种数，出现奇数次
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }

        // eor = a ^ b
        // eor != 0
        // eor必然有一个位置上是1

        // 提取出最右的1
        int rightOne = eor & (~eor + 1); // 提取出最右的1

        int onlyOne = 0; // eor'

        for (int cur : arr) {
            // arr[1] arr[2] arr[1001] arr[1002]
            // 1) cur & rightOne != 0
            // 2) cur & rightOne == 0
            if ((cur & rightOne) != 0) {
                onlyOne ^= cur;
            }
        }

        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }
}
