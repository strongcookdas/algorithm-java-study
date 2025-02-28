package algorithm.brute_force.programmers;

import java.util.*;

public class 모의고사 {
    public int[] solution(int[] answers) {
        ArrayList<int[]> students = new ArrayList<>();
        students.add(new int[]{1,2,3,4,5});
        students.add(new int[]{2,1,2,3,2,4,2,5});
        students.add(new int[]{3,3,1,1,2,2,4,4,5,5,});

        int[] grade = new int[3];
        int max = 0;
        int idx = 0;
        for(int[] student : students){
            int cnt = 0;
            for(int i = 0; i<answers.length; i++){
                if(answers[i] == student[i%student.length]){
                    cnt++;
                }
            }
            if(cnt>max){
                max = cnt;
            }
            grade[idx++] = cnt;
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i<grade.length; i++){
            if(max == grade[i]){
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
