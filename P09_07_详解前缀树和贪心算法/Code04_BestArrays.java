package P09_07_详解前缀树和贪心算法;

import java.util.Comparator;

public class Code04_BestArrays {
    public static class Programe {
        public int start;
        public int end;

        public Programe(int s, int e) {
            start = s;
            end = e;
        }
    }
    
    public static class ProgrameComparator implements Comparator<Programe> {
        @Override
        public int compare(Programe o1, Programe o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(Programe[] pros, int start) {
        if (pros == null || pros.length == 0) {
            return 0;
        }
        int result = 0;
        // 从左往右依次遍历每一个会议
        for (int i = 0; i < pros.length; i++) {
            if (start <= pros[i].start) {
                result++;
                start = pros[i].end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
