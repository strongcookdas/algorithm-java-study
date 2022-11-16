package week7.algorithm_1115;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    public List<Integer> merge(List<Integer> left, List<Integer> mid, List<Integer> right) {
        List<Integer> answer = new ArrayList<>();
        answer.addAll(left);
        answer.addAll(mid);
        answer.addAll(right);
        return answer;
    }

    public List<Integer> sort(List<Integer> arr) {
        if (arr.size() <= 1) return arr;

        int pivot = arr.get(arr.size() / 2);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < pivot) left.add(arr.get(i));
            else if (arr.get(i) > pivot) right.add(arr.get(i));
            else mid.add(arr.get(i));
        }

        return merge(sort(left), mid, sort(right));
    }

    public static void main(String[] args) {
        int[] arr = {20, 18, 5, 19, 5, 25, 40, 50};
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        QuickSort q = new QuickSort();
        System.out.println(q.sort(list));

    }
}
