package algorithm.binary_search.inflearn;

import java.util.*;

public class 뮤직비디오 {

    public static int count(int[] arr, int cap) {
        int sum = 0, count = 1;
        for(int num : arr){
            if(sum + num > cap){
                count ++;
                sum = num;
            }else sum += num;
        }
        return count;
    }

    public static int solution(int n, int m, int[] arr) {
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr,mid)<=m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.println(solution(n, m, arr));
    }
}
