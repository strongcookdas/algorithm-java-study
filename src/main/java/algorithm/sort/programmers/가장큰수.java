package algorithm.sort.programmers;

import java.util.*;

public class 가장큰수 {
    public String solution(int[] numbers) {
        String[] numStrs = new String[numbers.length];
        for(int i = 0; i<numbers.length; i++){
            numStrs[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numStrs, (a,b) -> {
            String str1 = String.valueOf(a) + String.valueOf(b);
            String str2 = String.valueOf(b) + String.valueOf(a);
            return str2.compareTo(str1);
        });

        if(Integer.valueOf(numStrs[0])==0){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String num : numStrs){
            sb.append(num);
        }

        return sb.toString();
    }
}