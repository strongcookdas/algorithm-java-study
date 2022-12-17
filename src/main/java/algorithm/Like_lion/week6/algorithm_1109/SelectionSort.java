package algorithm.Like_lion.week6.algorithm_1109;

import java.util.Arrays;

public class SelectionSort {

    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int[] solution(int[] arr){
        int minidx;
        for (int i = 0; i < arr.length; i++) {
            minidx = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[j]<arr[minidx]){
                    minidx=j;
                }
            }
            swap(arr,i,minidx);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,7,4,9,10,223,111,23,3,39};
    }
}
