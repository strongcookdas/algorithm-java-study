package algorithm.stack_queue.programmers;

import java.util.*;

class 주식가격 {
    public int[] solution(int[] prices) {
        Stack<int[]> stack = new Stack<>();
        int n = prices.length;
        int[] answer = new int[n];

        for(int i = 0; i<n; i++){
            while(!stack.isEmpty() && prices[i] < stack.peek()[1]){
                int[] prev = stack.pop();
                answer[prev[0]] = i-prev[0];
            }

            stack.push(new int[]{i,prices[i]});
        }

        while(!stack.isEmpty()){
            int[] prev = stack.pop();
            answer[prev[0]] = n - prev[0] -1;
        }

        return answer;
    }
}