package algorithm.stack_queue.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<progresses.length; i++){
            int value = (int) Math.ceil((100.0-progresses[i])/speeds[i]);
            q.offer(value);
        }

        ArrayList<Integer> answerList = new ArrayList<>();
        while(!q.isEmpty()){
            int cnt = 1;
            int tmp = q.poll();
            while(!q.isEmpty() && tmp>=q.peek()){
                q.poll();
                cnt++;
            }
            answerList.add(cnt);
        }
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
