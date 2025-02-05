package algorithm.math.boj;

import java.io.*;
import java.util.ArrayList;

public class 약수의합17425 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            if(n>max) max = n;
            list.add(n);
        }

        long[] arr = new long[max+1];
        for(int i = 1; i<=max; i++){
            arr[i] += arr[i-1];
            arr[i] += i;
            for(int j = i+i; j<=max; j+=i){
                arr[j] += i;
            }
        }

        for(int input : list){
            bw.write(arr[input]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
