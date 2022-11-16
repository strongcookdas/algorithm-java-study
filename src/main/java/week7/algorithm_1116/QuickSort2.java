package week7.algorithm_1116;

import java.util.Arrays;

public class QuickSort2 {

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] solution(int[] arr, int start, int end) {

        int pivot = (start + end) / 2;

        while (start < end) {
            if (arr[pivot] < arr[start] && arr[pivot] > arr[end])
                swap(arr, start, end);
            if (arr[start] < arr[pivot]) start++;
            if (arr[end] > arr[pivot]) end--;
            System.out.printf("%d %d\n", start, end);
            System.out.println(Arrays.toString(arr));
        }

        return arr;
    }

    public static void main(String[] args) {
        QuickSort2 q = new QuickSort2();
        int[] arr = {20, 18, 5, 19, 40, 50, 5, 25};
        System.out.println(Arrays.toString(q.solution(arr, 0, arr.length - 1)));
    }
}
