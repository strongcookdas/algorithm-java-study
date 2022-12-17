package algorithm.problem.prime;

import java.util.Arrays;

public class Eratosthene {//에라토스테네스의 체

    public int solution(int N) {
        boolean nums[] = new boolean[N + 1];
        Arrays.fill(nums, true);
        for (int i = 2; i * i <= N; i++) {
            for (int j = i + i; j <= N; j += i) {
                nums[j] = false;
            }
        }

        int cnt = 0;
        for (int i = 2; i < N + 1; i++) {
            if (nums[i] == true)
                cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        Eratosthene e = new Eratosthene();
        System.out.println(e.solution(5));
    }
}
