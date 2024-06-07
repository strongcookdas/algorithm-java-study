package algorithm.dfs.boj;

/**
 * 조합 구하는 방식으로 해결
 * 과정
 * 팀 구성의 모든 경우의 수 확인
 * 
 * 오래 걸린 원인
 * DFS 매개변수 n에 i+1이 아닌 n+1로 넘김
 */

import java.util.*;
import java.io.*;

public class 스타트와링크14889 {
    int[][] arr;
    int[] ch;
    public int DFS(int L, int n) {
        int answer = Integer.MAX_VALUE;
        if (L == arr.length / 2) {
            int t1 = 0, t2 = 0;
            for(int i = 0; i< ch.length; i++){
                for(int j = 0; j<ch.length; j++){
                    if(ch[i]==1 && ch[j]==1) t1 += arr[i][j];
                    if(ch[i]==0 && ch[j]==0) t2 += arr[i][j];
                }
            }
            return Math.abs(t1-t2);
        }else{
            for(int i = n; i<arr.length; i++){
                ch[i] = 1;
                answer = Math.min(answer,DFS(L+1,i+1));
                ch[i] = 0;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        스타트와링크14889 main = new 스타트와링크14889();
        main.arr = new int[N][N];
        main.ch = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                main.arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(main.DFS(0, 0));
    }
}
