package week7.algorithm_1117;

import week7.algorithm_1116.QuickSort2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort3 {
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] solution(int[] arr, int start, int end) {

        if (start >= end) return arr;

        int leftIdx = start;
        int rightIdx = end;

        int pivot = arr[(leftIdx + rightIdx) / 2];

        while (leftIdx <= rightIdx) {
            while (arr[leftIdx] < pivot) leftIdx++;
            while (arr[rightIdx] > pivot) rightIdx--;

            if (leftIdx <= rightIdx) {
                swap(arr, leftIdx, rightIdx);
                leftIdx++;
                rightIdx--;
            }
            //System.out.printf("%d %d\n", leftIdx, rightIdx);
        }

        System.out.println(Arrays.toString(arr));

        solution(arr, start, rightIdx);
        solution(arr, leftIdx, end);

        return arr;
    }

    public static void main(String[] args) {
        QuickSort3 q = new QuickSort3();
        int[] arr = {20, 18, 5, 19, 40, 50, 5, 25};
        int[] result = q.solution(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
