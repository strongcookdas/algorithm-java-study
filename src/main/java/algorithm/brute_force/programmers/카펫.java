package algorithm.brute_force.programmers;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        for (int i = 1; i * i <= yellow; i++) {
            if (yellow % i == 0 && (i + (yellow / i) + 2) * 2 == brown) {
                answer = new int[]{yellow / i + 2, i + 2};
                return answer;
            }
        }
        return answer;
    }
}