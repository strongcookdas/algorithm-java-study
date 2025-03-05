package algorithm.brute_force.programmers;

import java.util.*;

public class 소수찾기 {
    boolean[] ch;
    boolean[] isPrime;
    char[] nums;
    StringBuilder sb = new StringBuilder();
    Set<Integer> set = new HashSet<>();
    int max = Integer.MIN_VALUE;

    public void dfs(){
        for(int i = 0; i<ch.length; i++){
            if(ch[i]){
                ch[i] = false;
                sb.append(nums[i]);
                int num = Integer.parseInt(sb.toString());
                set.add(num);
                max = Math.max(max,num);
                dfs();
                ch[i] = true;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public int solution(String numbers) {
        nums = numbers.toCharArray();
        ch = new boolean[numbers.length()];
        Arrays.fill(ch, true);
        dfs();
        isPrime = new boolean[max+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i<=max; i++){
            if(isPrime[i]){
                for(int j = i+i; j<=max; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        int answer = 0;
        for(int num : set){
            if(isPrime[num]){
                answer++;
            }
        }

        return answer;
    }
}
