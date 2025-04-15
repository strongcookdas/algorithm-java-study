package algorithm.bfs.boj;

/**
 * BFS 활용
 * DSLR 적용하면서 최단 적용 횟수를 찾는다.
 * 큐 2개 사용 숫자, 적용메뉴
 * 
 * 오답 원인
 * 방문 체크 큐로 함 poll하기 때문에 큐로 하면 안됨
 * 문제 잘못읽어 수식을 잘못세움
 */

import algorithm.Main;

import java.util.*;
import java.io.*;

public class DSLR9019 {
    static class Pos{
        int num;
        String str;
        public Pos(int num, String str){
            this.num = num;
            this.str = str;
        }
    }
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T--  > 0){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            String answer = solution(A,B);
            bw.write(answer+"\n");
        }


        br.close();
        bw.flush();
        bw.close();
    }

    public static String solution(int A, int B){
        Set<Integer> visit = new HashSet<>();
        visit.add(A);

        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(A,""));

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                Pos tmp = q.poll();
                if(tmp.num==B){
                    return tmp.str;
                }
                int d = D(tmp.num);
                if(!visit.contains(d)){
                    q.offer(new Pos(d, tmp.str+"D"));
                    visit.add(d);
                }
                int s = S(tmp.num);
                if(!visit.contains(s)){
                    q.offer(new Pos(s, tmp.str+"S"));
                    visit.add(s);
                }
                int l = L(tmp.num);
                if(!visit.contains(l)){
                    q.offer(new Pos(l, tmp.str+"L"));
                    visit.add(l);
                }
                int r = R(tmp.num);
                if(!visit.contains(r)){
                    q.offer(new Pos(r, tmp.str+"R"));
                    visit.add(r);
                }
            }
        }
        return null;
    }

    public static int D(int n){
        n*=2;
        if(n>9999){
            return n%10000;
        }else{
            return n;
        }
    }

    public static int S(int n){
        if(n==0){
            return 9999;
        }else{
            return n-1;
        }
    }

    public static int L(int n){
        int div = n/1000;
        int mod = n%1000;
        return mod*10+div;
    }

    public static int R(int n){
        int div = n/10;
        int mod = n%10;
        return mod*1000+div;
    }
}
