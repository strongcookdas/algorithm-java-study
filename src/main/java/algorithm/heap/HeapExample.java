package algorithm.heap;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HeapExample {

    public int[] solution(int[] arr, int rootIdx) {

        int leftIdx = 2 * rootIdx + 1;
        int rightIdx = 2 * rootIdx + 2;
        int tempIdx = rootIdx;

        if (arr.length > leftIdx && arr[leftIdx] > arr[tempIdx]) tempIdx = leftIdx;


        if (arr.length > rightIdx && arr[rightIdx] > arr[tempIdx]) tempIdx = rightIdx;

        int temp = arr[rootIdx];
        arr[rootIdx] = arr[tempIdx];
        arr[tempIdx] = temp;

        return arr;
    }

    public static void main(String[] args) {
        HeapExample heap = new HeapExample();
        int[] arr = new int[]{6, 5, 7, 8};

        arr = heap.solution(arr, 1);
        System.out.println(Arrays.toString(arr));

        arr = heap.solution(arr, 0);
        System.out.println(Arrays.toString(arr));
    }
}
