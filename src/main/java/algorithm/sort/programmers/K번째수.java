package algorithm.sort.programmers;

import java.util.*;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int idx = 0;
        int[] answer = new int[commands.length];
        for(int[] command : commands){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = command[0]-1; i<command[1]; i++){
                list.add(array[i]);
            }
            Collections.sort(list);
            answer[idx++] = list.get(command[2]-1);
        }
        return answer;
    }
}
