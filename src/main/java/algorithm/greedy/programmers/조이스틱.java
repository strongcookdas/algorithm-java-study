package algorithm.greedy.programmers;

public class 조이스틱{
    public int solution(String name) {
        int length = name.length();
        int moveCount = length - 1;

        int answer = 0;

        for (int i = 0; i < length; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            moveCount = Math.min(moveCount, i + length - next + Math.min(i, length - next));
        }

        return answer + moveCount;
    }

}