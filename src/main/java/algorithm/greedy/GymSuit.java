package algorithm.greedy;

import java.util.Arrays;

public class GymSuit {
    //프로그래머스 체육복 그리디
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int answer = n-lost.length;
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if(lost[i]==reserve[j]){
                    answer+=1;
                    lost[i]=-1;
                    reserve[j]=-1;
                }
            }
        }
        for (int i = 0; i < lost.length; i++) {
            if(lost[i]==-1) continue;
            for (int j = 0; j < reserve.length; j++) {
                if(reserve[j]==-1) continue;
                if(lost[i]-1==reserve[j]||lost[i]+1==reserve[j]){
                    answer+=1;
                    reserve[j]=-1;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new GymSuit().solution(5, new int[] {4,2}, new int[] {3,5}));
    }
}
