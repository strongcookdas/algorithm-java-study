package algorithm.string.swea;

import java.util.Scanner;
public class 회문의회문20019
{
    public static String solution(String str){
        char[] arr = str.toCharArray();
        int lt = 0, rt = arr.length-1;
        while(lt<rt){
            if(arr[lt++]!=arr[rt--])return "NO";
        }
        lt = 0;
        rt = arr.length/2-1;
        while(lt<rt){
            if(arr[lt++]!=arr[rt--])return "NO";
        }
        lt = arr.length/2+1;
        rt = arr.length-1;
        while(lt<rt){
            if(arr[lt++]!=arr[rt--])return "NO";
        }
        return "YES";
    }

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String str = sc.nextLine();
            System.out.println("#"+test_case+" "+solution(str));
        }
    }
}
