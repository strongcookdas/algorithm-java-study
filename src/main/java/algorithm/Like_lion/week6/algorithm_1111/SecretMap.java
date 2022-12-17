package algorithm.Like_lion.week6.algorithm_1111;

import java.util.Arrays;

/*
1. 2차원 배열을 1개 만든다
2. 매개변수로 넘어온 숫자열 배열의 수를 or 연산한다.
3. 연산한 결과가 1이면 벽 0이면 공백을 2차원 배열에 입력한다.
 */
public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String str = Integer.toBinaryString(arr1[i] | arr2[i]);
            int cnt = n - str.length();
            for (int j = 0; j < cnt; j++) {
                str = "0" + str;
            }
            str = str.replace("1", "#");
            str = str.replace("0", " ");
            answer[i] = str;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = {46, 33, 33, 22, 31, 1};
        int[] arr2 = {27, 56, 19, 14, 14, 1};

        System.out.println(Arrays.toString(new SecretMap().solution(n, arr1, arr2)));

    }
}
