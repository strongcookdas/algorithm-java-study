package algorithm.hash.inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class 학급회장 {
    public void solution(int n, String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        int max = Integer.MIN_VALUE;
        Character st='A';
        for(Character key : map.keySet()){
            if(map.get(key)>max){
                max = map.get(key);
                st = key;
            }
        }
        System.out.println(st);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        학급회장 main = new 학급회장();
        int n = kb.nextInt();
        kb.nextLine();
        main.solution(n, kb.nextLine());
    }
}
