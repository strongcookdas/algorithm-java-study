package algorithm.string.swea;

import java.util.*;
public class 회문1216 {

    public static int solution(char[][] arr) {
        int answer = 1;
        for(int i = 0; i<100; i++) {
            for(int k = answer+1; k<=100; k++ ) {
                for(int j = 0; j<=100-k; j++) {
                    int lt = j;
                    int rt = j+k-1;
                    boolean check = true;
                    while(lt<rt) {
                        if(arr[i][lt]!=arr[i][rt]) {
                            check = false;
                            break;
                        }
                        lt++;
                        rt--;
                    }
                    if(check) {
                        answer = k;
                        break;
                    }
                    lt = j;
                    rt = j+k-1;
                    check = true;
                    while(lt<rt) {
                        if(arr[lt][i]!=arr[rt][i]) {
                            check = false;
                            break;
                        }
                        lt++;
                        rt--;
                    }
                    if(check) {
                        answer = k;
                        break;
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        char[][] arr = new char[100][100];
        for(int t = 1; t<=10; t++) {
            int n = kb.nextInt();
            kb.nextLine();
            for(int i = 0; i<100; i++) {
                String str = kb.nextLine();
                for(int j = 0; j<100; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }
            System.out.println("#"+n+" "+solution(arr));
        }
    }

}
