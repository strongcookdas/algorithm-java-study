package algorithm.math.boj;

import java.util.*;
public class 지능형기차2 {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int N = 10;
        int count = 0;
        int max = 0;
        for(int i = 0; i<N; i++){
            int down = kb.nextInt();
            int up = kb.nextInt();
            count -= down;
            count += up;
            if(count>max) max = count;
        }
        System.out.println(max);
    }
}
