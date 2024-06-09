package algorithm.stack_queue.programmers;

import java.util.*;

public class 프로세스 {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i<priorities.length; i++){
            pQ.offer(priorities[i]);
            q.offer(i);
        }

        int count = 1;
        while(q.peek()!=location || pQ.peek()!=priorities[location]){
            if(priorities[q.peek()]==pQ.peek()){
                q.poll();
                pQ.poll();
                count++;
            }else q.offer(q.poll());
        }
        return count;
    }
}
