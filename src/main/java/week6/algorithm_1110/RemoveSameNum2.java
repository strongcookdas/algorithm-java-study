package week6.algorithm_1110;

import java.util.Arrays;
import java.util.Stack;

public class RemoveSameNum2 {
    public int[] solution(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (st.peek() != arr[i]) st.push(arr[i]);
        }
        int[] answer = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            answer[i] = st.pop();
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {4, 4, 4, 3, 3};
        System.out.println(Arrays.toString(new RemoveSameNum2().solution(arr)));
    }
}
