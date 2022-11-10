package week6.algorithm_1110;

import java.util.Arrays;

public class RemoveSameNum {
    public int[] solution(int[] arr) {
        int tmp = -1;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i] != tmp) {
                tmp = arr[i];
            } else if (arr[i] == tmp) {
                arr[i] = -1;
                cnt++;
            }
        }

        int[] ans = new int[arr.length - cnt];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                ans[idx++] = arr[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 4, 4, 3, 3};
        System.out.println(Arrays.toString(new RemoveSameNum().solution(arr)));
    }
}
