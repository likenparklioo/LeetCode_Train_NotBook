package P09_07_详解前缀树和贪心算法;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code05_IPO {
    public static class Node {
        public int p;
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());

        //所有项目扔到被锁的堆里，花费组织的小根堆
        for (int i = 0; i < Profits.length; i++) {
            minCostQ.add(new Node(Profits[i], Capital[i]));
        }
        for (int i = 0; i < k; i++) { // 进行k次项目选择
            // 能力所能及的项目，全解锁
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
                maxProfitQ.add(minCostQ.poll());
            }
            // 提前返回的情况
            if (maxProfitQ.isEmpty()) {
                return W;
            }
            W += maxProfitQ.poll().p;
        }
        return W;
    }
}
