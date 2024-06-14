package algorithm.two_pointer.boj;

import java.util.*;

public class 소수의연속합1644 {
    int[] arr;
    public int solution(int N){
        arr = new int[N+1];
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 2; i<=N; i++){
            if(arr[i]!=0) continue;
            list.add(i);
            for(int j = i*2; j<=N; j+=i) arr[j] = 1;
        }

        int lt = 0, count = 0, sum = 0;
        for(int rt = 0; rt<list.size(); rt++){
            if(sum<N) sum+=list.get(rt);
            while(sum>=N){
                if(sum==N) count++;
                sum-=list.get(lt++);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N =kb.nextInt();
        소수의연속합1644 main = new 소수의연속합1644();
        System.out.println(main.solution(N));
    }
}
