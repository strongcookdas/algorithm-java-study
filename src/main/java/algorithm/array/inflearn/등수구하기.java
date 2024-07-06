package algorithm.array.inflearn;

import java.util.*;

public class 등수구하기 {
    public static int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arrCopy = arr.clone();
        Arrays.sort(arrCopy);
        int count = 1;
        int before = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arrCopy[i] != before) {
                before = arrCopy[i];
                map.put(arrCopy[i], count);
            }
            count++;
        }

        for (int i = 0; i < arr.length; i++) {
            answer[i] = map.get(arr[i]);
        }
        return answer;
    }

    public static void main(String[] argus) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int tmp : solution(arr)) {
            System.out.print(tmp + " ");
        }
    }

}
