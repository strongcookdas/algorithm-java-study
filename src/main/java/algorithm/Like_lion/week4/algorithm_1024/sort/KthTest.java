package algorithm.Like_lion.week4.algorithm_1024.sort;

import java.util.Arrays;

public class KthTest {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;

        for (int[] command : commands) {
            int[] tmp = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(tmp);
            answer[idx++] = tmp[command[2] - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        KthTest k = new KthTest();

        int[] ans = k.solution(arr, commands);
        System.out.println(Arrays.toString(ans));
    }
}
