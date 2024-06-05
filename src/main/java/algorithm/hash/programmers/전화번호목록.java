package algorithm.hash.programmers;
/**
 * 해시맵 활용
 * 과정
 * 길이 기준으로 오름차순 정렬
 * 번호 순회
 * substring 사용해서 접두어 확인 최소 길이와 자신의 번호 길이만큼 반복 체크
 *      - 번호 길이는 1~20 사이 모든 경우를 체크
 *      - 있다면 false 리턴
 *      - 없다면 true 리턴
 * String 배열을 특별한 기준 없이 정렬할 경우 사전순으로 정렬됨다.
 * 이를 활용하면 해시맵을 사용하지 않고도 풀 수 있다.
 */

import java.util.*;

public class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (s1,s2)->Integer.compare(s1.length(),s2.length()));
        int shortNumLength = phone_book[0].length();
        HashMap<String, Integer> map = new HashMap<>();
        for(String number : phone_book){
            for(int i = shortNumLength; i<=number.length(); i++){
                String part = number.substring(0,Math.min(number.length(),i));
                if(map.containsKey(part)) return false;
            }
            map.put(number,1);
        }
        return true;
    }
}

/*
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }
        return true;
    }
}
 */