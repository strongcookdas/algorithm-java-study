package algorithm.bfs.programmers;

import java.util.*;
public class 단어변환 {
    public int bfs(String begin, String target, String[] words){
        boolean flag = false;
        for(String word : words){
            if(target.equals(word)){
                flag = true;
            }
        }
        if(!flag) return 0;

        Queue<String> q = new LinkedList<>();
        boolean[] ch = new boolean[words.length];
        int cnt = 0;

        q.offer(begin);

        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i<n; i++){
                String tmp = q.poll();
                if(tmp.equals(target)) return cnt;
                for(int j = 0; j<words.length; j++){
                    String word = words[j];
                    if(!ch[j] && compareStr(tmp, word)){
                        ch[j]= true;
                        q.offer(word);
                    }
                }
            }
            cnt++;
        }

        return 0;
    }

    public boolean compareStr(String begin, String target){
        int cnt = 0;
        for(int i = 0; i<target.length(); i++){
            if(begin.charAt(i)!=target.charAt(i)) cnt++;
        }
        return cnt==1;
    }

    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }
}