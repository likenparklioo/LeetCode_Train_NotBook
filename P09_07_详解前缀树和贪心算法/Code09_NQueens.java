package P09_07_详解前缀树和贪心算法;

public class Code09_NQueens {
    // 时间复杂度：O(N!)
    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        // record[i] -> i行的皇后，放在了第几列
        int[] record = new int[n];
        return process1(0, record, n);
    }

    // 潜台词：record[0..i-1]的皇后，任何两个皇后一定都不共行，不共列，不共斜线
    // i代表来到了第i行
    // record[0..i-1]表示之前的行，放了的皇后位置
    // n代表整体一共有多少行
    // 返回值是，摆完所有的皇后，合理的摆法有多少种
    // 深度优先遍历
    public static int process1(int i, int[] record, int n) {
        if (i == n) { // 终止行，来到了第n行
            return 1;
        }
        int res = 0;
        // i行的皇后，放在了第j列
        for (int j = 0; j < n; j++) { // 当前行在i行，尝试i行的每一列j
            // i行的皇后，放在了第j列，会不会和之前的皇后，共行，共列，共斜线
            // 如果是，认为无效
            // 如果不是，认为有效
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    // record[0..i-1]需要看，record[i...]不需要看
    // 返回i行皇后，放在了j列，是否有效
    public static boolean isValid(int record[], int i, int j) {
        // 之前的行，之前的皇后
        for (int k = 0; k < i; k++) {
            // 第k行的皇后，是否和i行j列的皇后，共行，共列，共斜线
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    // 请不要超过32皇后问题（常数项优化）
    public static int num2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }

        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }

    // colLim 列的限制，1的位置不能放皇后，0的位置可以
    // leftDiaLim 左斜线的限制，1的位置不能放皇后，0的位置可以
    // rightDiaLim 右斜线的限制，1的位置不能放皇后，0的位置可以
    public static int process2(int limit, int colLimit, int leftDiaLim, int rightDiaLim) {
        if (colLimit == limit) { // base case
            return 1;
        }
        // 所有可以放皇后的位置，都在pos上
        // colLimit | leftDiaLim | rightDiaLim -> 总限制
        // ~ (colLimit | leftDiaLim | rightDiaLim) -> 左侧的一坨0，右侧的一坨1
        // limit & (~ (colLimit | leftDiaLim | rightDiaLim)) -> 所有可以放皇后的位置，都在pos上
        int pos = limit & (~(colLimit | leftDiaLim | rightDiaLim));
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0) {
            // 取出pos中，最右侧的1来，剩下的位置都是0
            mostRightOne = pos & (~pos + 1);
            // pos ^ mostRightOne -> 去掉最右侧的1，剩下的位置都是1
            pos = pos - mostRightOne;
            res += process2(limit, colLimit | mostRightOne, (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }
}
