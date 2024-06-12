package algorithm.binary_search.programmers;

import java.util.*;

public class 입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long lt = 1, rt = (long) times[times.length - 1] * n;
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            if (countUser(times, mid) >= n) {
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }
        return answer;
    }

    private long countUser(int[] times, long mid) {
        long count = 0;
        for (int time : times) {
            count += (mid / time);
        }
        return count;
    }
}
