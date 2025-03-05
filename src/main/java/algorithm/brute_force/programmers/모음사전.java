package algorithm.brute_force.programmers;

public class 모음사전 {
    char[] words = new char[]{'A', 'E', 'I', 'O', 'U'};
    StringBuilder sb = new StringBuilder();
    int idx = 0;
    boolean flag = false;

    public void dfs(String word){
        if(flag) return;
        if(sb.toString().equals(word)){
            flag = true;
            return;
        }
        if(sb.length()==5){
            return;
        }
        for(int i = 0; i<words.length; i++){
            sb.append(words[i]);
            idx++;
            dfs(word);
            if(flag) return;
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public int solution(String word) {
        dfs(word);
        return idx;
    }
}
