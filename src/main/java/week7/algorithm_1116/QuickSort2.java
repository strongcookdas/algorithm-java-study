package week7.algorithm_1116;

import java.util.Arrays;

public class QuickSort2 {

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void solution(int[] arr, int start, int end) {
        if (start == end) return;

        int pivot = arr[arr.length / 2];

        while (start <= end) {
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            //start보다 end가 작은 상황일 때 교환할 경우는 없다.
            //pivot에서 start와 end가 모이는 구조이기 때문이다.
            //교환이 다 이루어진 이후의 start와 end는 pivot을 가리키고 있을 것이다.
            swap(arr, start, end);
            start++;
            end--;

            System.out.printf(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        QuickSort2 q = new QuickSort2();
        int[] arr = {20, 18, 5, 19, 40, 50, 5, 25};
        q.solution(arr, 0, arr.length - 1);
    }
}
