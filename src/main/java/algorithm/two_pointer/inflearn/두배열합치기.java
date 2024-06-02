package algorithm.two_pointer.inflearn;

/*
- sort를 사용하지 않고 투 포인터로 O(n)으로 끝낸다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 두배열합치기 {
    int[] answer;
    public void solution(int[] arr1, int[] arr2){
        int t1 = 0, t2 = 0, idx = 0;
        answer = new int[arr1.length+arr2.length];
        while(t1 < arr1.length && t2 < arr2.length){
            if(arr1[t1]< arr2[t2]) answer[idx++] = arr1[t1++];
            else answer[idx++] = arr2[t2++];
        }
        while(t1<arr1.length) answer[idx++] = arr1[t1++];
        while(t2<arr2.length) answer[idx++] = arr2[t2++];
    }
    public static void main(String[] args) throws IOException {
        두배열합치기 main = new 두배열합치기();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr1[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) arr2[i] = Integer.parseInt(st.nextToken());

        main.solution(arr1, arr2);
        for(int n : main.answer) System.out.print(n+" ");
    }
}
