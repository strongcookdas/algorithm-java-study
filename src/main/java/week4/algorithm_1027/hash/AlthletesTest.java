package week4.algorithm_1027.hash;

import java.util.HashMap;
import java.util.Map;

public class AlthletesTest {

    public String solution(String[] participant, String[] completion){
        Map<String, Integer> memo = new HashMap<>();
        for(int i = 0; i < participant.length; i++){
            String key = participant[i];
            //memo.put(key,1);
            if(!memo.containsKey(key)){
                memo.put(key,0);
            }
            memo.put(key, memo.get(key) + 1);
        }
        for(int i = 0; i < completion.length; i++){
            String key = completion[i];
            memo.put(key, memo.get(key) - 1);
        }

        for(String key : memo.keySet()){
            if(memo.get(key) == 1){
                return key;
            }
        }
        return "";
    }

}
