package algorithm.math.boj;

import java.util.*;
public class 최대최소10818 {
    public static void solution(ArrayList<Integer> list){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int n : list){
            if(n>max) max = n;
            if(n<min) min = n;
        }
        System.out.println(min+" "+max);
    }
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = kb.nextInt();
        for(int i = 0; i<n; i++){
            list.add(kb.nextInt());
        }
        solution(list);
    }
}
