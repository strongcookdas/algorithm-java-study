package algorithm.bruteForceSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
프로그래머스 모의고사
1. 학생들의 정답 패턴을 배열로 저장한다.
2. 문제 정답과 정답 패턴을 비교한다.
3. 맞춘 문제의 최댓값을 구한다.
4. 최댓값과 비교하여 많이 맞춘 학생을 배열에 추가한다.
 */
public class MockExam {
    public int[] solution(int[] arr) {
        int[] student1 = new int[]{1, 2, 3, 4, 5};
        int[] student2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] cnt = new int[3];
        List<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (student1[i % student1.length] == arr[i]) cnt[0]++;
            if (student2[i % student2.length] == arr[i]) cnt[1]++;
            if (student3[i % student3.length] == arr[i]) cnt[2]++;
        }
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        for (int i = 0; i < cnt.length; i++) {
            if (max == cnt[i]) tmp.add(i + 1);
        }

        int[] ans = new int[tmp.size()];
        int idx = 0;
        for (int num : tmp) {
            ans[idx++] = num;
        }

        return ans;
    }

    public static void main(String[] args) {
        MockExam mockExam = new MockExam();
        System.out.println(Arrays.toString(mockExam.solution(new int[]{1,2,3,4,5})));
    }
}
