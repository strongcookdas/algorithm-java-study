package algorithm.array.inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class 뒤집은소수 {
    public static boolean isPrime(int num){
        if(num==1) return false;
        for(int i=2; i<num; i++){
            if(num%i==0) return false;
        }
        return true;
    }
    public static ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;
            while(tmp>0){
                res = res * 10 + (tmp%10);
                tmp /= 10;
            }
            if(isPrime(res)) answer.add(res);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (Integer i : solution(n,arr)) {
            System.out.print(i+" ");
        }
    }
}
