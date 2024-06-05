package algorithm.hash.inflearn;

/**
 * 해시와 슬라이딩 윈도우 활용 (투 포인터)
 */

import java.util.*;

public class 매출액의종류 {
    int N,K;
    int[] arr;
    public void solution(){
        int lt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<N; i++){
            if(i<K){
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            }else{
                System.out.print(map.size()+" ");
                if(map.get(arr[lt])==1) map.remove(arr[lt++]);
                else map.put(arr[lt],map.get(arr[lt++])-1);
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            }
        }
        System.out.println(map.size());
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        매출액의종류 main = new 매출액의종류();
        main.N = kb.nextInt();
        main.K = kb.nextInt();
        main.arr = new int[main.N];
        for(int i = 0; i<main.N; i++)main.arr[i] = kb.nextInt();
        main.solution();
    }
}
