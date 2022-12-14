package algorithm.sort;


import java.util.Arrays;

public class RemoveMin {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};

        int[] ans = new int[arr.length - 1];
        int[] temp = arr.clone();
        Arrays.sort(temp);
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == temp[0]) continue;
            ans[idx++] = arr[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        RemoveMin removeMin = new RemoveMin();
        System.out.println(Arrays.toString(removeMin.solution(new int[]{4, 3, 2, 1})));
    }
}
