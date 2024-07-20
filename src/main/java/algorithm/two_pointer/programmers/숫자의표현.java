package algorithm.two_pointer.programmers;

public class 숫자의표현 {
    public int solution(int n) {
        int answer = 0;
        int lt = 0;
        int sum = 0;
        for (int rt = 1; rt <= n; rt++) {
            sum += rt;
            if (sum == n) {
                answer++;
            }
            while (sum > n) {
                ++lt;
                sum -= lt;
                if (sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
