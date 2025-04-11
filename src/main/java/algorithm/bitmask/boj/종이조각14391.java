package algorithm.bitmask.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 종이조각14391 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] arr = new int[r][c];
        for(int i = 0; i<r; i++){
            String inputs = br.readLine();
            for(int j = 0; j<c; j++){
                arr[i][j] = inputs.charAt(j)-'0';
            }
        }

        int bit = 1<<(r*c);
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i<bit; i++){
            int sum = 0;
            for(int j = 0; j<r; j++){
                int cur = 0;
                for(int k = 0; k<c; k++){
                    int idx = j*c+k;
                    if((i&(1<<idx))!=0){
                        cur = cur*10+arr[j][k];
                    }else{
                        sum+=cur;
                        cur=0;
                    }
                }
                sum+=cur;
            }

            for(int j = 0; j<c; j++){
                int cur = 0;
                for(int k = 0; k<r; k++){
                    int idx = c*k+j;
                    if((i&(1<<idx))==0){
                        cur = cur*10+arr[k][j];
                    }else{
                        sum+=cur;
                        cur=0;
                    }
                }
                sum+=cur;
            }
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}
