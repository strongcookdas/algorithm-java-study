package algorithm.greedy.inflearn;

// 회의가 빨리 끝나는 순으로 정렬
// 같다면 회의가 빨리 시작하는 순으로 정렬
// 끝나는 시간과 다음 회의 시작시간 비교, 카운트

import java.util.*;

public class 회의실 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int[][] arr = new int[N][2];
        for(int i = 0; i<N; i++){
            arr[i][0] = kb.nextInt();
            arr[i][1] = kb.nextInt();
        }

        회의실 main = new 회의실();
        System.out.println(main.solution(arr));
    }

    private int solution(int[][] arr) {
        int count = 0;
        Arrays.sort(arr, (a,b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int endTime = -1;

        for(int[] time : arr){
            if(time[0] >= endTime){
                count++;
                endTime = time[1];
            }
        }

        return count;
    }
}
