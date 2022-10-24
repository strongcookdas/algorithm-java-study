package week4.algorithm_1024.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthTest2 {
    //우선순위 큐
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;

        for (int[] command : commands) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i = command[0]-1; i< command[1]; i++){
                pq.add(array[i]);
            }

            int result = 0;
            for(int i = 0;i<command[2];i++){
                result=pq.poll();
            }

            answer[idx++] = result;
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
