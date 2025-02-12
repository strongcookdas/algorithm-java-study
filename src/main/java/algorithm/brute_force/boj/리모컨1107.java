package algorithm.brute_force.boj;

import java.util.*;
import java.io.*;

public class 리모컨1107 {
    static boolean[] num = new boolean[10];
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int channel = sc.nextInt();
        int count = sc.nextInt();
        Arrays.fill(num, false);
        for(int i = 0; i<count; i++) {
            int n = sc.nextInt();
            num[n] = true;
        }

        int ans = Math.abs(channel-100);
        for(int i = 0; i<1000000; i++){
            if(!isBroken(i)){
                int press = Math.abs(channel-i);
                press += String.valueOf(i).length();
                ans = Math.min(ans, press);
            }
        }

        System.out.println(ans);
    }

    public static boolean isBroken(int n) {
        if(n==0){
            return num[0];
        }

        while(n>0){
            int tmp = n%10;
            if(num[tmp]){
                return true;
            }
            n=n/10;
        }

        return false;
    }
}
