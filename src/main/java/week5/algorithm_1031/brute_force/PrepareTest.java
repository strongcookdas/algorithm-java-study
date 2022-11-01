package week5.algorithm_1031.brute_force;

import java.util.ArrayList;
import java.util.Arrays;

public class PrepareTest {
    public int[] solution(int[] problem){
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        int[] cnt = {0,0,0};
        ArrayList<Integer> ans = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < problem.length; i++) {
            if(student1[i%student1.length]==problem[i]) cnt[0]++;
            if(student2[i%student2.length]==problem[i]) cnt[1]++;
            if(student3[i%student3.length]==problem[i]) cnt[2]++;
        }

        for (int i = 0; i < cnt.length; i++) {
            if(cnt[i]>max){
                max=cnt[i];
            }
        }

        for (int i = 0; i < cnt.length; i++) {
            if(cnt[i]==max){
                ans.add(i+1);
            }
        }

        Integer[] tmp = ans.toArray(new Integer[ans.size()]);
        int[] answer = Arrays.stream(tmp).mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public static void main(String[] args) {
        PrepareTest test = new PrepareTest();
        int[] problem = {1,3,2,4,2};
        System.out.println(Arrays.toString(test.solution(problem)));
    }
}
