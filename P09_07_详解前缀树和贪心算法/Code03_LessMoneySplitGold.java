package P09_07_详解前缀树和贪心算法;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code03_LessMoneySplitGold {
    // 哈夫曼编码问题
    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }

    public static class MinheapComparator implements Comparator<Integer> {
         public int compare(Integer o1, Integer o2) {
            return o1 - o2;
         }
    }
}
