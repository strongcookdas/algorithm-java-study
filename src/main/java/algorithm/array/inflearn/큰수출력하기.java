package algorithm.array.inflearn;

import java.util.*;

public class 큰수출력하기 {
    static int[] arr;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = kb.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if (i == 0 || arr[i] > arr[i - 1]) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
