package algorithm.string.swea;

import java.util.*;

public class 회문1215 {
    public static int solution(int n, char[][] arr) {
        int answer = 0;
        for(int i = 0; i<8; i++) {
            for(int j = 0; j<=8-n; j++) {
                int lt = j;
                int rt = j+n-1;
                boolean check = true;
                while(lt<rt) {
                    if(arr[i][lt]!=arr[i][rt]) {
                        check = false;
                        break;
                    }
                    lt++;
                    rt--;
                }
                if(check) answer++;
                lt = j;
                rt = j+n-1;
                check = true;
                while(lt<rt) {
                    if(arr[lt][i]!=arr[rt][i]) {
                        check = false;
                        break;
                    }
                    lt++;
                    rt--;
                }
                if(check) answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        char[][] arr = new char[8][8];
        for(int t = 1; t<=10; t++) {
            int n = kb.nextInt();
            kb.nextLine();
            for(int i = 0; i<8; i++) {
                String line = kb.nextLine();
                for(int j = 0; j<8; j++) {
                    arr[i][j] = line.charAt(j);
                }
            }
            System.out.println("#"+t+" "+solution(n, arr));
        }
    }

}
