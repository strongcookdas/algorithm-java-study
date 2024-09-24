package algorithm.greedy.boj;

import java.util.*;

public class 단어수학1339 {

    int[] cost;
    int[] nums;
    Integer[] alpha;


    public 단어수학1339() {
        this.cost = new int[26];
        this.nums = new int[26];
        this.alpha = new Integer[26];
        for (int i = 0; i < 26; i++) {
            this.alpha[i] = i;
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int N = kb.nextInt();
        kb.nextLine();

        단어수학1339 main = new 단어수학1339();

        ArrayList<String> inputList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String input = kb.nextLine();
            inputList.add(input);
        }

        System.out.println(main.solution(inputList));
    }

    private int solution(ArrayList<String> inputList) {
        for (String input : inputList) {
            for (int i = 0; i < input.length(); i++) {
                char w = input.charAt(i);
                int idx = w - 'A';
                this.cost[idx] += (int) Math.pow(10, input.length() - i - 1);
            }
        }

        Arrays.sort(alpha, (a, b) -> cost[b] - cost[a]);

        int[] nums = new int[26];
        int num = 9;
        for (int a : this.alpha) {
            nums[a] = num--;
        }

        int sum = 0;
        int tmp = 0;
        for (String input : inputList) {
            for (int i = 0; i < input.length(); i++) {
                int idx = input.charAt(i) - 'A';
                tmp *= 10;
                tmp += nums[idx];
            }
            sum += tmp;
            tmp = 0;
        }
        return sum;
    }
}
