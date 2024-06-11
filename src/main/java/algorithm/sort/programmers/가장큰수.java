package algorithm.sort.programmers;

import java.util.*;

public class 가장큰수 {
    public String solution(int[] numbers) {
        String answer = "";
        Integer[] nums = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        Arrays.sort(nums, (a, b) -> {
            String order1 = String.valueOf(a) + String.valueOf(b);
            String order2 = String.valueOf(b) + String.valueOf(a);
            return order2.compareTo(order1);
        });

        if (nums[0] == 0) {
            return "0";
        }

        for(int number : nums) answer += String.valueOf(number);
        return answer;
    }
}