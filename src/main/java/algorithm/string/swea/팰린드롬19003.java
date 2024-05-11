package algorithm.string.swea;
/*
해당 문제는 조합으로 푸는 것이 아닌 시뮬레이션으로 해결
1. 팰린드롬이 1개 이상이더라도 제일 긴 펠린드롬 1개만 사용 가능
2. 팰린드롬이 아닌 문자열 중 뒤집힌 문자열과 쌍을 이루는 문자열로 팰린드롬 구성 가능
 */
import java.util.*;

public class 팰린드롬19003 {
    public static int solution(int n, int m, ArrayList<String> list){
        int length = 0;
        for(String s : list){
            StringBuilder sb = new StringBuilder(s);
            if(s.equals(sb.reverse().toString())) length = Math.max(length, s.length());
        }
        for(int i = 0; i<n; i++){
            StringBuilder sb = new StringBuilder(list.get(i));
            String rS = sb.reverse().toString();
            for(int j = i+1; j<n; j++){
                if(list.get(j).equals(rS)) {
                    length+=(m*2);
                    break;
                }
            }
        }
        return length;
    }

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0; i<n; i++){
                list.add(sc.nextLine());
            }
            System.out.println("#"+test_case+" "+solution(n,m,list));
        }
    }
}
