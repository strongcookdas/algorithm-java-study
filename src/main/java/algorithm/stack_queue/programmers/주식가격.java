package algorithm.stack_queue.programmers;

import java.util.*;

class 주식가격 {
    static class Price{
        int time;
        int price;
        public Price(int time, int price){
            this.time = time;
            this.price = price;
        }
    }
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Price> stack = new Stack<>();

        for(int time = prices.length; time>0; time--){
            int price = prices[time-1];
            while(!stack.isEmpty() && stack.peek().price>=price){
                stack.pop();
            }
            if(!stack.isEmpty()){
                answer[time-1] = stack.peek().time - time;
            }else{
                answer[time-1] = prices.length - time;
            }
            stack.push(new Price(time, price));
        }
        return answer;
    }
}