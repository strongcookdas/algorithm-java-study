package algorithm.Like_lion.week9.algorithm_1129;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class RadixSort2 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 8, 18, 13, 1, 7, 16, 9, 0, 14};

        Queue<Integer>[] queueArr = new Queue[10];
        for (int i = 0; i < queueArr.length; i++) {
            queueArr[i] = new ArrayDeque<>();
        }

        for (int i :
                arr) {
            queueArr[i % 10].add(i);
        }

        int idx = 0;
        for (int i = 0; i < queueArr.length; i++) {
            while (!queueArr[i].isEmpty()) {
                arr[idx++] = queueArr[i].poll();
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
