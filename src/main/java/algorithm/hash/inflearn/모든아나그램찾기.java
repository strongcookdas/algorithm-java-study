package algorithm.hash.inflearn;

/**
 * 해시, 투포인터, 슬라이딩 윈도우, 이중 for문 사용
 */

import java.util.*;

public class 모든아나그램찾기 {
    String S,T;
    public int solution(){
        int N = T.length(), lt = 0, answer = 0;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(int i = 0; i<N; i++) tMap.put(T.charAt(i),tMap.getOrDefault(T.charAt(i),0)+1);
        for(int i = 0; i<S.length(); i++){
            if(i<N-1) sMap.put(S.charAt(i),sMap.getOrDefault(S.charAt(i),0)+1);
            else{
                sMap.put(S.charAt(i),sMap.getOrDefault(S.charAt(i),0)+1);
                if(sMap.equals(tMap)) answer++;
                if(sMap.get(S.charAt(lt))==1) sMap.remove(S.charAt(lt++));
                else sMap.put(S.charAt(lt),sMap.get(S.charAt(lt++))-1);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        모든아나그램찾기 main = new 모든아나그램찾기();
        main.S = kb.nextLine();
        main.T = kb.nextLine();
        System.out.println(main.solution());
    }
}
