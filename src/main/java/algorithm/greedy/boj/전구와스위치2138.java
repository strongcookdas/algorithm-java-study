package algorithm.greedy.boj;

import java.util.*;

public class 전구와스위치2138 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        kb.nextLine();
        String input = kb.nextLine();
        String output = kb.nextLine();

        전구와스위치2138 main = new 전구와스위치2138();
        System.out.println(main.solution(input, output));
    }

    private int solution(String input, String output) {
        int case1 = countSwitchToggle(input.toCharArray(), output, true);
        int case2 = countSwitchToggle(input.toCharArray(), output, false);
        if (case1 == -1 && case2 == -1) {
            return -1;
        } else if (case1 == -1) {
            return case2;
        } else if (case2 == -1) {
            return case1;
        } else {
            return Math.min(case1, case2);
        }
    }

    public int countSwitchToggle(char[] inputArr, String output, boolean firstSwitch) {
        int count = 0;
        if (firstSwitch) {
            toggle(inputArr, 0);
            count++;
        }

        for (int i = 1; i < inputArr.length; i++) {
            if (inputArr[i - 1] != output.charAt(i - 1)) {
                toggle(inputArr, i);
                count++;
            }
        }

        if (String.valueOf(inputArr).equals(output)) {
            return count;
        }
        return -1;
    }

    public void toggle(char[] inputArr, int index) {
        for (int i = index - 1; i <= index + 1; i++) {
            if (i >= 0 && i < inputArr.length) {
                inputArr[i] = (inputArr[i] == '0') ? '1' : '0';
            }
        }
    }
}
