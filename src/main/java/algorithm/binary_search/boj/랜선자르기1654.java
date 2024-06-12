package algorithm.binary_search.boj;

import java.util.*;
public class 랜선자르기1654 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String[] inputs = kb.nextLine().split(" ");
        long[] arr = new long[Integer.parseInt(inputs[0])];
        int K = Integer.parseInt(inputs[1]);
        for (int i = 0; i < arr.length; i++) arr[i] = kb.nextLong();

        랜선자르기1654 main = new 랜선자르기1654();
        System.out.println(main.solution(arr, K));
    }

    private long solution(long[] arr, int k) {
        long answer = 0;
        long lt = 1, rt = Arrays.stream(arr).max().getAsLong();
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            if (countLine(arr, mid) >= k) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;
//            System.out.println(lt + " " + rt);
        }
        return answer;
    }

    private int countLine(long[] arr, long mid) {
        int count = 0;
        for (long num : arr) {
//            System.out.println(num / mid);
            count += (num / mid);
        }
//        System.out.println(mid + " " +count);
        return count;
    }
}
