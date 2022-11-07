package week6.algorithm_1107;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DivisibleNumber {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int num:arr) {
            if(num%divisor==0)
                ans.add(num);
        }
        if(ans.size()==0){
            int[] answer ={-1};
            return answer;
        }
        Collections.sort(ans);
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i]=ans.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        DivisibleNumber d = new DivisibleNumber();
        int[] arr = {5,9,7,10};
        int divisor = 5;
        System.out.println(Arrays.toString(d.solution(arr,divisor)));
    }
}
