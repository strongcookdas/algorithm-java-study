package algorithm.bfs.programmers;
/*
- BFS 활용
- 과정
    - 시작 단어를 큐에 추가
    - BFS 탐색 시작
        - 큐의 크기만큼 poll
        - poll한 단어와 words와 비교
            - 1글자 차이고 이전에 큐에 추가한 적이 없으면 큐에 추가
                - 큐에 추가한 적이 있는 단어는 다시 추가할 필요없다.
        - poll을 다 한 것은 한 레벨 탐색이 끝났다는 것 answer +1 한다.
- 제출 3번의 원인
    - answer +1의 위치를 잘못 구현
    - 자바 문법 이슈
        String은 length가 아닌 length()로 길이 반환
 */
import java.util.*;
public class 단어변환 {
    Queue<String> Q;
    int[] ch;

    public int getDifferenceWordCount(String s1, String s2){
        int count = 0;
        for(int i = 0; i<s1.length(); i++)
            if(s1.charAt(i) != s2.charAt(i)) count++;
        return count;
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Q = new LinkedList<>();
        ch = new int[words.length];
        Q.offer(begin);
        while(!Q.isEmpty()){
            int n = Q.size();
            for(int i = 0; i<n; i++){
                String tmp = Q.poll();
                if(tmp.equals(target)) return answer;
                for(int j = 0; j<words.length; j++){
                    if(getDifferenceWordCount(tmp,words[j])==1 && ch[j]==0){
                        ch[j] = 1;
                        Q.offer(words[j]);
                    }
                }
            }
            answer++;
        }
        return 0;
    }
}