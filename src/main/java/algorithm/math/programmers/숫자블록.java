package algorithm.math.programmers;

public class 숫자블록 {
    public long[] solution(long begin, long end) {
        int memory = (int) (end - begin + 1);
        long[] answer = new long[memory];

        for (long i = begin; i <= end; i++) {
            int idx = (int) (i - begin);
            answer[idx] = block(i);
        }

        if (begin == 1) {
            answer[0] = 0;
        }
        return answer;
    }

    private long block(long n) {
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0 && n / i <= 10000000) {
                return n / i;
            }
        }

        for (long i = (long) Math.sqrt(n); i >= 2; i--) {
            if (n % i == 0 && i <= 10000000) {
                return i;
            }
        }
        return 1L;
    }
}
