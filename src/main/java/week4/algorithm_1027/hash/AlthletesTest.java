package week4.algorithm_1027.hash;

import java.util.HashMap;
import java.util.Map;

public class AlthletesTest {

    /*
    설계
    1. HashMap에 모든 Participant를 put한다.
        a. key에 해당하는 값이 이미 존재한다면 그 값에 1을 더하도록 한다.
        b. key에 값이 없다면, 0으로 초기화 후 1을 더해주고, Map에 put 해준다.

    2. HashMap에 모든 Completion, 완주자를 put한다.
        a. 1을 빼준다.

    3. HashMap의 값이 0이 아닌 key를 반환
     */
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
