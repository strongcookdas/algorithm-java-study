package algorithm.bitmask.boj;

import java.util.*;
import java.io.*;

public class 부분수열의합14225 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int bit = 1<<n;
        ArrayList<Integer> sumList = new ArrayList<>();

        for(int i = 1; i<bit; i++){
            int sum = 0;
            for(int j=0; j<n; j++){
                if((i&(1<<j))!=0){
                    sum+=nums[j];
                }
            }
            sumList.add(sum);
        }

        Collections.sort(sumList);
        int answer = 1;
        for(int s : sumList){
            if(answer==s){
                answer=s+1;
            }
        }

        System.out.println(answer);
    }
}
