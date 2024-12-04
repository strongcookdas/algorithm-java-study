package algorithm.math.programmers;

import java.util.*;

class 약수의개수와덧셈 {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left ; i<=right ;i++){
            int sqrt = (int)Math.sqrt(i);
            if(Math.pow(sqrt,2)==i){
                answer-=i;
            }else{
                answer+=i;
            }
        }
        return answer;
    }
}
