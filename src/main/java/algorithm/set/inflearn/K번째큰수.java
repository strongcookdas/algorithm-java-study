package algorithm.set.inflearn;

import java.util.*;

public class K번째큰수 { // 다시 풀기
    public int solution(int N, int K, int[] arr){
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for(int i = 0; i<N; i++){
            for(int j = i+1; j<N; j++){
                for(int k = j+1; k<N; k++){
                    set.add(arr[i]+arr[j]+arr[k]);
                }
            }
        }
        int count = 1;
        for(int num : set){
            if(count==K) return num;
            count++;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        K번째큰수 main = new K번째큰수();
        int N = kb.nextInt();
        int K = kb.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i<N; i++) arr[i] = kb.nextInt();
        System.out.println(main.solution(N,K,arr));;
    }
}
