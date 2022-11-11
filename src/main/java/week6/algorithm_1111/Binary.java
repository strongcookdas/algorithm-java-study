package week6.algorithm_1111;

import java.util.Arrays;

/*
1. 2차원 배열을 1개 만든다
2. 매개변수로 넘어온 숫자열 배열의 수를 or 연산한다.
3. 연산한 결과가 1이면 벽 0이면 공백을 2차원 배열에 입력한다.
 */
public class Binary {
    public String solution(int num) {

        String answer = "";

        while(num>0){
            int result = num%2;
            answer = result + answer;
            num/=2;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 0;
        System.out.println(new Binary().solution(n));
    }
}
