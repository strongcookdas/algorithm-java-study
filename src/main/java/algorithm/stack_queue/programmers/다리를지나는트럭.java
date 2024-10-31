package algorithm.stack_queue.programmers;

import java.util.*;

class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totalWeight = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int truck : truck_weights){
            while(true){
                if(q.size() == bridge_length){
                    totalWeight -= q.poll();
                }

                if(totalWeight + truck > weight){
                    q.offer(0);
                    answer++;
                }else{
                    q.offer(truck);
                    totalWeight += truck;
                    answer++;
                    break;
                }
            }
        }
        return answer+bridge_length;
    }
}
