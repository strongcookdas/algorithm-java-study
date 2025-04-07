package algorithm.bitmask.boj;

import java.util.*;
import java.io.*;

public class 스타트와링크14889 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int i = 1; i<(1<<n); i++){
            if(Integer.bitCount(i) != n/2) continue;

            List<Integer> s = new ArrayList<>();
            List<Integer> l = new ArrayList<>();

            for(int j = 0; j<n; j++){
                if((i & (1<<j)) != 0){
                    s.add(j);
                }else{
                    l.add(j);
                }
            }

            int sNum = getNum(s, arr);
            int lNum = getNum(l, arr);

            answer = Math.min(answer, Math.abs(sNum-lNum));
        }

        System.out.println(answer);
    }

    public static int getNum(List<Integer> team, int[][] arr){
        int num = 0;
        for(int i = 0; i<team.size(); i++){
            for(int j = i+1; j<team.size(); j++){
                int a = team.get(i);
                int b = team.get(j);
                num+=arr[a][b];
                num+=arr[b][a];
            }
        }
        return num;
    }
}
