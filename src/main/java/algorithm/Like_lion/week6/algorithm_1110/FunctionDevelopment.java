package algorithm.Like_lion.week6.algorithm_1110;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

        int preNum = -1;
        int idx = -1;
        int tmp = 0;

        for (int i = 0; i < progresses.length; i++) {

            tmp = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);

            if (preNum >= tmp) {
                list.set(idx, list.get(idx) + 1);
                continue;
            }

            preNum = tmp;
            list.add(1);
            idx++;
        }

        int[] ans = new int[list.size()];
        idx = 0;

        for (int num : list) {
            ans[idx++] = num;
        }

        return ans;
    }

    public static void main(String[] args) {
        FunctionDevelopment f = new FunctionDevelopment();
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speed = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(f.solution(progresses, speed)));
    }
}
