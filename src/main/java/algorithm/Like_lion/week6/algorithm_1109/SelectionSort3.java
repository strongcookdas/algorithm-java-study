package algorithm.Like_lion.week6.algorithm_1109;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class SelectionSort3 {

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int[] solution(int[] arr, BiPredicate<Integer,Integer> stmt) {
        int minidx;
        for (int i = 0; i < arr.length; i++) {
            minidx = i;
            for (int j = i; j < arr.length; j++) {
                if (stmt.test(arr[minidx], arr[j])) {
                    minidx = j;
                }
            }
            swap(arr, i, minidx);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void main(String[] args) {
        SelectionSort3 selectionSort = new SelectionSort3();
        int[] arr = new int[]{2, 7, 4, 9, 10, 223, 111, 23, 3, 39};
        System.out.println("내림차순");
        selectionSort.solution(arr,(a,b)->a<b);
        System.out.println("오름차순");
        selectionSort.solution(arr,(a,b)->b<a);
    }
}
