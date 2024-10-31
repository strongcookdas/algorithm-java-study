package algorithm.sort.programmers;

import java.util.*;

class HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        int count = 0;
        Arrays.sort(citations);
        for(int i = citations.length-1; i>=0; i--){
            int citation = citations[i];
            count++;
            int tmp = Math.min(citation,count);
            answer = Math.max(tmp, answer);
        }
        return answer;
    }
}
