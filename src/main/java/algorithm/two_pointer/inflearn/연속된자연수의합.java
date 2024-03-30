package algorithm.two_pointer.inflearn;

import java.util.*;
public class 연속된자연수의합 {
    public static int solution(int n){
        int answer = 0;
        int sum = 0;
        int lt = 1, rt = 1;
        while(lt+rt<=(n+1)){
            if(sum == n){
                answer++;
                sum-=(lt++);
            }else if(sum > n) sum -= lt++;
            else sum+=rt++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextInt()));
    }
}
