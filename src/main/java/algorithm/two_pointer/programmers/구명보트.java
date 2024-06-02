package algorithm.two_pointer.programmers;

import java.util.*;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        int lt = 0, rt = people.length-1,sum=0, answer = 0;
        Arrays.sort(people);
        while(lt<=rt){
            if(people[lt] + people[rt] <= limit){
                lt++;
                rt--;
            }else{
                rt--;
            }
            answer++;
        }
        return answer;
    }
}
