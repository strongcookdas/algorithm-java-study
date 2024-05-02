package algorithm.hash.swea;
/*
- 테스트 케이스 입력 형식 확인 잘 하자...
 */
import java.util.*;
public class 최빈수구하기1204 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            HashMap<Integer, Integer> map = new HashMap<>();
            int c = sc.nextInt();
            for(int i = 0; i<1000; i++){
                int n = sc.nextInt();
                map.put(n, map.getOrDefault(n,0)+1);
            }
            int max = Integer.MIN_VALUE;
            int max_idx = 0;
            for(Integer key : map.keySet()){
                if(map.get(key)>=max){
                    max = map.get(key);
                    max_idx = key;
                }
            }
            System.out.println("#"+test_case+" "+max_idx);
        }
    }
}
