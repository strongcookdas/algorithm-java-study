package algorithm.stack_queue.programmers;

import java.util.*;

class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();

        int totalWeight = 0;
        int answer = 0;

        for(int t : truck_weights){
            while(true){
                if(q.size()==bridge_length){
                    totalWeight-=q.poll();
                }

                answer++;
                if(t+totalWeight > weight){
                    q.offer(0);
                }else{
                    q.offer(t);
                    totalWeight+=t;
                    break;
                }
            }
        }

        return answer+bridge_length;
    }
}
