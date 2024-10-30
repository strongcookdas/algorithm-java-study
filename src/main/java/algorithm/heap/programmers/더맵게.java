package algorithm.heap.programmers;

import java.util.*;

class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for(int n : scoville){
            pQ.offer(n);
        }
        while(pQ.peek() < K && pQ.size()>1 ){
            int s1 = pQ.poll();
            int s2 = pQ.poll() * 2;
            pQ.offer(s1+s2);
            answer++;
        }
        if(pQ.peek() >= K){
            return answer;
        }
        return -1;
    }
}