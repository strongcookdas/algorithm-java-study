package algorithm.brute_force.swea;

import java.util.Scanner;
public class View
{
    public static int solution(int[] arr){
        int answer = 0;
        for(int i = 2; i<arr.length-2; i++){
            int lh = Math.max(arr[i-1],arr[i-2]);
            int rh = Math.max(arr[i+1],arr[i+2]);
            int hc = Math.min(arr[i]-lh,arr[i]-rh);
            if(hc > 0 ) answer+= hc;
        }
        return answer;
    }
    public static void main(String args[]) throws Exception
    {
        Scanner kb = new Scanner(System.in);
        int T = 10;
        while(T>0){
            int n = kb.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i<n; i++){
                arr[i] = kb.nextInt();
            }
            System.out.println("#"+(10-T+1)+" "+solution(arr));
            T--;
        }
    }
}