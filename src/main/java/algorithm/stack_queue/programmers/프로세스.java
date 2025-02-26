package algorithm.stack_queue.programmers;

import java.util.*;

public class 프로세스 {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i<priorities.length; i++){
            q.offer(i);
            pQ.offer(priorities[i]);
        }

        int cnt = 1;
        while(q.peek()!=location || pQ.peek()!=priorities[q.peek()]){
            if(pQ.peek() == priorities[q.peek()]){
                cnt++;
                pQ.poll();
                q.poll();
            }else{
                q.offer(q.poll());
            }
        }

        return cnt;
    }
}
