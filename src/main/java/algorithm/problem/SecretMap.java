package algorithm.problem;

import java.util.Arrays;

/*
1. or 연산을 한다.
2. 연산 결과를 String으로 변환한다.
3. n-str만큼 0을 붙여주고 뒤에 이진수 연산결과를 이어준다.
4. 1은 #으로 0은 스페이스로 변환한다.
 */
public class SecretMap {// 프로그래머스 비밀지도

    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            String temp = Integer.toBinaryString(arr1[i] | arr2[i]);
            String str = "0".repeat(n - temp.length());
            str += temp;
            str = str.replace("0", " ");
            str = str.replace("1", "#");
            ans[i] = str;
        }
        return ans;
    }

    public static void main(String[] args) {
        SecretMap secretMap = new SecretMap();
        System.out.println(Arrays.toString(secretMap.solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10})));
    }
}
