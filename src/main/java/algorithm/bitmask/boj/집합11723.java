package algorithm.bitmask.boj;

import java.util.*;
import java.io.*;

public class 집합11723 {
    static int bit = 0;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String menu = st.nextToken();
            int p = 0;
            switch(menu){
                case "add":
                    p = Integer.parseInt(st.nextToken());
                    add(p);
                    break;
                case "remove":
                    p = Integer.parseInt(st.nextToken());
                    remove(p);
                    break;
                case "check":
                    p = Integer.parseInt(st.nextToken());
                    int res = check(p);
                    bw.write(res+"\n");
                    break;
                case "toggle":
                    p = Integer.parseInt(st.nextToken());
                    toggle(p);
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;

            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void add(int p){
        //or 연산
        bit |= (1<<p);
    }

    public static void remove(int p){
        //and 연산
        bit &= ~(1<<p);
    }

    public static int check(int p){
        if((bit & (1<<p)) == (1<<p)){
            return 1;
        }
        return 0;
    }

    public static void all(){
        bit = (1<<21) -1;
    }

    public static void empty(){
        bit = 0;
    }

    public static void toggle(int p){
        //xor 연산
        bit ^= (1<<p);
    }
}
