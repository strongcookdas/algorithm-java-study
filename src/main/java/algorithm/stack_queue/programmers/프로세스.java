package algorithm.stack_queue.programmers;

import java.util.*;

public class 프로세스 {
    public int solution(int[] priorities, int location) {

        List<Integer> sortedPriorities = new ArrayList<>();
        for (int priority : priorities) {
            sortedPriorities.add(priority);
        }
        sortedPriorities.sort(Collections.reverseOrder());

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i<priorities.length; i++){
            q.offer(new int[]{i,priorities[i]});
        }

        int cnt = 0;
        int idx = 0;

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            if(tmp[1] == sortedPriorities.get(idx)){
                cnt++;
                idx++;
                if(tmp[0] == location){
                    return cnt;
                }
            }else{
                q.offer(tmp);
            }
        }

        return cnt;
    }
}
