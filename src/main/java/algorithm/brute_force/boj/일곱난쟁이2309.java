package algorithm.brute_force.boj;

import java.util.*;
public class 일곱난쟁이2309 {

    public static ArrayList<Integer> solution(int n, ArrayList<Integer> list){
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                int sum = 0;
                for(int z = 0; z<n; z++){
                    if(z==i||z==j) continue;
                    sum+=list.get(z);
                }
                if(sum==100){
                    list.remove(j);
                    list.remove(i);
                    Collections.sort(list);
                    return list;
                }
            }
        }
        return list;
    }
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int N = 9;
        for(int i = 0; i<N; i++){
            list.add(kb.nextInt());
        }
        for(int n : solution(N,list)){
            System.out.println(n);
        }
    }
}
