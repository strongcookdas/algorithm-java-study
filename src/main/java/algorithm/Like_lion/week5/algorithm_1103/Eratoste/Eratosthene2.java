package algorithm.Like_lion.week5.algorithm_1103.Eratoste;

import java.util.Arrays;

public class Eratosthene2 {

    public int solution(int N){
        boolean nums[] = new boolean[N+1];
        Arrays.fill(nums,true);
        for (int i = 2; i*i <= N ; i++) {
            for (int j = i+i; j <= N; j+=i) {
                nums[j]=false;
            }
        }

        int cnt =0;
        for (int i = 2; i < N+1; i++) {
            if(nums[i]==true)
                cnt++;
        }

        return cnt;
    }
    public static void main(String[] args) {
        Eratosthene2 e = new Eratosthene2();
        System.out.println(e.solution(5));
    }
}
