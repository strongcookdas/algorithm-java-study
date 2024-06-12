package algorithm.set.boj;

import java.util.*;
import java.io.*;
public class 수찾기1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        수찾기1920 main = new 수찾기1920();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<N; i++) set.add(Integer.parseInt(st.nextToken()));

        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++) arr[i] = Integer.parseInt(st.nextToken());
        List<Integer> answer = main.solution(set, arr);
        for(int n : answer) bw.write(n+"\n");
        bw.flush();

    }

    private List<Integer> solution(HashSet<Integer> set, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        for(int num : arr){
            if(set.contains(num)) answer.add(1);
            else answer.add(0);
        }
        return answer;
    }
}
